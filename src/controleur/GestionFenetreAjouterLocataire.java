package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterLocataire;
import vue.FenetreLocataire;

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
        case "Annuler":
        	fenetre.dispose();
        	FenetreLocataire fenLocataire = new FenetreLocataire();
        	fenLocataire.setVisible(true);
        	break;
        }		
	}
	
	
}
