package controleur;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterCompteur;

public class GestionFenetreAjouterCompteur extends GestionButtonFenetreAjouter {
	private FenetreAjouterCompteur fenetre;

	public GestionFenetreAjouterCompteur(FenetreAjouterCompteur fenetre) {;
		this.fenetre = fenetre;
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
    protected void GererAction(String buttonText, ActionEvent e) {
    	
    }
}
	

