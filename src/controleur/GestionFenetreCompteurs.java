package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterCompteur;
import vue.FenetreCompteurs;
import vue.FenetrePrincipale;

public class GestionFenetreCompteurs implements ActionListener {
	
	 private FenetreCompteurs fenetre;

	 public GestionFenetreCompteurs(FenetreCompteurs fenetre) {
	        this.fenetre = fenetre;
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Retour":
        	fenetre.dispose();
        	FenetrePrincipale fenPrincipale = new FenetrePrincipale();
        	fenPrincipale.setVisible(true);
        	break;
        case "Ajouter compteur":
        	FenetreAjouterCompteur fenAjouterCompteur = new FenetreAjouterCompteur();
        	fenetre.getLayeredPane().add(fenAjouterCompteur);
        	fenAjouterCompteur.setVisible(true);
        	break;
        }
		
	}

}
