package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.Batiment;
import modele.dao.DaoBatiment;
import vue.FenetreAjouterBatiment;

public class GestionFenetreAjouterBatiment extends GestionButtonFenetreAjouter {

    private FenetreAjouterBatiment fenetre;

    public GestionFenetreAjouterBatiment(FenetreAjouterBatiment fenetre) {
        this.fenetre = fenetre;
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
			DaoBatiment dao = new DaoBatiment();
			List<JTextField> donnees = this.getTextFields();
			Batiment b = new Batiment (donnees.get(0).getText(),Date.valueOf(donnees.get(2).getText()));
			if (dao.create(b) == 1) {
				JOptionPane.showMessageDialog(null, "Batiment ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);
				this.fenetre.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout du batiment.", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Ce batiment existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		

    	
    }

}