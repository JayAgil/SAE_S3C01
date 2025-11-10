package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterPaiement;
import vue.FenetreFacture;
import vue.FenetrePaiement;

public class GestionFenetrePaiement implements ActionListener {

    private FenetrePaiement fenetre;

    public GestionFenetrePaiement(FenetrePaiement fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Retour":
            fenetre.dispose();
            break;
        case "Ajouter Un Paiement":
        	FenetreAjouterPaiement fen = new FenetreAjouterPaiement();
        	fen.setVisible(true);
        	break;
        case "Generer le Facture":
        	FenetreFacture fen1 = new FenetreFacture();
        	fen1.setVisible(true);
        	break;
        }
    }


}
