package controleur;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener{

    private FenetreBienLouable fenetrebienlouable;

    public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
        super(fenetre);
        this.fenetrebienlouable = fenetre;
    }

    @Override
    protected void gererBoutonSpecifique(String texte) {
        switch (texte) {

            case "Diagnostics":
                new FenetreDiagnostic().setVisible(true);
                fenetrebienlouable.dispose();
                break;

            case "Contrat":
                new FenetreContratLocation("FenBienLouable").setVisible(true);
                fenetrebienlouable.dispose();
                break;

            case "Charges":
                new FenetreCharges("FenetreBienLouable").setVisible(true);
                fenetrebienlouable.dispose();
                break;

            case "Travaux":
                new FenetreTravaux().setVisible(true);
                fenetrebienlouable.dispose();
                break;

            case "Compteur":
                new FenetreCompteurs("FenereBienLouable").setVisible(true);
                fenetrebienlouable.dispose();
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
                FenetreLocataire fen = new FenetreLocataire("BienLouable");
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
