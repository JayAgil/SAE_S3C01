package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoBienLouable;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter implements MouseListener {

	private FenetrePaiement fenetre;
	private List<Paiement> paiements;
	private String idLoc;
	private Paiement paiementSelectionne;
	private Locataire locataireSelectionne;

	/**
	 * Constructeur du contrôleur.
	 * 
	 * @param fenetre              fenêtre de paiement
	 * @param liste                liste des paiements
	 * @param idLoc                identifiant du locataire
	 * @param locataireSelectionne locataire sélectionné
	 * @throws SQLException en cas d’erreur d’accès à la base de données
	 */
	@SuppressWarnings("deprecation")
	public GestionFenetrePaiement(FenetrePaiement fenetre, List<Paiement> liste, String idLoc,
			Locataire locataireSelectionne) throws SQLException {
		super(fenetre);
		this.fenetre = fenetre;
		this.idLoc = idLoc;
		this.paiements = liste;
		this.locataireSelectionne = locataireSelectionne;
		chargerDonnees();
		afficherDetailsPaiement();
		if (this.fenetre.getNomFenAvant() == "FenPrincipale") {
			this.fenetre.getBtnAjouterPaiement().hide();
		}
	}

	/**
	 * Gère les actions des boutons spécifiques à la fenêtre.
	 *
	 * @param texte texte du bouton cliqué
	 * @throws SQLException en cas d’erreur SQL
	 */
	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {
		case "Ajouter paiement":
			FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement(this, locataireSelectionne);
			fenetre.getLayeredPane().add(fenAjouterPaiement);
			fenAjouterPaiement.setVisible(true);
			break;
		case "Retirer":
			if (paiementSelectionne == null) {
				return;
			}
			DaoPaiement dP = new DaoPaiement();
			dP.delete(paiementSelectionne);
			paiements.remove(paiementSelectionne);
			this.chargerDonnees();
			break;
		case "Quittance loyer":
			if (paiementSelectionne == null) {
				return;
			}
			FenetreQuittance fenQuittance = new FenetreQuittance(paiementSelectionne);
			fenetre.getLayeredPane().add(fenQuittance);
			fenQuittance.setVisible(true);
			break;
		case "Mettre à jour":
			JTable table = fenetre.getTable();
			int row = table.getSelectedRow();

			if (table.isEditing()) {
				table.getCellEditor().stopCellEditing();
			}

			if (row != -1) {
				Paiement p = this.paiements.get(row);
				DaoPaiement daoPaiement;
				try {
					daoPaiement = new DaoPaiement();

					String dateStr = table.getValueAt(row, 2).toString();
					if (!dateStr.isEmpty()) {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate = LocalDate.parse(dateStr, formatter);
						p.setDatepaiement(Date.valueOf(localDate));
					} else {
						p.setDatepaiement(null);
					}

					p.setMontant(parseDoubleSafe(table.getValueAt(row, 3)));
					p.setDesignation(table.getValueAt(row, 4).toString());
					daoPaiement.update(p);

					JOptionPane.showMessageDialog(fenetre, "Données mises à jour !", "Mise à jour",
							JOptionPane.INFORMATION_MESSAGE);

					System.out.print(p);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			break;

		}
	}

	/**
	 * Gère l’action du bouton Retour selon la fenêtre précédente.
	 *
	 * @param texte texte du bouton cliqué
	 * @throws SQLException en cas d’erreur SQL
	 */
	@Override
	protected void gererBoutonRetour(String texte) throws SQLException {

		if ("Retour".equals(texte)) {
			fenetre.dispose();
			String fenAvant = fenetre.getNomFenAvant();
			switch (fenAvant) {
			case "FenLocataire":
				DaoLocataire dl = new DaoLocataire();
				List<Locataire> liste = dl.findLocatairesMemeBien(idLoc);
				DaoBienLouable daoBl = new DaoBienLouable();
				FenetreLocataire fen = new FenetreLocataire("FenPrincipale", liste, daoBl.findByIdLoc(idLoc));
				fen.setVisible(true);
				fenetre.dispose();
				break;
			case "FenPrincipale":
				FenetrePrincipale fp4 = new FenetrePrincipale();
				fp4.setVisible(true);
				break;

			}
		}

	}

	/**
	 * Charge les paiements dans le tableau et met à jour les informations
	 * récapitulatives (dernier paiement, total).
	 */
	public void chargerDonnees() {
		DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
		model.setRowCount(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Paiement p : paiements) {
			String dateFormatee = p.getDatepaiement().toLocalDate().format(formatter);
			Object[] ligne = { p.getId_paiement(), p.getContratLocation().getNumeroDeContrat(), dateFormatee,
					p.getMontant(), p.getDesignation() };
			model.addRow(ligne);
		}

		java.time.LocalDate dernier = getDateDernierPaiement();
		fenetre.getLblDateDernierPaiement().setText(
				dernier != null ? dernier.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Aucun paiement");
		fenetre.getLblTotalPaiementAnnees().setText(
				String.format("%.2f €", getMontantTotalFiltre((String) fenetre.getComboBoxMois().getSelectedItem(),
						(String) fenetre.getComboBoxAnnee().getSelectedItem())));
	}

	/**
	 * Affiche les détails du paiement sélectionné dans les labels.
	 */
	private void afficherDetailsPaiement() {
		JTable table = fenetre.getTable();
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					Object montant = table.getValueAt(selectedRow, 3);
					Object date = table.getValueAt(selectedRow, 2);
					fenetre.getLblValDate().setText((String) date);
					fenetre.getLblValPaiement().setText(String.valueOf(montant) + " €");
				}
			}
		});
	}

	/**
	 * Retourne la date du dernier paiement effectué.
	 *
	 * @return date du dernier paiement ou null si aucun paiement
	 */
	private LocalDate getDateDernierPaiement() {
		LocalDate dernier = null;
		for (Paiement p : paiements) {
			LocalDate dateP = p.getDatepaiement().toLocalDate();
			if (dernier == null || dateP.isAfter(dernier)) {
				dernier = dateP;
			}
		}
		return dernier;
	}

	/**
	 * Filtre les paiements selon le mois et l’année sélectionnés.
	 *
	 * @param mois  mois sélectionné
	 * @param annee année sélectionnée
	 */
	private void filterPaiements(String mois, String annee) {

		DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
		model.setRowCount(0);

		for (Paiement p : paiements) {

			LocalDate date = p.getDatepaiement().toLocalDate();

			boolean moisValide = true;
			boolean anneeValide = true;

			if (!"Mois".equals(mois)) {
				int moisInt = convertirMoisEnInt(mois);
				moisValide = date.getMonthValue() == moisInt;
			}

			if (!"Année".equals(annee)) {
				int anneeInt = Integer.parseInt(annee);
				anneeValide = date.getYear() == anneeInt;
			}

			if (moisValide && anneeValide) {
				Object[] ligne = { p.getId_paiement(), p.getContratLocation().getNumeroDeContrat(),
						date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getMontant(), p.getDesignation() };
				model.addRow(ligne);
			}
		}
		double totalFiltre = getMontantTotalFiltre(mois, annee);
		fenetre.getLblTotalPaiementAnnees().setText(String.format("%.2f €", totalFiltre));

	}

	/**
	 * Convertit le nom du mois en numéro.
	 *
	 * @param mois nom du mois
	 * @return numéro du mois (1 à 12)
	 */
	private int convertirMoisEnInt(String mois) {
		switch (mois) {
		case "Janvier":
			return 1;
		case "Février":
			return 2;
		case "Mars":
			return 3;
		case "Avril":
			return 4;
		case "Mai":
			return 5;
		case "Juin":
			return 6;
		case "Juillet":
			return 7;
		case "Août":
			return 8;
		case "Septembre":
			return 9;
		case "Octobre":
			return 10;
		case "Novembre":
			return 11;
		case "Décembre":
			return 12;
		default:
			return 0;
		}
	}

	/**
	 * Calcule le montant total des paiements filtrés.
	 *
	 * @param mois  mois sélectionné
	 * @param annee année sélectionnée
	 * @return montant total
	 */
	private double getMontantTotalFiltre(String mois, String annee) {

		double total = 0;

		for (Paiement p : paiements) {
			LocalDate date = p.getDatepaiement().toLocalDate();

			boolean moisValide = true;
			boolean anneeValide = true;

			if (!"Mois".equals(mois)) {
				int moisInt = convertirMoisEnInt(mois);
				moisValide = date.getMonthValue() == moisInt;
			}

			if (!"Année".equals(annee)) {
				int anneeInt = Integer.parseInt(annee);
				anneeValide = date.getYear() == anneeInt;
			}

			if (moisValide && anneeValide) {
				total += p.getMontant();
			}
		}

		return total;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	/**
	 * Gère les actions sur les composants (comboBox mois / année).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		if (e.getSource() == fenetre.getComboBoxMois() || e.getSource() == fenetre.getComboBoxAnnee()) {

			String mois = (String) fenetre.getComboBoxMois().getSelectedItem();
			String annee = (String) fenetre.getComboBoxAnnee().getSelectedItem();

			filterPaiements(mois, annee);
		}
	}

	/**
	 * Gère le clic sur une ligne du tableau de paiements.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = fenetre.getTable();
		int row = table.getSelectedRow();

		if (row == -1) {
			return;
		}
		String designation = table.getValueAt(row, 4).toString();
		fenetre.getButtonQuittance().setEnabled(true);
		try {
			String idPaiement = table.getValueAt(row, 0).toString();
			DaoPaiement daoPaiement = new DaoPaiement();
			paiementSelectionne = daoPaiement.findById(idPaiement);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
