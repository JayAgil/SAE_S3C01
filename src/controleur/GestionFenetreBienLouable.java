package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienLouable;
import modele.ChargesGenerales;
import modele.Compteur;
import modele.ContratLocation;
import modele.Facture;
import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienLouable;
import modele.dao.DaoChargesGenerales;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoFacture;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.FenetreAjouterBienLouable;
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
	private BienLouable bien; 

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
	
	public ContratLocation getDonneesContratByBien() throws SQLException{
		DaoContratLocation dCL = new DaoContratLocation();
		String idBien = this.fenetrebienlouable.getChosenBien();
		return dCL.findCLByBien(idBien);
	}

	public List<ChargesGenerales> getDonneesChargesGeneraleByBien() throws SQLException {
		DaoChargesGenerales dao = new DaoChargesGenerales();
		return dao.findByIdBien(bien.getIdBienLouable());
	}
	
	public List<Compteur> getDonneesCompteur() throws SQLException {
		DaoCompteur dao = new DaoCompteur();
		String idBien = this.fenetrebienlouable.getChosenBien();
		return dao.findByIdBien(idBien);
	}
	
	public List<Facture> getDonneesTravauxByBien() throws SQLException {
		DaoFacture dao = new DaoFacture();
		return dao.findFactureByBienLouable(this.bien.getIdBienLouable());
		
	}

	public BienLouable getBien() {
		return bien;
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {

		case "Diagnostics":
			DaoBienLouable dBL = new DaoBienLouable();
			BienLouable bL = dBL.findById(this.fenetrebienlouable.getChosenBien());
			new FenetreDiagnostic(bL).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Contrat":
			DaoContratLocation dCl = new DaoContratLocation();
			ContratLocation cl = dCl.findCLByBien(this.bien.getIdBienLouable());
			new FenetreContratLocation("FenBienLouable", cl).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Charges":
			new FenetreCharges("FenetreBienLouable", getDonneesChargesGeneraleByBien()).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Travaux":
			new FenetreTravaux("FenetreBienLouable",getDonneesTravauxByBien(),bien).setVisible(true);
			fenetrebienlouable.dispose();
			break;
			
		case "Ajouter":
			DaoBatiment dao = new DaoBatiment();
			Batiment b = dao.findBatimentByBien(bien.getIdBienLouable());
            FenetreAjouterBienLouable ajout = new FenetreAjouterBienLouable(b,this);
            fenetre.getLayeredPane().add(ajout);
            ajout.setVisible(true);
            break;

		case "Compteur":
			new FenetreCompteurs("FenetreBienLouable", getDonneesCompteur()).setVisible(true);
			fenetrebienlouable.dispose();
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

	public void chargerBienEtRemplirFormulaire(String idBien) {
	    try {
	        DaoBienLouable daoBien = new DaoBienLouable();
	        BienLouable bienSelectionne = daoBien.findById(idBien);
	        if (bienSelectionne == null) return;

	        DaoContratLocation daoCL = new DaoContratLocation();
	        ContratLocation contrat = daoCL.findCLByBien(idBien);

	        DaoChargesGenerales daoCharge = new DaoChargesGenerales();
	        List<ChargesGenerales> charges = daoCharge.findByIdBien(idBien);
	        double totalCharge = charges.stream()
	                                    .mapToDouble(ChargesGenerales::getMontant)
	                                    .sum();
	        
	        DaoLocataire daoLoc = new DaoLocataire();
	        List<Locataire> locataires = daoLoc.findLocataireByContrat(contrat.getNumeroDeContrat());

	        DaoFacture daoFacture = new DaoFacture();
	        Facture facture = daoFacture.findDateDernierTravauxByBien(idBien);

	        DaoPaiement daoPaiement = new DaoPaiement();
	        Paiement dernierPaiement = daoPaiement.findDateDernierPaiementByCL(contrat.getNumeroDeContrat());

	        this.bien = bienSelectionne;
	        remplirFormulaire(bienSelectionne, contrat, totalCharge, locataires, facture, dernierPaiement);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	private void ouvrirFenetreLocataire(String idBien) {
		try {
			DaoLocataire daoLocataire = new DaoLocataire();
			List<Locataire> locataires = daoLocataire.findLocataireByBienLouable(idBien);
			DaoBienLouable db = new DaoBienLouable();
			BienLouable bien = db.findById(idBien);
			FenetreLocataire fen = new FenetreLocataire("FenetreBienLouable", locataires, bien);
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

	public void remplirFormulaire(
	        BienLouable bien,
	        ContratLocation cl,
	        double charge,
	        List<Locataire> loc,
	        Facture fac,
	        Paiement date) {
	    if (loc != null && !loc.isEmpty()) {
	        fenetrebienlouable.getTextFieldNom().setText(loc.get(0).getNom());
	    } else {
	        fenetrebienlouable.getTextFieldNom().setText("");
	    }

	    fenetrebienlouable.getTextFieldLoyerMen()
	            .setText(cl != null ? String.valueOf(cl.getMontantMensuel()) : "");

	    fenetrebienlouable.getTextFieldNF()
	            .setText(bien.getNumeroFiscale());

	    fenetrebienlouable.getTextFieldAdresse()
	            .setText(bien.getAdresse());

	    fenetrebienlouable.getTextFieldSurfaceHab()
	            .setText(String.valueOf(bien.getSurfaceHabituable()));

	    fenetrebienlouable.getTextFieldNbDPieces()
	            .setText(String.valueOf(bien.getNbPieces()));

	    fenetrebienlouable.getTextFieldBienLoauble()
	            .setText(bien.getTypeBienLouable());

	    if (bien.getBatiment() != null) {
	        fenetrebienlouable.getTextFieldBatiment()
	                .setText(bien.getBatiment().getAdresse());
	    } else {
	        fenetrebienlouable.getTextFieldBatiment().setText("");
	    }
	    fenetrebienlouable.getTextFieldDFC()
	            .setText(cl != null ? String.valueOf(cl.getDateFin()) : "");
	    if (fac != null && fac.getDateDeFacture() != null) {
	        fenetrebienlouable.getTextFieldDT()
	                .setText(fac.getDateDeFacture().toString());
	    } else {
	        fenetrebienlouable.getTextFieldDT().setText("");
	    }

	    fenetrebienlouable.getTextFieldTotalCharges()
	            .setText(String.valueOf(charge));
	    if (date != null && date.getDatepaiement() != null) {
	        fenetrebienlouable.getTextFieldDP()
	                .setText(date.getDatepaiement().toString());
	    } else {
	        fenetrebienlouable.getTextFieldDP().setText("");
	    }
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
