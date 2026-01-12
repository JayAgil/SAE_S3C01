package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.IRL;
import modele.dao.DaoIRL;
import vue.FenetreAjouterIRL;

public class GestionAjouterIRL extends GestionButtonFenetreAjouter {

	private FenetreAjouterIRL fenetreAjouterIRL;

	public GestionAjouterIRL(FenetreAjouterIRL fenetreAjouterIRL) {
		this.fenetreAjouterIRL = fenetreAjouterIRL;
	}

	/**
	 * Récupère tous les JTextFields de la fenêtre pour lire les données saisies.
	 * 
	 * @return liste des champs texte
	 */
	@Override
	protected List<JTextField> getTextFields() {
		return fenetreAjouterIRL.getAllTextFields();
	}

	/**
	 * Récupère la fenêtre interne associée.
	 * 
	 * @return JInternalFrame correspondant à fenetreAjouterIRL
	 */
	@Override
	protected JInternalFrame getFrame() {
		return this.fenetreAjouterIRL;
	}

	/**
	 * Gère l'action de création de l'IRL. - Vérifie la validité des données saisies
	 * - Crée un objet IRL - Tente l'insertion en base via DaoIRL - Affiche un
	 * message de succès ou d'erreur
	 */
	@Override
	protected void gererAction() {
		try {
			DaoIRL dao = new DaoIRL();
			List<JTextField> donnees = this.getTextFields();
			if (Double.parseDouble(donnees.get(1).getText()) > 4 || Double.parseDouble(donnees.get(1).getText()) < 0) {
				JOptionPane.showMessageDialog(null, "La valeur de trimestre doit être compris entre 1 et 4 !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			IRL irl = new IRL(Integer.parseInt(donnees.get(0).getText()), Integer.parseInt(donnees.get(1).getText()),
					Double.parseDouble(donnees.get(2).getText()));
			if (dao.create(irl) == 1) {
				JOptionPane.showMessageDialog(null, "IRL ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
				this.fenetreAjouterIRL.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout de l'IRL.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();

			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Cet IRL existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}