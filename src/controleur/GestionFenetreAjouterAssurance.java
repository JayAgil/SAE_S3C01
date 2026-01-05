package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.Assurance;
import modele.Batiment;
import modele.dao.DaoAssurance;
import vue.FenetreAjouterAssurance;

public class GestionFenetreAjouterAssurance extends GestionButtonFenetreAjouter {

	private FenetreAjouterAssurance fenetre;
	private Batiment bat;

	public GestionFenetreAjouterAssurance(FenetreAjouterAssurance fenetre, Batiment b) {
		this.fenetre = fenetre;
		this.bat = b;
	}

	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getAllTextFields();
	}

	@Override
	protected JInternalFrame getFrame() {
		return fenetre;
	}

	@Override
	protected void gererAction() {
		try {
			DaoAssurance dao = new DaoAssurance();
			List<JTextField> donnees = this.getTextFields();
			Assurance a = new Assurance(donnees.get(0).getText(), Double.parseDouble(donnees.get(1).getText()),
					Double.parseDouble(donnees.get(2).getText()), donnees.get(3).getText(), bat,
					donnees.get(4).getText(), donnees.get(5).getText(), donnees.get(6).getText());
			if (dao.create(a) == 1) {
				JOptionPane.showMessageDialog(null, "Assurance ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
				this.fenetre.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout de l'assurance.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Cet assurance existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}