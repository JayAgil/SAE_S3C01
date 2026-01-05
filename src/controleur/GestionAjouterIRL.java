package controleur;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import modele.IRL;
import modele.dao.DaoIRL;
import vue.FenetreAjouterIRL;

public class GestionAjouterIRL extends GestionButtonFenetreAjouter {
    
    private FenetreAjouterIRL fenetreAjouterIRL;
    
    public GestionAjouterIRL(FenetreAjouterIRL fenetreAjouterIRL) {
        this.fenetreAjouterIRL = fenetreAjouterIRL;
    }
    
    @Override
    protected List<JTextField> getTextFields() {
        return fenetreAjouterIRL.getAllTextFields();
    }
    
    @Override
    protected JInternalFrame getFrame() {
        return this.fenetreAjouterIRL;
    }
    
    @Override
	protected void gererAction() {
    	try {
			DaoIRL dao = new DaoIRL();
			List<JTextField> donnees = this.getTextFields();
			IRL irl = new IRL(donnees.get(0).getText()),null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        
    }

	
}