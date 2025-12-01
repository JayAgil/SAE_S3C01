package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterContratLocation;
import vue.FenetrePrincipale;

public class GestionFenetreAjouterContratLocation implements ActionListener {

    private FenetreAjouterContratLocation fenetre;

    public GestionFenetreAjouterContratLocation(FenetreAjouterContratLocation fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            break;
        case "Annuler":
			for (JTextField field : fenetre.getAllContratTextFields()) {
			    field.setText(""); 
			}
            break;   
        case "Retour" :
        	fenetre.dispose();
        	break;
        }
    }

}