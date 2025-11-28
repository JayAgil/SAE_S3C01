package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import vue.FenetreAjouterBatiment;
import vue.FenetreAjouterPaiement;
import vue.FenetreAssurance;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetreLocataire;
import vue.FenetreLogin;
import vue.FenetrePaiement;
import vue.FenetreTravaux;

public class GestionFenetreAssurance implements ActionListener {

    private FenetreAssurance fenetre;

    public GestionFenetreAssurance(FenetreAssurance fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Object source = e.getSource();
		// JButton
		if (source instanceof JButton) {
			JButton btn = (JButton) source;
	        String texte = btn.getText();
	        switch (texte) {
	        case "Retour":
	            fenetre.dispose();
	            break;
	        }
	     }
		
		// JMenuItem
		if (source instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) source;
	        String texte = item.getText();
	        switch (texte) {
	        case "Déconnecter":
	        	fenetre.dispose();
	        	FenetreLogin fenLogin = new FenetreLogin();
	        	fenLogin.setVisible(true);
	        	break;
	        case "Ajouter bâtiment" :
	        	FenetreAjouterBatiment fenAjouterBatiment = new FenetreAjouterBatiment();
	        	fenetre.getLayeredPane().add(fenAjouterBatiment);
	        	fenAjouterBatiment.setVisible(true);
	        	break;
	        case "Assurance" :
	        	FenetreAssurance fenAssurance = new FenetreAssurance();
	        	fenetre.getLayeredPane().add(fenAssurance);
	        	fenAssurance.setVisible(true);
	        	break;
	        case "Compteurs bâtiment" :
	        	fenetre.dispose();
	        	FenetreCompteurs fenCompteurBat = new FenetreCompteurs();
	        	fenCompteurBat.setVisible(true);
	        	break;
	        case "Charges bâtiment" :
	        	fenetre.dispose();
	        	FenetreCharges fenChargesBat = new FenetreCharges();
	        	fenChargesBat.setVisible(true);
	        	break;
	        case "Contrat location" :
	        	fenetre.dispose();
	        	FenetreContratLocation fenContratLocation = new FenetreContratLocation();
	        	fenContratLocation.setVisible(true);
	        	break;
	        case "Compteurs bien louable" :
	        	fenetre.dispose();
	        	FenetreCompteurs fenCompteurBL = new FenetreCompteurs();
	        	fenCompteurBL.setVisible(true);
	        	break;
	        case "Travaux" :
	        	fenetre.dispose();
	        	FenetreTravaux fenTravaux = new FenetreTravaux();
	        	fenTravaux.setVisible(true);
	        	break;
	        case "Charges bien louable" :
	        	fenetre.dispose();
	        	FenetreCharges fenChargesBL = new FenetreCharges();
	        	fenChargesBL.setVisible(true);
	        	break;
	        case "Diagnostics" :
	        	fenetre.dispose();
	        	FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
	        	fenDiagnostic.setVisible(true);
	        	break;
	        case "Locataires" :
	        	fenetre.dispose();
	        	FenetreLocataire fenLocataire = new FenetreLocataire();
	        	fenLocataire.setVisible(true);
	        	break;
	        case "Historique de paiement" :
	        	fenetre.dispose();
	        	FenetrePaiement fenPaiement = new FenetrePaiement();
	        	fenPaiement.setVisible(true);
	        	break;
	        case "Ajouter paiement" :
	        	FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
	        	fenetre.getLayeredPane().add(fenAjouterPaiement);
	        	fenAjouterPaiement.setVisible(true);
	        	break;
	        }
		}
        
    }

}
