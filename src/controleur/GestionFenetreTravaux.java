package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Facture;
import modele.dao.DaoFacture;
import vue.FenetreAjouterEntreprise;
import vue.FenetreAjouterTravaux;
import vue.FenetreBienLouable;
import vue.FenetreFacture;
import vue.FenetrePrincipale;
import vue.FenetreTravaux;

/**
 * Contrôleur de la fenêtre Travaux.
 * Permet de gérer l'affichage, l'ajout, la suppression et la mise à jour
 * des factures de travaux associées à un bien louable.
 * Implémente MouseListener pour la gestion du double-clic sur la table.
 */
public class GestionFenetreTravaux extends GestionHeaderEtFooter implements MouseListener {

    /** Fenêtre graphique des travaux */
	private FenetreTravaux fenetreTravaux;
	
	/** Liste des factures/travaux affichés */
	private List<Facture> travaux;

	/**
	 * Constructeur du contrôleur.
	 * Initialise les données, remplit la table et applique les filtres.
	 *
	 * @param fenetreTravaux fenêtre Travaux associée
	 * @param liste          liste des factures/travaux
	 */
	@SuppressWarnings("deprecation")
	public GestionFenetreTravaux(FenetreTravaux fenetreTravaux, List<Facture> liste) {
		super(fenetreTravaux);
		this.fenetreTravaux = fenetreTravaux;
		this.travaux = liste;
		
		// Remplit la table avec les données fournies
		remplirTable();
		
		// Met à jour les indicateurs (total montant, nombre de travaux)
		majDonnees();
		
		// Masque le bouton "Ajouter travaux" si on vient de la fenêtre principale
		if (this.fenetreTravaux.getFenetreAvant() == "FenPrincipale") {
			this.fenetreTravaux.getBtnAjouterTravaux().hide();
		}
	}

