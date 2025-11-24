package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import vue.FenetreAjouterLocataire;
import vue.FenetreBienLouable;
import vue.FenetreLocataire;
import vue.FenetrePaiement;

public class GestionFenetreLocataire implements ActionListener {

	private FenetreLocataire fenetre;
	
	public GestionFenetreLocataire(FenetreLocataire fenetre) {
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Ajouter locataire":
            FenetreAjouterLocataire fenAjouterLocataire = new FenetreAjouterLocataire();
            fenetre.getLayeredPane().add(fenAjouterLocataire);
            fenAjouterLocataire.setVisible(true);
            break;
        case "Retour":
        	fenetre.dispose();
        	FenetreBienLouable fenBienLouable = new FenetreBienLouable();
        	fenBienLouable.setVisible(true);
        	break;
        case "Paiement" :
        	fenetre.dispose();
        	FenetrePaiement fenPaiement = new FenetrePaiement();
        	fenPaiement.setVisible(true);
        	break;
        }		
	} 

}


