package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreCharges;
import vue.FenetrePrincipale;

public class GestionFenetreCharges implements ActionListener{
	
	private FenetreCharges fenetre;
	
	
	
	public GestionFenetreCharges(FenetreCharges fenetre) {
        this.fenetre = fenetre;
    }
	public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Quitter":
            fenetre.dispose();
            break;
        case "Retour" :
        	fenetre.dispose();
        	FenetrePrincipale fenPrincipale = new FenetrePrincipale();
        	fenPrincipale.setVisible(true);
        }
    }
}
