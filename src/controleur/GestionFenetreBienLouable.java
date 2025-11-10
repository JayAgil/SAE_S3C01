package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.*;

import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreContratLocation;
import vue.FenetrePrincipale;

public class GestionFenetreBienLouable implements ActionListener {
	 
	private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
    	this.fenetrebienlouable= fenetre;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	switch (((JButton) e.getSource()).getText()) {
    	case "Contrat":
    		System.out.println("Contrat");
    		FenetreContratLocation fenetrecontratlocation = new FenetreContratLocation();
        	fenetrebienlouable.getLayeredPane().add(fenetrecontratlocation);
        	fenetrecontratlocation.setVisible(true);
            break;
    	case "Charges":
			FenetreCharges fenetreCharges= new FenetreCharges();
			fenetrebienlouable.getLayeredPane().add(fenetreCharges);
			fenetreCharges.setVisible(true);
        break;
    	case "Quitter":
    		System.out.println("Quitter");
    		fenetrebienlouable.dispose();
    		break;
            }
    	}
    }

