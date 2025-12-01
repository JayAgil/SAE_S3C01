package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterPaiement;

public class GestionFenetreAjouterPaiement implements ActionListener {

    private FenetreAjouterPaiement fenetre;

    public GestionFenetreAjouterPaiement(FenetreAjouterPaiement fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Retour":
            fenetre.dispose();
            break;
        case "Ajouter":
        	break;
        case "Vider" :
        	break;
        }
    }


}
