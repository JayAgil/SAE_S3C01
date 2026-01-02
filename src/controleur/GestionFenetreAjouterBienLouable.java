package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterBienLouable;

public class GestionFenetreAjouterBienLouable extends GestionButtonFenetreAjouter {

    private FenetreAjouterBienLouable fenetre;

    public GestionFenetreAjouterBienLouable(FenetreAjouterBienLouable fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllBienLouableTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	
    }

}