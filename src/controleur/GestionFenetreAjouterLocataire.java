package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.ContratLocation;
import modele.Garant;
import modele.Locataire;
import modele.dao.DaoContratLocation;
import modele.dao.DaoGarant;
import modele.dao.DaoLocataire;
import vue.FenetreAjouterLocataire;

public class GestionFenetreAjouterLocataire extends GestionButtonFenetreAjouter {

	private FenetreAjouterLocataire fenetre;

	public GestionFenetreAjouterLocataire(FenetreAjouterLocataire fenetre) {
		this.fenetre = fenetre;
		chargerComboBoxContrat();
	}

	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getAllLocataireTextFields();
	}

	@Override
	protected JInternalFrame getFrame() {
		return fenetre;
	}

	@Override
	protected void gererAction() {

		try {

			DaoLocataire daoLocataire = new DaoLocataire();
			DaoGarant daoGarant = new DaoGarant();
			List<JTextField> donnees = this.getTextFields();
			Garant garant = new Garant(donnees.get(13).getText(), donnees.get(14).getText(), donnees.get(15).getText(),
					donnees.get(16).getText(), donnees.get(17).getText());

			daoGarant.create(garant);

			Locataire locataire = new Locataire(donnees.get(0).getText(), donnees.get(1).getText(),
					donnees.get(2).getText(), donnees.get(3).getText(), donnees.get(4).getText(),
					donnees.get(5).getText(), donnees.get(6).getText(), donnees.get(7).getText(),
					Date.valueOf(donnees.get(8).getText()), donnees.get(9).getText(),
					Double.parseDouble(donnees.get(10).getText()), donnees.get(11).getText(), donnees.get(12).getText(),
					garant);

			daoLocataire.create(locataire);
			ContratLocation contrat = (ContratLocation) fenetre.getComboBoxContrat().getSelectedItem();
			if (contrat != null) {
				daoLocataire.createContratLocataire(locataire, contrat);
			}

			JOptionPane.showMessageDialog(null, "Garant et locataire ajoutés avec succès !", "Succès",
					JOptionPane.INFORMATION_MESSAGE);
			this.fenetre.dispose();

		} catch (SQLException e) {
			e.printStackTrace();

			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Doublon détecté (clé primaire déjà existante).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Format invalide (date ou nombre).", "Erreur de saisie",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void chargerComboBoxContrat() {
		JComboBox<ContratLocation> comboBox = this.fenetre.getComboBoxContrat();
		comboBox.removeAllItems();
		DaoContratLocation dao;
		try {
			dao = new DaoContratLocation();
			for (ContratLocation cl : dao.findAll()) {
				comboBox.addItem(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
