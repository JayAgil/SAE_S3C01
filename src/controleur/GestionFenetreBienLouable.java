package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.*;

import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetrePrincipale;
import vue.FenetreTravaux;

public class GestionFenetreBienLouable implements ActionListener {
	 
	private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
    	this.fenetrebienlouable= fenetre;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	switch (((JButton) e.getSource()).getText()) {
    	case "Diagnostics" :
    		FenetreDiagnostic fenDiagnostic = new FenetreDiagnostic();
    		fenetrebienlouable.getLayeredPane().add(fenDiagnostic);
    		fenDiagnostic.setVisible(true);
    		break;   		
    	case "Contrat":
    		FenetreContratLocation fenetrecontratlocation = new FenetreContratLocation();
        	fenetrebienlouable.getLayeredPane().add(fenetrecontratlocation);
        	fenetrecontratlocation.setVisible(true);
            break;
    	case "Charges":
    		fenetrebienlouable.dispose();
			FenetreCharges fenetreCharges= new FenetreCharges();
			fenetreCharges.setVisible(true);
			break;
    	case "Travaux" :
    		FenetreTravaux fenTravaux = new FenetreTravaux();
    		fenetrebienlouable.getLayeredPane().add(fenTravaux);
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
    }

