package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import vue.FenetreAjouterPaiement;

public class GestionFenetreAjouterPaiement extends GestionButtonFenetreAjouter {

    private FenetreAjouterPaiement fenetre;

    public GestionFenetreAjouterPaiement(FenetreAjouterPaiement fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    protected List<JTextField> getTextFields() {
        return fenetre.getPaiementTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return fenetre;
    }
    
    @Override
	protected void gererAction() {
    	
    }


}
