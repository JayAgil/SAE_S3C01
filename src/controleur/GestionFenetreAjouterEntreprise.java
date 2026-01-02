package controleur;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

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
    	
    }
}
