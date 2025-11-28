package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

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
import vue.FenetreSupprimerBatiment;
import vue.FenetreTravaux;

public class GestionFenetrePrincipale implements ActionListener {

    private FenetrePrincipale fenetre;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
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
	        case "Quitter":
	            fenetre.dispose();
	            break;
	        case "Assurance":
	            FenetreAssurance assurance = new FenetreAssurance();
	            fenetre.getLayeredPane().add(assurance);
	            assurance.setVisible(true);
	            break;
	        case "Compteurs":
	        	fenetre.dispose();
	        	FenetreCompteurs fenetreCompteurs = new FenetreCompteurs();
	        	fenetreCompteurs.setVisible(true);
	            break;
	        case "Charges":
	        	fenetre.dispose();
	            FenetreCharges charges = new FenetreCharges();
	            charges.setVisible(true);
	            break;
	        case "Ajouter":
	            FenetreAjouterBatiment ajout = new FenetreAjouterBatiment();
	            fenetre.getLayeredPane().add(ajout);
	            ajout.setVisible(true);
	            break;
	        case "Supprimer":
	            FenetreSupprimerBatiment supre = new FenetreSupprimerBatiment();
	            fenetre.getLayeredPane().add(supre);
	            supre.setVisible(true);
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
	        case "Supprimer bâtiment" :
	        	FenetreSupprimerBatiment fenSupprimerBatiment = new FenetreSupprimerBatiment();
	        	fenetre.getLayeredPane().add(fenSupprimerBatiment);
	        	fenSupprimerBatiment.setVisible(true);
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
	        case "Diagnostic" :
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

    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = fenetre.getTable().getSelectedRow();
            if (row != -1) {
                String contrat = (String) fenetre.getTable().getValueAt(row, 0);
                String date = (String) fenetre.getTable().getValueAt(row, 1);
                String bien = (String) fenetre.getTable().getValueAt(row, 2);
                String locataire = (String) fenetre.getTable()
                    .getValueAt(row, 3);
                FenetreBienLouable fen = new FenetreBienLouable();
                fen.setVisible(true);
            }
        }
    }
}