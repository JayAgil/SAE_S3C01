package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterBienLouable;
import vue.FenetrePrincipale;

public class GestionFenetreAjouterBienLouable implements ActionListener {

    private FenetreAjouterBienLouable fenetre;

    public GestionFenetreAjouterBienLouable(FenetreAjouterBienLouable fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Ajouter":
            break;
        case "Annuler":
        	// vider les champs !!
            fenetre.dispose();
            break;  
        case "Retour" :
        	fenetre.dispose();
        	FenetrePrincipale fenPrincipale = new FenetrePrincipale();
        	fenPrincipale.setVisible(true);
        	break;
        }
    }

}