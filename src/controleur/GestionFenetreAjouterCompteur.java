package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.BienLouable;
import modele.Compteur;
import modele.dao.DaoCompteur;
import vue.FenetreAjouterCompteur;

public class GestionFenetreAjouterCompteur extends GestionButtonFenetreAjouter {
	private FenetreAjouterCompteur fenetre;
	private BienLouable b;
	private GestionFenetreCompteurs parent;

	public GestionFenetreAjouterCompteur(FenetreAjouterCompteur fenetre, BienLouable b, GestionFenetreCompteurs parent ) {;
		this.fenetre = fenetre;
		this.b = b;
		this.parent = parent;
	}
	
	@Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllCompteurTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	try {
			DaoCompteur dao = new DaoCompteur();
			List<JTextField> donnees = this.getTextFields();
			String type = (String) this.fenetre.getComboType().getSelectedItem();
			Compteur c = new Compteur(
					donnees.get(0).getText(),
	                Double.parseDouble(donnees.get(1).getText()),
	                Double.parseDouble(donnees.get(2).getText()),
	                Double.parseDouble(donnees.get(1).getText())
	                    + Double.parseDouble(donnees.get(2).getText()),
	                Date.valueOf(donnees.get(3).getText()), b,
	                Double.parseDouble(donnees.get(4).getText()),
	                Double.parseDouble(donnees.get(5).getText()), type
				);

			if (dao.create(c) == 1) {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Compteur ajoutée avec succès !", 
			        "Succès", 
			        JOptionPane.INFORMATION_MESSAGE
			    );
			    this.parent.setCpt(dao.findByIdBien(this.b.getIdBienLouable()));
			    this.parent.remplirTableCompteurs();
				this.fenetre.dispose();

			} else {
			    JOptionPane.showMessageDialog(
			        null, 
			        "Échec de l'ajout du compteur.", 
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
		            "Ce compteur existe déjà (clé primaire).",
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
	

