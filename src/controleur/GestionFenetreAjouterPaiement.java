package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterPaiement;
import vue.FenetrePaiement;

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
            FenetrePaiement fenPaiement = new FenetrePaiement();
            fenPaiement.setVisible(true);
            break;
        case "Ajouter":
        	break;
        }
    }


}
