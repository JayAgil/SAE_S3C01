package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterEntreprise;

public class GestionFenetreAjouterEntreprise implements ActionListener {

	private FenetreAjouterEntreprise fenetre;
	
	public GestionFenetreAjouterEntreprise(FenetreAjouterEntreprise fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Ajouter":
            // Mettre à jour la base de données
            break;
        case "Annuler":
			for (JTextField field : fenetre.getAllEntrepriseTextFields()) {
			    field.setText(""); 
			}
            break;   
        case "Retour":
        	fenetre.dispose();
        	break;
        }
	} 

}
