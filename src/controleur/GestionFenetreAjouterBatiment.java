package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

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
    	
    }

}