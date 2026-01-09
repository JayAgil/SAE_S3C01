package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import modele.dao.*;
import vue.*;

public abstract class GestionHeaderEtFooter implements ActionListener {

	protected FenetreBase fenetre;

	public GestionHeaderEtFooter(FenetreBase fenetre) {
		this.fenetre = fenetre;
	}

	public void initialize() {
		fenetre.mntmCharge.addActionListener(this);
		fenetre.mntmCompteur.addActionListener(this);

		fenetre.mntmContratLocation.addActionListener(this);
		fenetre.mntmTravaux.addActionListener(this);
		fenetre.mntmLocataire.addActionListener(this);

		fenetre.mntmHistorique.addActionListener(this);
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

		case "Compteurs":
			DaoCompteur dao = new DaoCompteur();
			FenetreCompteurs fc = new FenetreCompteurs("FenPrincipale", dao.findAll(),null);
			fc.setVisible(true);
			fenetre.dispose();
			break;

		case "Charges":
			DaoChargesGenerales daoCharges = new DaoChargesGenerales();
			new FenetreCharges("FenPrincipale", daoCharges.findAll(),null).setVisible(true);
			fenetre.dispose();
			break;

		case "Contrat location":
			FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale", null,null);
			fCL.setVisible(true);
			fenetre.dispose();
			break;

		case "Travaux":
			DaoFacture daoFacture = new DaoFacture();
			new FenetreTravaux("FenPrincipale",daoFacture.findAll(), null).setVisible(true);
			fenetre.dispose();
			break;

		case "Locataires":
			DaoLocataire dl = new DaoLocataire();
			new FenetreLocataire("FenPrincipale", dl.findAll(), null).setVisible(true);
			fenetre.dispose();
			break;

		case "Historique de paiement":
			DaoPaiement daoPaiement = new DaoPaiement();
			new FenetrePaiement("FenPrincipale", daoPaiement.findAll(), null,null).setVisible(true);
			fenetre.dispose();
			break;

		}
	}

	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
		}
	}

	protected void gererBoutonCommun(String texte) throws SQLException {
	}

	protected void gererMenuSpecifique(String texte) throws SQLException {
	}

	protected void gererBoutonSpecifique(String texte) throws SQLException {
	}
	
	protected double parseDoubleSafe(Object value) {
        if (value == null) {
        	return 0.0;
        }
        String str = value.toString().replaceAll("[^0-9.,]", "");
        str = str.replace(",", ".");
        if (str.isEmpty()) return 0.0;
        return Double.parseDouble(str);
    }
}