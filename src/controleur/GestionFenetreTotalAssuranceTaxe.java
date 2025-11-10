package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreTotalAssuranceTaxe;

public class GestionFenetreTotalAssuranceTaxe implements ActionListener {
    private FenetreTotalAssuranceTaxe fenetreTotalAssuranceTaxe;

    public GestionFenetreTotalAssuranceTaxe(FenetreTotalAssuranceTaxe fenetre) {
        this.fenetreTotalAssuranceTaxe = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Quitter":
            fenetreTotalAssuranceTaxe.dispose();
            break;
        }
    }
}
