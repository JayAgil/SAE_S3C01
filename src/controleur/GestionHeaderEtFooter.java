package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import modele.dao.DaoLocataire;
import vue.*;

public abstract class GestionHeaderEtFooter implements ActionListener {

    protected FenetreBase fenetre;

    public GestionHeaderEtFooter(FenetreBase fenetre) {
        this.fenetre = fenetre;
    }
    
    public void initialize() {
        fenetre.mntmAssurance.addActionListener(this);
        fenetre.mntmCharge.addActionListener(this);
        fenetre.mntmCompteur.addActionListener(this);
        fenetre.mntmAjouterBat.addActionListener(this);

        fenetre.mntmContratLocation.addActionListener(this);
        fenetre.mntmCompteurBL.addActionListener(this);
        fenetre.mntmTravaux.addActionListener(this);
        fenetre.mntmChargesBL.addActionListener(this);
        fenetre.mntmDiagnostic.addActionListener(this);
        fenetre.mntmLocataire.addActionListener(this);

        fenetre.mntmHistorique.addActionListener(this);
        fenetre.mntmAjout.addActionListener(this);
        this.fenetre.disableMenuItems(false);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();
        if (src instanceof JButton btn) {
            try {
				gererBoutonCommun(btn.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            try {
				gererBoutonSpecifique(btn.getText());
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
            try {
				gererBoutonRetour(btn.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
        }
        if (src instanceof JMenuItem item) {
            String texte = item.getText();
            try {
				gererMenuCommun(texte);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            try {
				gererMenuSpecifique(texte);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
        }
    }

    protected void gererMenuCommun(String texte) throws SQLException {

        switch (texte) {

        case "Déconnecter":
            new FenetreLogin().setVisible(true);
            fenetre.dispose();
            break;

        case "Compteurs bâtiment":
            new FenetreCompteurs("FenetrePrincipale").setVisible(true);
            fenetre.dispose();
            break;

        case "Charges bâtiment":
            new FenetreCharges("FenetrePrincipale", null).setVisible(true);
            fenetre.dispose();
            break;

        case "Contrat location":
            new FenetreContratLocation("FenPrincipale", null).setVisible(true);
            fenetre.dispose();
            break;

        case "Compteurs bien louable":
            new FenetreCompteurs("FenetreBienLouable").setVisible(true);
            fenetre.dispose();
            break;

        case "Travaux":
            new FenetreTravaux().setVisible(true);
            fenetre.dispose();
            break;

        case "Charges bien louable":
            new FenetreCharges("FenetreBienLouable", null).setVisible(true);
            fenetre.dispose();
            break;

        case "Diagnostics":
            new FenetreDiagnostic().setVisible(true);
            fenetre.dispose();
            break;

        case "Locataires":
        	DaoLocataire dl = new DaoLocataire();
            new FenetreLocataire("Principal", dl.findAll(),nullNRK).setVisible(true);
            fenetre.dispose();
            break;

        case "Historique de paiement":
            new FenetrePaiement(null).setVisible(true);
            fenetre.dispose();
            break;
            
        case "Ajouter bâtiment":
            fenetre.getLayeredPane().add(new FenetreAjouterBatiment()).setVisible(true);
            break;

        case "Assurance":
           FenetreAssurance fA = new FenetreAssurance();
           fA.setVisible(true);
            break;

        case "Ajouter paiement":
            fenetre.getLayeredPane().add(new FenetreAjouterPaiement()).setVisible(true);
            break;
        }
    }
    
    protected void gererBoutonRetour(String texte) throws SQLException {
	    if ("Retour".equals(texte)) {
	        fenetre.dispose();
	    }
    }

    protected void gererBoutonCommun(String texte) throws SQLException{}
    protected void gererMenuSpecifique(String texte) throws SQLException{}
    protected void gererBoutonSpecifique(String texte) throws SQLException {}
}
