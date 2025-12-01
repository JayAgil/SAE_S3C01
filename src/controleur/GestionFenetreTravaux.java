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
<<<<<<< HEAD
	}
	
	public void gererBoutonRetour() {
		FenetreBienLouable fenetreBienLouable = new FenetreBienLouable();
		fenetreBienLouable.setVisible(true);
		this.fenetreTravaux.dispose();
=======
		
		// JMenuItem
		if (source instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) source;
	        String texte = item.getText();
	        switch (texte) {
	        case "Déconnecter":
	        	FenetreLogin fenLogin = new FenetreLogin();
	        	fenLogin.setVisible(true);
	        	fenetreTravaux.dispose();
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
	        	FenetreCompteurs fenCompteurBat = new FenetreCompteurs();
	        	fenCompteurBat.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Charges bâtiment" :
	        	FenetreCharges fenChargesBat = new FenetreCharges();
	        	fenChargesBat.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Contrat location" :
	        	FenetreContratLocation fenContratLocation = new FenetreContratLocation();
	        	fenContratLocation.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Compteurs bien louable" :
	        	FenetreCompteurs fenCompteurBL = new FenetreCompteurs();
	        	fenCompteurBL.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Travaux" :
	        	FenetreTravaux fenTravaux = new FenetreTravaux();
	        	fenTravaux.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Charges bien louable" :
	        	FenetreCharges fenChargesBL = new FenetreCharges();
	        	fenChargesBL.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Diagnostics" :
	        	FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
	        	fenDiagnostic.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Locataires" :
	        	FenetreLocataire fenLocataire = new FenetreLocataire();
	        	fenLocataire.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Historique de paiement" :
	        	FenetrePaiement fenPaiement = new FenetrePaiement();
	        	fenPaiement.setVisible(true);
	        	fenetreTravaux.dispose();
	        	break;
	        case "Ajouter paiement" :
	        	FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
	        	fenetreTravaux.getLayeredPane().add(fenAjouterPaiement);
	        	fenAjouterPaiement.setVisible(true);
	        	break;
	        }
		}
		
>>>>>>> 5285a853d578134fc700a9805029302e2c41d341
	}
	
}
