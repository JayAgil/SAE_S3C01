package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterAssurance;

public class GestionFenetreAjouterAssurance extends GestionButtonFenetreAjouter {

    private FenetreAjouterAssurance fenetre;

    public GestionFenetreAjouterAssurance(FenetreAjouterAssurance fenetre) {
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
    	
    }
    

}