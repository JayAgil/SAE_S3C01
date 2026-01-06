package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.Entreprise;
import modele.dao.DaoEntreprise;
import vue.FenetreAjouterEntreprise;

public class GestionFenetreAjouterEntreprise extends GestionButtonFenetreAjouter {

	private FenetreAjouterEntreprise fenetre;
	
	public GestionFenetreAjouterEntreprise(FenetreAjouterEntreprise fenetre) {
		this.fenetre = fenetre;
	}

	@Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllEntrepriseTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	try {
			DaoEntreprise dao = new DaoEntreprise();
			List<JTextField> donnees = this.getTextFields();
			Entreprise e = new Entreprise(donnees.get(0).getText(),donnees.get(1).getText(),donnees.get(2).getText(),donnees.get(3).getText(),donnees.get(4).getText(),donnees.get(5).getText(),donnees.get(6).getText());
			if (dao.create(e) == 1) {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Entreprise ajoutée avec succès !", 
			        "Succès", 
			        JOptionPane.INFORMATION_MESSAGE
			    );
				this.fenetre.dispose();

			} else {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Échec de l'ajout de l'entreprise.", 
			        "Erreur", 
			        JOptionPane.ERROR_MESSAGE
			    );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e.getErrorCode() == 1) { 
		        JOptionPane.showMessageDialog(
		            null,
		            "Cette entreprise existe déjà (clé primaire).",
		            "Doublon",
		            JOptionPane.WARNING_MESSAGE
		        );
		    } else {
		        JOptionPane.showMessageDialog(
		            null,
		            "Erreur SQL : " + e.getMessage(),
		            "Erreur base de données",
		            JOptionPane.ERROR_MESSAGE
		        );
		    }
		}
		
    }
}
