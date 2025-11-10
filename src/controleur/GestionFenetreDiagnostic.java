package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreDiagnostic;

public class GestionFenetreDiagnostic implements ActionListener {

    private FenetreDiagnostic fenetre;

    public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Retour":
            fenetre.dispose();
            break;
        case "obtenir":
            // permet de telecharger la fiche de diagnostique choisi
            fenetre.dispose();
            break;
        }
    }

}
