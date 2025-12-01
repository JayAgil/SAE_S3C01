package controleur;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements ActionListener, MouseListener{

    private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
        super(fenetre);
        this.fenetrebienlouable = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {

            case "Diagnostics":
                fenetrebienlouable.dispose();
                new FenetreDiagnostic().setVisible(true);
                break;

            case "Contrat":
                fenetrebienlouable.dispose();
                new FenetreContratLocation().setVisible(true);
                break;

            case "Charges":
                fenetrebienlouable.dispose();
                new FenetreCharges().setVisible(true);
                break;

            case "Travaux":
                fenetrebienlouable.dispose();
                new FenetreTravaux().setVisible(true);
                break;

            case "Compteur":
                fenetrebienlouable.dispose();
                new FenetreCompteurs().setVisible(true);
                break;

            case "Revaloriser":
                break;
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            fenetre.dispose();
            int row = ((FenetreBienLouable) fenetre).getTable().getSelectedRow();
            if (row != -1) {
                FenetreLocataire fen = new FenetreLocataire();
                fen.setVisible(true);
            }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    
    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            fenetre.dispose();
            FenetrePrincipale fp = new FenetrePrincipale();
            fp.setVisible(true);
        }
    }
}
