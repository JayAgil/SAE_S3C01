package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import vue.FenetreAjouterBatiment;
import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterPaiement;
import vue.FenetreAjouterTravaux;
import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetreFacture;
import vue.FenetreLocataire;
import vue.FenetreLogin;
import vue.FenetrePaiement;
import vue.FenetreTravaux;

public class GestionFenetreTravaux extends GestionHeaderEtFooter implements ActionListener {
	
	private FenetreTravaux fenetreTravaux;
	
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
		super(fenetreTravaux);
		this.fenetreTravaux = fenetreTravaux;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// JButton
		if (source instanceof JButton) {
			JButton btn = (JButton) source;
	        String texte = btn.getText();
	        switch (texte) {
	        case "Ajouter travaux" :
				FenetreAjouterTravaux fenetreAjouterTravaux = new FenetreAjouterTravaux();
				fenetreTravaux.getLayeredPane().add(fenetreAjouterTravaux);
				fenetreAjouterTravaux.setVisible(true);	
				break;
			case "Ajouter entreprise" :
				FenetreAjouterEntreprise fenetreAjouterEntreprise = new FenetreAjouterEntreprise();
				fenetreTravaux.getLayeredPane().add(fenetreAjouterEntreprise);
				fenetreAjouterEntreprise.setVisible(true);
				break;
			case "Générer facture" :
				FenetreFacture fen = new FenetreFacture();
				fenetreTravaux.getLayeredPane().add(fen);
				fen.setVisible(true);
				break;
	        }
	     }
	}
	
	public void gererBoutonRetour() {
		FenetreBienLouable fenetreBienLouable = new FenetreBienLouable();
		fenetreBienLouable.setVisible(true);
		this.fenetreTravaux.dispose();
	}
	
}
