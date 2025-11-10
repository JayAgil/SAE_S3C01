package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAssurance;

public class GestionFenetreAssurance implements ActionListener {

    private FenetreAssurance fenetre;

    public GestionFenetreAssurance(FenetreAssurance fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Retour":
            fenetre.dispose();
            break;
        }
    }

}
