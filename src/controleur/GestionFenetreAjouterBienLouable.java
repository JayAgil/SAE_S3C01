package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.Batiment;
import modele.BienLouable;
import modele.dao.DaoBienLouable;
import vue.FenetreAjouterBienLouable;

public class GestionFenetreAjouterBienLouable extends GestionButtonFenetreAjouter {

	private FenetreAjouterBienLouable fenetre;
	private Batiment b;
	private GestionFenetreBienLouable parent;

	public GestionFenetreAjouterBienLouable(FenetreAjouterBienLouable fenetre, Batiment b,
			GestionFenetreBienLouable parent) {
		this.fenetre = fenetre;
		this.b = b;
		this.parent = parent;
		chargerComboBoxBienLouable();
	}

	/**
	 * Récupère tous les champs texte de la fenêtre pour le bien louable.
	 */
	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getAllBienLouableTextFields();
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
	 * crée un nouveau bien et met à jour la fenêtre parente.
	 */
	@Override
	protected void gererAction() {
		try {
			DaoBienLouable dao = new DaoBienLouable();
			List<JTextField> donnees = this.getTextFields();
			JComboBox<String> comboBox = this.fenetre.getComboBoxBienLouable();
			String idBienLie = (String) comboBox.getSelectedItem();
			BienLouable bl = null;

			if (idBienLie != null) {
				bl = dao.findById(idBienLie);
			}
			BienLouable bNouveau = new BienLouable(donnees.get(0).getText(), donnees.get(1).getText(),
					donnees.get(2).getText(), Double.parseDouble(donnees.get(3).getText()),
					Integer.parseInt(donnees.get(4).getText()), donnees.get(5).getText(), b, bl);
			if (dao.create(bNouveau) == 1) {
				JOptionPane.showMessageDialog(null, "Bien louable ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
				this.parent.chargerDonnees();
				this.fenetre.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout du bien louable.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Ce bien existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);

			}
		}

	}

	/**
	 * Remplit le comboBox avec les biens existants du bâtiment pour lier un bien.
	 */
	public void chargerComboBoxBienLouable() {
		JComboBox<String> comboBox = this.fenetre.getComboBoxBienLouable();
		comboBox.removeAllItems();
		comboBox.addItem(null);
		DaoBienLouable dao;
		try {
			dao = new DaoBienLouable();
			for (BienLouable bien : dao.findByBatiment(b.getAdresse())) {
				comboBox.addItem(bien.getIdBienLouable());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}