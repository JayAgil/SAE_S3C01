package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterBatiment;
import vue.FenetrePrincipale;

public class GestionFenetreAjouterBatiment implements ActionListener {

    private FenetreAjouterBatiment fenetre;

    public GestionFenetreAjouterBatiment(FenetreAjouterBatiment fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            break;
        case "Annuler":
        	// vider les champs !!
            fenetre.dispose();
            break;  
        case "Retour" :
        	fenetre.dispose();
        	break;
        }
    }

}