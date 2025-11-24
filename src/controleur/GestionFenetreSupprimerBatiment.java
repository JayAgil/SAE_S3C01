package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetrePrincipale;
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
            break;
        case "Annuler":
        	//Vider champ
            fenetre.dispose();
            break;
        case "Retour" :
        	fenetre.dispose();
        	FenetrePrincipale fenPrincipale = new FenetrePrincipale();
        	fenPrincipale.setVisible(true);
        }
    }
}
