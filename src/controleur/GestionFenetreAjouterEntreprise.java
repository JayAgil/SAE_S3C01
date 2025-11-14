package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterLocataire;

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
        	fenetre.dispose();
        	break;
        }		
	} 

}
