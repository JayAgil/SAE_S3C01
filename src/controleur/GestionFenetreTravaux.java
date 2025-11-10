package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreTravaux;

public class GestionFenetreTravaux implements ActionListener {
	
	private FenetreTravaux fenetreTravaux;
	
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
		this.fenetreTravaux = fenetreTravaux;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch(((JButton)e.getSource()).getText()) {
		case "Ajouter travaux" :
			this.fenetreTravaux.dispose();
			FenetreAjouterTravaux fenetreAjouterTravaux = new FenetreAjouterTravaux();
			fenetreAjouterTravaux.setVisible(true);	
			break;
		case "Ajouter entreprise" :
			this.fenetreTravaux.dispose();
			FenetreAjouterEntreprise fenetreAjouterEntreprise = new FenetreAjouterEntreprise();
			fenetreAjouterEntreprise.setVisible(true);
			break;
		case "Générer facture" :
			break;
		case "Retour" :
			this.fenetreTravaux.dispose();
			FenetreBienLouable fenetreBienLouable = new FenetreBienLouable();
			fenetreBienLouable.setVisible(true);
			break;
		case "Quitter":
			this.fenetreTravaux.dispose();
			break;
		}
	}
	
}
