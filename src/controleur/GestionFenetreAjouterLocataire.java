package controleur;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterLocataire;

public class GestionFenetreAjouterLocataire extends GestionButtonFenetreAjouter {

	private FenetreAjouterLocataire fenetre;
	
	public GestionFenetreAjouterLocataire(FenetreAjouterLocataire fenetre) {
		this.fenetre = fenetre;
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
    protected void GererAction(String buttonText, ActionEvent e) {
    	
    }
	
}
