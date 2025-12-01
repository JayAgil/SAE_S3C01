package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterCharge;

public class GestionFenetreAjouterCharge implements ActionListener {

    private FenetreAjouterCharge fenetre;

    public GestionFenetreAjouterCharge(FenetreAjouterCharge fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            // Mettre à jour la base de données
            break;
        case "Vider":
			for (JTextField field : fenetre.getAllChargeTextFields()) {
			    field.setText(""); 
			}
            break; 
        case "Retour" :
        	fenetre.dispose();
        	break;

        }
    }


}
