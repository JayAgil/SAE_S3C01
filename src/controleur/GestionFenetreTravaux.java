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
import vue.FenetreLocataire;
import vue.FenetreLogin;
import vue.FenetrePaiement;
import vue.FenetreTravaux;

public class GestionFenetreTravaux implements ActionListener {
	
	private FenetreTravaux fenetreTravaux;
	
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux) {
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
				break;
			case "Retour" :
				this.fenetreTravaux.dispose();
				FenetreBienLouable fenetreBienLouable = new FenetreBienLouable();
				fenetreBienLouable.setVisible(true);
				break;
	        }
	     }
		
		// JMenuItem
		if (source instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) source;
	        String texte = item.getText();
	        switch (texte) {
	        case "Déconnecter":
	        	fenetreTravaux.dispose();
	        	FenetreLogin fenLogin = new FenetreLogin();
	        	fenLogin.setVisible(true);
	        	break;
	        case "Ajouter bâtiment" :
	        	FenetreAjouterBatiment fenAjouterBatiment = new FenetreAjouterBatiment();
	        	fenetreTravaux.getLayeredPane().add(fenAjouterBatiment);
	        	fenAjouterBatiment.setVisible(true);
	        	break;
	        case "Assurance" :
	        	FenetreAssurance fenAssurance = new FenetreAssurance();
	        	fenetreTravaux.getLayeredPane().add(fenAssurance);
	        	fenAssurance.setVisible(true);
	        	break;
	        case "Compteurs bâtiment" :
	        	fenetreTravaux.dispose();
	        	FenetreCompteurs fenCompteurBat = new FenetreCompteurs();
	        	fenCompteurBat.setVisible(true);
	        	break;
	        case "Charges bâtiment" :
	        	fenetreTravaux.dispose();
	        	FenetreCharges fenChargesBat = new FenetreCharges();
	        	fenChargesBat.setVisible(true);
	        	break;
	        case "Contrat location" :
	        	fenetreTravaux.dispose();
	        	FenetreContratLocation fenContratLocation = new FenetreContratLocation();
	        	fenContratLocation.setVisible(true);
	        	break;
	        case "Compteurs bien louable" :
	        	fenetreTravaux.dispose();
	        	FenetreCompteurs fenCompteurBL = new FenetreCompteurs();
	        	fenCompteurBL.setVisible(true);
	        	break;
	        case "Travaux" :
	        	fenetreTravaux.dispose();
	        	FenetreTravaux fenTravaux = new FenetreTravaux();
	        	fenTravaux.setVisible(true);
	        	break;
	        case "Charges bien louable" :
	        	fenetreTravaux.dispose();
	        	FenetreCharges fenChargesBL = new FenetreCharges();
	        	fenChargesBL.setVisible(true);
	        	break;
	        case "Diagnostic" :
	        	fenetreTravaux.dispose();
	        	FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
	        	fenDiagnostic.setVisible(true);
	        	break;
	        case "Locataires" :
	        	fenetreTravaux.dispose();
	        	FenetreLocataire fenLocataire = new FenetreLocataire();
	        	fenLocataire.setVisible(true);
	        	break;
	        case "Historique de paiement" :
	        	fenetreTravaux.dispose();
	        	FenetrePaiement fenPaiement = new FenetrePaiement();
	        	fenPaiement.setVisible(true);
	        	break;
	        case "Ajouter paiement" :
	        	FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
	        	fenetreTravaux.getLayeredPane().add(fenAjouterPaiement);
	        	fenAjouterPaiement.setVisible(true);
	        	break;
	        }
		}
		
	}
	
}
