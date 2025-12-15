package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ChargesGenerales;
import modele.ContratLocation;
import modele.Facture;
import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoBienLouable;
import modele.dao.DaoChargesGenerales;
import modele.dao.DaoContratLocation;
import modele.dao.DaoFacture;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetreLocataire;
import vue.FenetrePrincipale;
import vue.FenetreTravaux;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener {

	private FenetreBienLouable fenetrebienlouable;
	private BienLouable bien; // currently selected bien

	public GestionFenetreBienLouable(FenetreBienLouable fenetre, BienLouable bien) {
		super(fenetre);
		this.fenetrebienlouable = fenetre;
		this.bien = bien;
	}

	public List<BienLouable> getListBienWithTheBienNow() {
		try {
			DaoBienLouable daoBL = new DaoBienLouable();
			String idBatiment = bien.getBatiment().getAdresse();
			return daoBL.findByIdBat(idBatiment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return List.of();
	}

	public List<ChargesGenerales> getDonneesChargesGeneraleByBien() throws SQLException {
		DaoChargesGenerales dao = new DaoChargesGenerales();
		return dao.findByIdBien(bien.getIdBienLouable());
	}

	public BienLouable getBien() {
		return bien;
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {

		switch (texte) {

		case "Diagnostics":
			new FenetreDiagnostic().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Contrat":
			new FenetreContratLocation("FenBienLouable", null).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Charges":
			new FenetreCharges("FenetreBienLouable", getDonneesChargesGeneraleByBien()).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Travaux":
			new FenetreTravaux().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Compteur":
			new FenetreCompteurs("FenetreBienLouable").setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Revaloriser":
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(e.getSource() instanceof JTable))
			return;

		JTable table = (JTable) e.getSource();
		int row = table.rowAtPoint(e.getPoint());
		if (row == -1)
			return;

		int modelRow = table.convertRowIndexToModel(row);
		String idBien = table.getModel().getValueAt(modelRow, 0).toString();
		if (e.getClickCount() == 2) {
			ouvrirFenetreLocataire(idBien);
			return;
		}
		chargerBienEtRemplirFormulaire(idBien);
	}

	private void chargerBienEtRemplirFormulaire(String idBien) {
		try {
			DaoBienLouable daoBien = new DaoBienLouable();
			BienLouable bienSelectionne = daoBien.findById(idBien);
			DaoContratLocation daoCL = new DaoContratLocation();
			ContratLocation cl = daoCL.findCLByBien(idBien);
			DaoChargesGenerales daoCharge = new DaoChargesGenerales();
			ChargesGenerales charge = daoCharge.findTotalChargesByBien(idBien);
			DaoLocataire daoLoc = new DaoLocataire();
			String idCL = cl.getNumeroDeContrat();
			List<Locataire> locataires = daoLoc.findNomLocataireByContrat(idCL);
			DaoFacture daoFac = new DaoFacture();
			Facture fac = daoFac.findDateDernierTravauxByBien(idBien);
			DaoPaiement daoPaiement = new DaoPaiement();
			Paiement datePaiement = daoPaiement.findDateDernierPaiementByCL(idCL);
			if (bienSelectionne != null) {
				this.bien = bienSelectionne;
				remplirFormulaire(bienSelectionne,cl,charge,locataires,fac,datePaiement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void ouvrirFenetreLocataire(String idBien) {
		try {
			DaoLocataire daoLocataire = new DaoLocataire();
			List<Locataire> locataires = daoLocataire.findLocataireByBienLouable(idBien);
			FenetreLocataire fen = new FenetreLocataire("FenetreLocataire", locataires);
			fen.setVisible(true);
			fenetre.dispose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void chargerDonnees() throws SQLException {

		List<BienLouable> liste = getListBienWithTheBienNow();
		DefaultTableModel model = (DefaultTableModel) fenetrebienlouable.getTable().getModel();

		model.setRowCount(0);

		for (BienLouable b : liste) {
			model.addRow(
					new Object[] { b.getIdBienLouable(), b.getAdresse(), b.getNbPieces(), b.getTypeBienLouable() });
		}
	}

	public void remplirFormulaire(BienLouable bien, ContratLocation cl,ChargesGenerales charge,List<Locataire> loc,Facture fac,Paiement date) {
		String nom = loc.get(0).toString();
		String datePaiement = date.getDatepaiement().toString();
		fenetrebienlouable.getTextFieldNom().setText(nom);
		fenetrebienlouable.getTextFieldLoyerMen().setText(String.valueOf(cl.getMontantMensuel()));
		fenetrebienlouable.getTextFieldNF().setText(bien.getNumeroFiscale());
		fenetrebienlouable.getTextFieldAdresse().setText(bien.getAdresse());
		fenetrebienlouable.getTextFieldSurfaceHab().setText(String.valueOf(bien.getSurfaceHabituable()));
		fenetrebienlouable.getTextFieldNbDPieces().setText(String.valueOf(bien.getNbPieces()));
		fenetrebienlouable.getTextFieldBienLoauble().setText(bien.getTypeBienLouable());
		if (bien.getBatiment() != null) {
			fenetrebienlouable.getTextFieldBatiment().setText(bien.getBatiment().getAdresse());
		}
		fenetrebienlouable.getTextFieldDFC().setText(String.valueOf(cl.getDateFin()));
		fenetrebienlouable.getTextFieldDT().setText(String.valueOf(fac.getDateDeFacture()));
		fenetrebienlouable.getTextFieldTotalCharges().setText(String.valueOf(charge.getMontant()));
		fenetrebienlouable.getTextFieldDP().setText(datePaiement);

	}

	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
			new FenetrePrincipale().setVisible(true);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
