package controleur;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import vue.FenetreTotalAssuranceTaxe;

public class GestionFenetreTotalAssuranceTaxe extends GestionHeaderEtFooter {
    private FenetreTotalAssuranceTaxe fenetreTotalAssuranceTaxe;

    public GestionFenetreTotalAssuranceTaxe(FenetreTotalAssuranceTaxe fenetre) {
		super(fenetre);
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
