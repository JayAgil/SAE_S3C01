package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

	@SuppressWarnings("deprecation")
	public GestionFenetrePaiement(FenetrePaiement fenetre, List<Paiement> liste, String idLoc, Locataire locataireSelectionne) throws SQLException {
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

	@Override
	protected void gererBoutonSpecifique(String texte) {
		switch (texte) {
		case "Ajouter paiement":
			FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement(this,locataireSelectionne);
			fenetre.getLayeredPane().add(fenAjouterPaiement);
			fenAjouterPaiement.setVisible(true);
			break;
		case "Quittance loyer":
			if (paiementSelectionne == null) {
				return;
			}
			FenetreQuittance fenQuittance = new FenetreQuittance(paiementSelectionne);
			fenetre.getLayeredPane().add(fenQuittance);
			fenQuittance.setVisible(true);
			break;

		}
	}

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
	


	public void chargerDonnees() {
		DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
		model.setRowCount(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Paiement p : paiements) {
			String dateFormatee = p.getDatepaiement().toLocalDate().format(formatter);
			Object[] ligne = { p.getId_paiement(), p.getContratLocation().getNumeroDeContrat(), dateFormatee,
					p.getMontant(),p.getDesignation() };
			model.addRow(ligne);
		}

		java.time.LocalDate dernier = getDateDernierPaiement();
		fenetre.getLblDateDernierPaiement().setText(
				dernier != null ? dernier.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Aucun paiement");
		fenetre.getLblTotalPaiementAnnees().setText(
				String.format("%.2f €", getMontantTotalFiltre((String) fenetre.getComboBoxMois().getSelectedItem(),
						(String) fenetre.getComboBoxAnnee().getSelectedItem())));
	}

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
						date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), p.getMontant(),p.getDesignation() };
				model.addRow(ligne);
			}
		}
		double totalFiltre = getMontantTotalFiltre(mois, annee);
		fenetre.getLblTotalPaiementAnnees().setText(String.format("%.2f €", totalFiltre));

	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		if (e.getSource() == fenetre.getComboBoxMois() || e.getSource() == fenetre.getComboBoxAnnee()) {

			String mois = (String) fenetre.getComboBoxMois().getSelectedItem();
			String annee = (String) fenetre.getComboBoxAnnee().getSelectedItem();

			filterPaiements(mois, annee);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    JTable table = fenetre.getTable();
	    int row = table.getSelectedRow();

	    if (row == -1) {
	    	return;
	    }

	    String designation = table.getValueAt(row, 4).toString();

	    if ("Loyer".equals(designation)) {
	        fenetre.getButtonQuittance().setEnabled(true);
	        try {
	            String idPaiement = table.getValueAt(row, 0).toString();
	            DaoPaiement daoPaiement = new DaoPaiement();
	            paiementSelectionne = daoPaiement.findById(idPaiement);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
