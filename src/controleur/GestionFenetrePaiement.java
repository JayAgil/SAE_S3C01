package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterPaiement;
import vue.FenetreFacture;
import vue.FenetreLocataire;
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
            FenetreLocataire fenLocataire = new FenetreLocataire();
            fenLocataire.setVisible(true);
            break;
        case "Ajouter paiement":
        	FenetreAjouterPaiement fen = new FenetreAjouterPaiement();
        	fenetre.getLayeredPane().add(fen);
        	fen.setVisible(true);
        	break;
        case "Generer le Facture":
        	FenetreFacture fen1 = new FenetreFacture();
        	fen1.setVisible(true);
        	break;
        }
    }


}
