package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterContratLocation;

public class GestionFenetreAjouterContratLocation extends GestionButtonFenetreAjouter {

    private FenetreAjouterContratLocation fenetre;

    public GestionFenetreAjouterContratLocation(FenetreAjouterContratLocation fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllContratTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	
    }
}