	/**
	 * Gestion des actions sur les boutons et combobox.
	 * 
	 * @param e événement déclenché
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		Object source = e.getSource();

		// Gestion des filtres mois/année
		if (source == fenetreTravaux.getComboBox_Mois() || source == fenetreTravaux.getComboBox_Annee()) {
			filtrerTravaux();
			return;
		}

		// Si la source n'est pas un bouton, sortir
		if (!(source instanceof JButton))
			return;

		JButton btn = (JButton) source;

		// Traitement selon le texte du bouton
		switch (btn.getText()) {
		case "Ajouter travaux":
			ouvrirFenetreAjouterTravaux();
			break;
		case "Ajouter entreprise":
			ouvrirFenetreAjouterEntreprise();
			break;
		case "Visualiser facture":
			visualiserFactureSelectionnee();
			break;
		case "Retirer":
			// Suppression de la facture sélectionnée
			JTable tablefac = fenetreTravaux.getTable();
			int rowfac = tablefac.getSelectedRow();
			if (rowfac != -1) {
				Facture f = this.travaux.get(rowfac);
				DaoFacture daoFacture;
				travaux.remove(f);
				try {
					daoFacture = new DaoFacture();
					daoFacture.delete(f);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			this.remplirTable();
			break;
		case "Mettre à jour":
			// Mise à jour des valeurs modifiées dans la table
			JTable table = fenetreTravaux.getTable();
			int row = table.getSelectedRow();
			if (row != -1) {
				Facture f = this.travaux.get(row);
				DaoFacture daoFacture;

				if (table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}

				try {
					daoFacture = new DaoFacture();
					// Mettre à jour le montant et le devis
					f.setMontant(parseDoubleSafe(table.getValueAt(row, 1)));
					f.setMontantDevis(parseDoubleSafe(table.getValueAt(row, 4)));
					daoFacture.update(f);
					this.remplirTable();
					JOptionPane.showMessageDialog(fenetreTravaux, "Données mises à jour !", "Mise à jour",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			break;
		}
	}

	// --- Ouverture des fenêtres secondaires ---
	private void ouvrirFenetreAjouterTravaux() {
		FenetreAjouterTravaux fen = new FenetreAjouterTravaux(this, this.fenetreTravaux.getBien());
		fenetreTravaux.getLayeredPane().add(fen);
		fen.setVisible(true);
	}

	private void ouvrirFenetreAjouterEntreprise() {
		FenetreAjouterEntreprise fen = new FenetreAjouterEntreprise();
		fenetreTravaux.getLayeredPane().add(fen);
		fen.setVisible(true);
	}

	private void visualiserFactureSelectionnee() {
		Facture facture = this.getFactureSelectionnee();
		if (facture == null) {
			JOptionPane.showMessageDialog(fenetreTravaux, "Veuillez sélectionner une facture");
			return;
		}
		new FenetreFacture(facture).setVisible(true);
	}

	/**
	 * Gestion du bouton retour pour revenir à la fenêtre précédente.
	 */
	@Override
	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			String fenAvant = this.fenetreTravaux.getFenetreAvant();
			switch (fenAvant) {
			case "FenetreBienLouable":
				FenetreBienLouable fen = new FenetreBienLouable("FenPrincipale", this.fenetreTravaux.getBien());
				fen.setVisible(true);
				break;
			case "FenPrincipale":
				FenetrePrincipale fp4 = new FenetrePrincipale();
				fp4.setVisible(true);
				break;
			}
			fenetreTravaux.dispose();
		}
	}

	/**
	 * Gestion du double-clic sur une ligne de la table pour visualiser la facture.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && e.getSource() instanceof JTable) {
			JTable table = (JTable) e.getSource();
			int row = table.rowAtPoint(e.getPoint());
			if (row != -1) {
				Facture facture = this.getFactureSelectionnee(row);
				if (facture != null) {
					new FenetreFacture(facture).setVisible(true);
				}
			}
		}
	}

	/**
	 * Met à jour les indicateurs de la fenêtre (montant total et nombre de travaux).
	 */
	public void majDonnees() {
		double somme = 0;
		for (Facture f : travaux) {
			somme += f.getMontant();
		}

		this.fenetreTravaux.getLblMontantTotal().setText(String.valueOf(somme) + "€");
		this.fenetreTravaux.getLblNbTravaux().setText(String.valueOf(travaux.size()));
	}

	/**
	 * Filtre les travaux selon le mois et l'année sélectionnés dans les combobox.
	 */
	private void filtrerTravaux() {
		String moisSelectionne = (String) fenetreTravaux.getComboBox_Mois().getSelectedItem();
		String anneeSelectionnee = (String) fenetreTravaux.getComboBox_Annee().getSelectedItem();
		JTable table = fenetreTravaux.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		double somme = 0;
		int nbTravaux = 0;

		for (Facture f : travaux) {
			java.util.Calendar cal = java.util.Calendar.getInstance();
			cal.setTime(f.getDateDeFacture());
			int moisFacture = cal.get(java.util.Calendar.MONTH) + 1; // Janvier = 0
			int anneeFacture = cal.get(java.util.Calendar.YEAR);

			boolean match = true;

			if (!"Tous".equals(moisSelectionne)) {
				int moisCombo = getMoisInt(moisSelectionne);
				match = match && (moisFacture == moisCombo);
			}

			if (!"Tous".equals(anneeSelectionnee)) {
				int anneeCombo = Integer.parseInt(anneeSelectionnee);
				match = match && (anneeFacture == anneeCombo);
			}
			if (match) {
				Object[] ligne = { f.getNumeroFacture(), f.getMontant(), f.getDateDeFacture(), f.getCompteBancaire(),
						f.getMontantDevis(), f.getDatePaiement(), f.getDesignationDeTravaux(),
						f.getEntreprise().getNom() };
				model.addRow(ligne);

				somme += f.getMontant();
				nbTravaux++;
			}
		}

		fenetreTravaux.getLblMontantTotal().setText(String.valueOf(somme) + "€");
		fenetreTravaux.getLblNbTravaux().setText(String.valueOf(nbTravaux));
	}

	/**
	 * Convertit le nom du mois en entier (Janvier = 1, Décembre = 12)
	 */
	private int getMoisInt(String mois) {
		switch (mois) {
		case "Janvier": return 1;
		case "Février": return 2;
		case "Mars": return 3;
		case "Avril": return 4;
		case "Mai": return 5;
		case "Juin": return 6;
		case "Juillet": return 7;
		case "Août": return 8;
		case "Septembre": return 9;
		case "Octobre": return 10;
		case "Novembre": return 11;
		case "Décembre": return 12;
		default: return 0;
		}
	}

	public void setListe(List<Facture> liste) {
		this.travaux = liste;
	}

	public void setFactures(List<Facture> factures) {
		this.travaux = factures;
		remplirTable();
	}

	/**
	 * Remplit la table avec toutes les factures.
	 */
	public void remplirTable() {
		DefaultTableModel model = (DefaultTableModel) fenetreTravaux.getTable().getModel();
		model.setRowCount(0);
		for (Facture f : this.travaux) {
			model.addRow(new Object[] { f.getNumeroFacture(), f.getMontant(), f.getDateDeFacture(),
					f.getCompteBancaire(), f.getMontantDevis(), f.getDatePaiement(), f.getDesignationDeTravaux(),
					f.getEntreprise().getNom() });
		}
	}

	public Facture getFactureSelectionnee(int row) {
		if (row < 0 || row >= this.travaux.size())
			return null;
		return this.travaux.get(row);
	}

	public Facture getFactureSelectionnee() {
		int row = fenetreTravaux.getTable().getSelectedRow();
		if (row == -1)
			return null;
		return getFactureSelectionnee(row);
	}

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
}
