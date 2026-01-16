package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import modele.dao.*;
import vue.*;

/**
 * Classe abstraite pour gérer les éléments communs aux fenêtres ayant un header et footer.
 * Elle centralise la gestion des menus, boutons communs, et permet aux classes filles
 * de gérer des actions spécifiques (boutons ou menus).
 */
public abstract class GestionHeaderEtFooter implements ActionListener {

    /** Fenêtre associée (toute fenêtre héritant de FenetreBase) */
	protected FenetreBase fenetre;

	/**
	 * Constructeur.
	 * 
	 * @param fenetre fenêtre associée
	 */
	public GestionHeaderEtFooter(FenetreBase fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * Initialisation des listeners sur les menus (header).
	 * Appelé généralement après la construction de la fenêtre.
	 */
	public void initialize() {
		fenetre.mntmCharge.addActionListener(this);
		fenetre.mntmCompteur.addActionListener(this);

		fenetre.mntmContratLocation.addActionListener(this);
		fenetre.mntmTravaux.addActionListener(this);
		fenetre.mntmLocataire.addActionListener(this);

		fenetre.mntmHistorique.addActionListener(this);
	}

	/**
	 * Gestion globale des actions déclenchées par les boutons ou menus.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object src = e.getSource();

		// Gestion des boutons
		if (src instanceof JButton btn) {
			try {
				gererBoutonCommun(btn.getText());        // Actions communes aux boutons
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				gererBoutonSpecifique(btn.getText());    // Actions spécifiques (définies par les classes filles)
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				gererBoutonRetour(btn.getText());        // Gestion du bouton "Retour"
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Gestion des menus
		if (src instanceof JMenuItem item) {
			String texte = item.getText();
			try {
				gererMenuCommun(texte);                 // Actions communes aux menus
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				gererMenuSpecifique(texte);             // Actions spécifiques aux menus
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Gère les actions communes aux menus.
	 * Chaque menu déclenche l'ouverture de la fenêtre correspondante.
	 */
	protected void gererMenuCommun(String texte) throws SQLException {

		switch (texte) {

		case "Déconnecter":
			new FenetreLogin().setVisible(true);
			fenetre.dispose();
			break;

			/**
			 * En mettant null comme bien louable en paramètre de chaque méthode,
			 * on affiche tous les éléments liés au bâtiment plutôt qu'à un bien spécifique.
			 */

		case "Compteurs":
			DaoCompteur dao = new DaoCompteur();
			FenetreCompteurs fc = new FenetreCompteurs("FenPrincipale", dao.findAll(), null);
			fc.setVisible(true);
			fenetre.dispose();
			break;

		case "Charges":
			DaoChargesGenerales daoCharges = new DaoChargesGenerales();
			new FenetreCharges("FenPrincipale", daoCharges.findAll(), null).setVisible(true);
			fenetre.dispose();
			break;

		case "Contrat location":
			FenetreContratLocation fCL = new FenetreContratLocation("FenPrincipale", null, null);
			fCL.setVisible(true);
			fenetre.dispose();
			break;

		case "Travaux":
			DaoFacture daoFacture = new DaoFacture();
			new FenetreTravaux("FenPrincipale", daoFacture.findAll(), null).setVisible(true);
			fenetre.dispose();
			break;

		case "Locataires":
			DaoLocataire dl = new DaoLocataire();
			new FenetreLocataire("FenPrincipale", dl.findAll(), null).setVisible(true);
			fenetre.dispose();
			break;

		case "Historique de paiement":
			DaoPaiement daoPaiement = new DaoPaiement();
			new FenetrePaiement("FenPrincipale", daoPaiement.findAll(), null, null).setVisible(true);
			fenetre.dispose();
			break;
		}
	}

	/**
	 * Gestion du bouton "Retour".
	 * Par défaut, ferme simplement la fenêtre.
	 */
	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
		}
	}

	/**
	 * Méthode vide à surcharger dans les classes filles
	 * pour gérer les boutons communs.
	 */
	protected void gererBoutonCommun(String texte) throws SQLException {
	}

	/**
	 * Méthode vide à surcharger dans les classes filles
	 * pour gérer les menus spécifiques.
	 */
	protected void gererMenuSpecifique(String texte) throws SQLException {
	}

	/**
	 * Méthode vide à surcharger dans les classes filles
	 * pour gérer les boutons spécifiques.
	 */
	protected void gererBoutonSpecifique(String texte) throws SQLException {
	}
	
	/**
	 * Convertit un objet en double de manière sûre.
	 * Supprime les caractères non numériques, gère les virgules et renvoie 0.0 si invalide.
	 * 
	 * @param value valeur à convertir
	 * @return valeur double
	 */
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
