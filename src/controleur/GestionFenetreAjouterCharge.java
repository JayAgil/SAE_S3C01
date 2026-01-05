package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import modele.BienLouable;
import modele.ChargesGenerales;
import modele.dao.DaoChargesGenerales;
import vue.FenetreAjouterCharge;

public class GestionFenetreAjouterCharge extends GestionButtonFenetreAjouter {

	private FenetreAjouterCharge fenetre;
	private BienLouable b;

	public GestionFenetreAjouterCharge(FenetreAjouterCharge fenetre, BienLouable b) {
		this.fenetre = fenetre;
		this.b = b;
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
			ChargesGenerales cg = new ChargesGenerales(donnees.get(0).getText(),donnees.get(1).getText(),Double.parseDouble(donnees.get(2).getText()), 
					Float.parseFloat(donnees.get(3).getText()),Double.parseDouble(donnees.get(4).getText()), Date.valueOf(donnees.get(5).getText()),b);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

}
