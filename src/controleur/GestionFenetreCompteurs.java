package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreCompteurs;

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
        	break;
        case "Ajouter Compteur":
        	break;
        }
		
	}

}
