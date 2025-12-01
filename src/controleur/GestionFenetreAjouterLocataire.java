package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterLocataire;

public class GestionFenetreAjouterLocataire implements ActionListener {

	private FenetreAjouterLocataire fenetre;
	
	public GestionFenetreAjouterLocataire(FenetreAjouterLocataire fenetre) {
		this.fenetre = fenetre;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Ajouter":
            // Mettre à jour la base de données
            break;
        case "Vider":
        	for (JTextField field : fenetre.getAllLocataireTextFields()) {
			    field.setText(""); 
			}
        	break;
        case "Retour" :
        	fenetre.dispose();
        	break;
        }		
	}
	
	
	
	
}
