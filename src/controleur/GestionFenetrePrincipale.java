package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vue.*;

public class GestionFenetrePrincipale extends GestionHeaderEtFooter implements MouseListener {

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
                fenetre.getLayeredPane().add(assurance);
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
        if (e.getClickCount() == 2) {
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
