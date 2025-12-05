package controleur;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterCharge;

public class GestionFenetreAjouterCharge extends GestionButtonFenetreAjouter {

    private FenetreAjouterCharge fenetre;

    public GestionFenetreAjouterCharge(FenetreAjouterCharge fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    protected List<JTextField> getTextFields() {
        return fenetre.getAllChargeTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
    protected void GererAction(String buttonText, ActionEvent e) {
    	
    }


}
