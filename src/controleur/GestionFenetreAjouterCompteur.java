package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterCompteur;

public class GestionFenetreAjouterCompteur implements ActionListener {
	private FenetreAjouterCompteur fenetre;

	public GestionFenetreAjouterCompteur(FenetreAjouterCompteur fenetre) {;
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    switch (((JButton) e.getSource()).getText()) {
	    case "Retour":
	    	fenetre.dispose();
	    	break;            
	    case "Annuler":
			for (JTextField field : fenetre.getAllPaiementTextFields()) {
			    field.setText(""); 
			}
            break; 
	    case "Ajouter" :
	    	// Mettre à jour la base de données
	    	break;

	    }
	}
}
	

