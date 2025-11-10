package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreContratLocation;

public class GestionFenetreContratLocation implements ActionListener {

    private FenetreContratLocation fenetre;

    public GestionFenetreContratLocation(FenetreContratLocation fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":

            break;
        case "Annuler":
            fenetre.dispose();
            break;
        }
    }

}
