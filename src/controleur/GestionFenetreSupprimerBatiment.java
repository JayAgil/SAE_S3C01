package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreSupprimerBatiment;

public class GestionFenetreSupprimerBatiment implements ActionListener {

    private FenetreSupprimerBatiment fenetre;

    public GestionFenetreSupprimerBatiment(FenetreSupprimerBatiment fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Valider":
            fenetre.dispose();
            break;
        case "Annuler":
            fenetre.dispose();
            break;
        }
    }
}
