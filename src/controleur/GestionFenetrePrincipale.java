package controleur;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import vue.*;

public class GestionFenetrePrincipale extends GestionHeaderEtFooter implements MouseListener, ActionListener{

    private FenetrePrincipale fenetre;

    public GestionFenetrePrincipale(FenetrePrincipale fenetre) {
        super(fenetre);
        this.fenetre = fenetre;
    }
    
    

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {
            case "Quitter":
                fenetre.dispose();
                break;

            case "Assurance":
                FenetreAssurance assurance = new FenetreAssurance();
                assurance.setVisible(true);
                break;

            case "Compteurs":
                fenetre.dispose();
                new FenetreCompteurs().setVisible(true);
                break;

            case "Charges":
                fenetre.dispose();
                new FenetreCharges().setVisible(true);
                break;

            case "Ajouter":
                FenetreAjouterBatiment ajout = new FenetreAjouterBatiment();
                fenetre.getLayeredPane().add(ajout);
                ajout.setVisible(true);
                break;
        }
    }

    @Override
    protected void gererMenuSpecifique(String texte) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
            fenetre.dispose();
            int row = fenetre.getTable().getSelectedRow();
            if (row != -1) {
                FenetreBienLouable fen = new FenetreBienLouable();
                fen.setVisible(true);
            }
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
