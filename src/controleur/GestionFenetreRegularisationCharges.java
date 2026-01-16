package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import vue.FenetreRegularisationCharges;

/**
 * Contrôleur pour la fenêtre de régularisation des charges.
 * Gère les actions des boutons "Continuer" et "Annuler".
 */
public class GestionFenetreRegularisationCharges implements ActionListener {
	
	/** Fenêtre de régularisation des charges associée à ce contrôleur */
	private FenetreRegularisationCharges fen;

	/**
	 * Constructeur du contrôleur.
	 * 
	 * @param fen la fenêtre de régularisation des charges
	 */
	public GestionFenetreRegularisationCharges(FenetreRegularisationCharges fen) {
		this.fen = fen;
	}

	/**
	 * Méthode déclenchée lors d'un clic sur un bouton de la fenêtre.
	 * 
	 * @param e l'événement déclenché
	 */
	public void actionPerformed(ActionEvent e) {
		// Récupère le texte du bouton cliqué pour déterminer l'action
		switch (((JButton) e.getSource()).getText()) {
		
		// Si l'utilisateur clique sur "Continuer"
		case "Continuer":
			// Met à jour le montant mensuel du contrat avec la régularisation
			this.fen.getContrat().setMontantMensuel(
				this.fen.getContrat().getMontantMensuel() + this.fen.getElement() / 12
			);
			try {
				// Met à jour le contrat dans la base de données
				this.fen.getDao().update(this.fen.getContrat());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// Ferme la fenêtre après la mise à jour
			this.fen.dispose();
		
		// Si l'utilisateur clique sur "Annuler"
		case "Annuler":
			// Ferme simplement la fenêtre sans modification
			this.fen.dispose();
		}
	}
}
