package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import vue.*;

public abstract class GestionHeaderEtFooter implements ActionListener {

    protected JFrame fenetre;

    public GestionHeaderEtFooter(JFrame fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src instanceof JButton btn) {
            gererBoutonCommun(btn.getText());
            gererBoutonSpecifique(btn.getText());
        }
        if (src instanceof JMenuItem item) {
            String texte = item.getText();
            gererMenuCommun(texte);
            gererMenuSpecifique(texte); 
        }
    }

    protected void gererMenuCommun(String texte) {

        switch (texte) {

        case "Déconnecter":
            fenetre.dispose();
            new FenetreLogin().setVisible(true);
            break;

        case "Compteurs bâtiment":
            fenetre.dispose();
            new FenetreCompteurs().setVisible(true);
            break;

        case "Charges bâtiment":
            fenetre.dispose();
            new FenetreCharges().setVisible(true);
            break;

        case "Contrat location":
            fenetre.dispose();
            new FenetreContratLocation().setVisible(true);
            break;

        case "Compteurs bien louable":
            fenetre.dispose();
            new FenetreCompteurs().setVisible(true);
            break;

        case "Travaux":
            fenetre.dispose();
            new FenetreTravaux().setVisible(true);
            break;

        case "Charges bien louable":
            fenetre.dispose();
            new FenetreCharges().setVisible(true);
            break;

        case "Diagnostics":
            fenetre.dispose();
            new FenetreDiagnostic().setVisible(true);
            break;

        case "Locataires":
            fenetre.dispose();
            new FenetreLocataire().setVisible(true);
            break;

        case "Historique de paiement":
            fenetre.dispose();
            new FenetrePaiement().setVisible(true);
            break;
        case "Ajouter bâtiment":
            fenetre.getLayeredPane().add(new FenetreAjouterBatiment()).setVisible(true);
            break;

        case "Assurance":
            fenetre.getLayeredPane().add(new FenetreAssurance()).setVisible(true);
            break;

        case "Ajouter paiement":
            fenetre.getLayeredPane().add(new FenetreAjouterPaiement()).setVisible(true);
            break;
        }
    }

    protected void gererBoutonCommun(String texte) {
	    if ("Retour".equals(texte)) {
	        fenetre.dispose();
	    }
    }
    protected void gererMenuSpecifique(String texte) {}
    protected void gererBoutonSpecifique(String texte) {}
}
