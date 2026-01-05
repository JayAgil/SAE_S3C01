package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import modele.ChargesGenerales;
import modele.dao.DaoChargesGenerales;
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
	protected void gererAction() {
    	try {
			DaoChargesGenerales dao = new DaoChargesGenerales();
			List<JTextField> donnees = this.getTextFields();
			ChargesGenerales cg = new ChargesGenerales(donnees.get(0).getText(),donnees.get(1).getText(),Double.parseDouble(donnees.get(2).getText())), 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }


}
