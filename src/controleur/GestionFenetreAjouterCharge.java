package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterCharge;

public class GestionFenetreAjouterCharge implements ActionListener {

    private FenetreAjouterCharge fenetre;

    public GestionFenetreAjouterCharge(FenetreAjouterCharge fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            // Mettre à jour la base de données
            break;
        case "Annuler":
        	//vider champs
        	fenetre.dispose();
        	break;
        case "Retour" :
        	fenetre.dispose();
        	break;

        }
    }


}
