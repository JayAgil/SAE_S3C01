package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vue.FenetreAjouterBatiment;
import vue.FenetreAssurance;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetrePrincipale;
import vue.FenetreSupprimerBatiment;

public class GestionFenetrePrincipale implements ActionListener {

    private FenetrePrincipale fenetre;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Quitter":
            fenetre.dispose();
            break;
        case "Assurance":
            FenetreAssurance assurance = new FenetreAssurance();
            fenetre.getLayeredPane().add(assurance);
            assurance.setVisible(true);
            break;
        case "Compteurs":
        	FenetreCompteurs fenetreCompteurs = new FenetreCompteurs();
        	fenetre.getLayeredPane().add(fenetreCompteurs);
        	fenetreCompteurs.setVisible(true);
            break;
        case "Charges":
            FenetreCharges charges = new FenetreCharges();
            fenetre.getLayeredPane().add(charges);
            charges.setVisible(true);
            break;
        case "Ajouter":
            FenetreAjouterBatiment ajout = new FenetreAjouterBatiment();
            fenetre.getLayeredPane().add(ajout);
            ajout.setVisible(true);
            break;
        case "Supprimer":
            FenetreSupprimerBatiment supre = new FenetreSupprimerBatiment();
            fenetre.getLayeredPane().add(supre);
            supre.setVisible(true);
            break;
        }
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = fenetre.getTable().getSelectedRow();
            if (row != -1) {
                String contrat = (String) fenetre.getTable().getValueAt(row, 0);
                String date = (String) fenetre.getTable().getValueAt(row, 1);
                String bien = (String) fenetre.getTable().getValueAt(row, 2);
                String locataire = (String) fenetre.getTable()
                    .getValueAt(row, 3);
                FenetreBienLouable fen = new FenetreBienLouable();
                fen.setVisible(true);
            }
        }
    }
}