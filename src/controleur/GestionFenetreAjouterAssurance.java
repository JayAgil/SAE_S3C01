package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vue.FenetreAjouterAssurance;

public class GestionFenetreAjouterAssurance implements ActionListener {

    private FenetreAjouterAssurance fenetre;

    public GestionFenetreAjouterAssurance(FenetreAjouterAssurance fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            break;
        case "Vider":
			for (JTextField field : fenetre.getAllTextFields()) {
			    field.setText(""); 
			}
            break;  
        case "Retour" :
        	fenetre.dispose();
        	break;
        }
    }

}