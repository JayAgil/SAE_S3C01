package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.BienLouable;
import modele.ContratLocation;
import modele.dao.DaoContratLocation;
import vue.FenetreAjouterContratLocation;

public class GestionFenetreAjouterContratLocation extends GestionButtonFenetreAjouter {

	private FenetreAjouterContratLocation fenetre;
	private BienLouable bl;
	private GestionFenetreContratLocation parent;

	public GestionFenetreAjouterContratLocation(FenetreAjouterContratLocation fenetre, BienLouable bl,
			GestionFenetreContratLocation parent) {
		this.fenetre = fenetre;
		this.bl = bl;
		this.parent = parent;
	}

	/**
	 * Récupère tous les champs texte de la fenêtre pour le contrat.
	 */
	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getAllContratTextFields();
	}

	/**
	 * Retourne la fenêtre gérée par ce contrôleur.
	 */
	@Override
	protected JInternalFrame getFrame() {
		return fenetre;
	}

	/**
	 * Action exécutée lors du clic sur le bouton "Ajouter". Récupère les données,
	 * crée un nouveau contrat et met à jour la fenêtre parente.
	 */
	@Override
	protected void gererAction() {
		try {
			DaoContratLocation dao = new DaoContratLocation();
			List<JTextField> donnees = this.getTextFields();

			Date dateDebut = Date.valueOf(donnees.get(1).getText());
			Date dateFin = Date.valueOf(donnees.get(2).getText());

			if (!dateFin.after(dateDebut)) {
				JOptionPane.showMessageDialog(null, "La date de fin doit être après la date de début.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			ContratLocation cl = new ContratLocation(donnees.get(0).getText(), // String numeroDeContrat
					dateDebut, dateFin, Double.parseDouble(donnees.get(3).getText()), // double montantDeCaution
					Double.parseDouble(donnees.get(4).getText()), // double provisionCharge
					Double.parseDouble(donnees.get(5).getText()), // double solde
					Double.parseDouble(donnees.get(6).getText()), // double montantMensuel
					Date.valueOf(donnees.get(7).getText()), // Date dateVersement
					Double.parseDouble(donnees.get(8).getText()), // double indexCompteurEau
					Double.parseDouble(donnees.get(9).getText()), // double indexCompteurElectricite
					Double.parseDouble(donnees.get(10).getText()), // double indexCompteurGaz
					bl // BienLouable
			);

			if (dao.create(cl) == 1) {
				JOptionPane.showMessageDialog(null, "Contrat location ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);

				if (parent != null) {
					parent.setContrats(parent.getDonneesContrats());
					parent.remplirTable();
				}
				this.fenetre.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout du contrat location.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Ce contrat existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}