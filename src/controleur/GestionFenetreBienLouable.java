package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import vue.FenetreAjouterBatiment;
import vue.FenetreAjouterPaiement;
import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetreLocataire;
import vue.FenetreLogin;
import vue.FenetrePaiement;
import vue.FenetrePrincipale;
import vue.FenetreTravaux;

public class GestionFenetreBienLouable implements ActionListener {
	 
	private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
    	this.fenetrebienlouable= fenetre;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
    	if (source instanceof JButton) {
			JButton btn = (JButton) source;
	        String texte = btn.getText();
	        switch (texte) {
	    	case "Diagnostics" :
	    		fenetrebienlouable.dispose();
	    		FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
	    		fenDiagnostic.setVisible(true);
	    		break;   		
	    	case "Contrat":
	    		fenetrebienlouable.dispose();
	    		FenetreContratLocation fenetrecontratlocation = new FenetreContratLocation();
	        	fenetrecontratlocation.setVisible(true);
	            break;
	    	case "Charges":
	    		fenetrebienlouable.dispose();
				FenetreCharges fenetreCharges= new FenetreCharges();
				fenetreCharges.setVisible(true);
				break;
	    	case "Travaux" :
	    		fenetrebienlouable.dispose();
	    		FenetreTravaux fenTravaux = new FenetreTravaux();
	    		fenTravaux.setVisible(true);
	    		break;
	    	case "Retour":
	    		fenetrebienlouable.dispose();
	    		FenetrePrincipale fenPrincipale = new FenetrePrincipale();
	    		fenPrincipale.setVisible(true);
	    		break;
	    	case "Compteur" :
	    		fenetrebienlouable.dispose();
	    		FenetreCompteurs fenCompteur = new FenetreCompteurs();
	    		fenCompteur.setVisible(true);
	    		break;
	    	case "Revaloriser" :
	    		break;
	        }
    	}
    	
    	if (source instanceof JMenuItem) {
     		JMenuItem item = (JMenuItem) source;
     	    String texte = item.getText();
     	    switch (texte) {
     	    case "Déconnecter":
     	    	fenetrebienlouable.dispose();
     	        FenetreLogin fenLogin = new FenetreLogin();
     	        fenLogin.setVisible(true);
     	        break;
     	    case "Ajouter bâtiment" :
     	        FenetreAjouterBatiment fenAjouterBatiment = new FenetreAjouterBatiment();
     	       fenetrebienlouable.getLayeredPane().add(fenAjouterBatiment);
     	        fenAjouterBatiment.setVisible(true);
     	        break;
     	    case "Assurance" :
     	        FenetreAssurance fenAssurance = new FenetreAssurance();
     	       fenetrebienlouable.getLayeredPane().add(fenAssurance);
     	        fenAssurance.setVisible(true);
     	        break;
     	    case "Compteurs bâtiment" :
     	    	fenetrebienlouable.dispose();
     	        FenetreCompteurs fenCompteurBat = new FenetreCompteurs();
     	        fenCompteurBat.setVisible(true);
     	        break;
     	    case "Charges bâtiment" :
     	    	fenetrebienlouable.dispose();
     	        FenetreCharges fenChargesBat = new FenetreCharges();
     	        fenChargesBat.setVisible(true);
     	        break;
     	    case "Contrat location" :
     	    	fenetrebienlouable.dispose();
     	        FenetreContratLocation fenContratLocation = new FenetreContratLocation();
     	        fenContratLocation.setVisible(true);
     	        break;
     	    case "Compteurs bien louable" :
     	    	fenetrebienlouable.dispose();
     	        FenetreCompteurs fenCompteurBL = new FenetreCompteurs();
     	        fenCompteurBL.setVisible(true);
     	        break;
     	    case "Travaux" :
     	    	fenetrebienlouable.dispose();
     	        FenetreTravaux fenTravaux = new FenetreTravaux();
     	        fenTravaux.setVisible(true);
     	        break;
     	    case "Charges bien louable" :
     	    	fenetrebienlouable.dispose();
     	        FenetreCharges fenChargesBL = new FenetreCharges();
     	        fenChargesBL.setVisible(true);
     	        break;
     	    case "Diagnostics" :
     	    	fenetrebienlouable.dispose();
     	        FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
     	        fenDiagnostic.setVisible(true);
     	        break;
     	    case "Locataires" :
     	    	fenetrebienlouable.dispose();
     	        FenetreLocataire fenLocataire = new FenetreLocataire();
     	        fenLocataire.setVisible(true);
     	        break;
     	    case "Historique de paiement" :
     	    	fenetrebienlouable.dispose();
     	        FenetrePaiement fenPaiement = new FenetrePaiement();
     	        fenPaiement.setVisible(true);
     	        break;
     	    case "Ajouter paiement" :
     	        FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
     	       fenetrebienlouable.getLayeredPane().add(fenAjouterPaiement);
     	        fenAjouterPaiement.setVisible(true);
     	        break;        	     
     	    }			
     	}
    	
    }
}

