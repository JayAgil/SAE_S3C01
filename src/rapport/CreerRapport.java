package rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.*;
import modele.*;

import modele.dao.*;

public class CreerRapport {

	public static void main(String[] args) throws IOException, SQLException {
		OutputStream fileOut = new FileOutputStream("Rapport_SAE_G5.docx");
		InputStream modele = new FileInputStream("vide.docx");
		XWPFDocument document = new XWPFDocument(modele);

		// Connecter à la BD
		UtOracleDataSource.CreerAcces("NRK4981A", "abcd123");

		// TITRE
		XWPFParagraph title = document.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun runTitle = title.createRun();
		runTitle.setBold(true);
		runTitle.setFontSize(20);
		runTitle.setText("Gestion des biens immobiliers");

		// Introduction
		XWPFParagraph intro = document.createParagraph();
		intro.setAlignment(ParagraphAlignment.BOTH);
		XWPFRun runIntro = intro.createRun();
		runIntro.addCarriageReturn();
		runIntro.setText(
				"Ce rapport présente les propriétés, contrats, locataires, paiements, bâtiments et assurances de l'application.");
		runIntro.addCarriageReturn();

		// BATIMENTS
		XWPFParagraph batTitle = document.createParagraph();
		batTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runBatTitle = batTitle.createRun();
		runBatTitle.addCarriageReturn();
		runBatTitle.setBold(true);
		runBatTitle.setText("1. Bâtiments");
		runBatTitle.addCarriageReturn();

		DaoBatiment daoBat = new DaoBatiment();
		List<Batiment> batiments = daoBat.findAll();

		XWPFTable batTable = document.createTable();
		XWPFTableRow batHeader = batTable.getRow(0);
		batHeader.getCell(0).setText("Adresse");
		batHeader.addNewTableCell().setText("Date Construction");
		miseEnFormeCellules(batHeader, "92D050", true, false);

		for (int i = 0; i < batiments.size(); i++) {
			Batiment b = batiments.get(i);
			XWPFTableRow row = batTable.createRow();
			row.getCell(0).setText(b.getAdresse());
			row.getCell(1).setText(String.valueOf(b.getDateConstruction()));

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// ASSURANCES
		XWPFParagraph assurTitle = document.createParagraph();
		assurTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runAssurTitle = assurTitle.createRun();
		runAssurTitle.addCarriageReturn();
		runAssurTitle.setBold(true);
		runAssurTitle.setText("2. Assurances");
		runAssurTitle.addCarriageReturn();

		DaoAssurance daoAssur = new DaoAssurance();
		List<Assurance> assurances = daoAssur.findAll();

		XWPFTable assurTable = document.createTable();
		XWPFTableRow assurHeader = assurTable.getRow(0);
		assurHeader.getCell(0).setText("Numéro Assurance");
		assurHeader.addNewTableCell().setText("Type");
		assurHeader.addNewTableCell().setText("Prime");
		assurHeader.addNewTableCell().setText("Montant");
		assurHeader.addNewTableCell().setText("Agence");
		assurHeader.addNewTableCell().setText("Adresse Agence");
		assurHeader.addNewTableCell().setText("Téléphone Agence");
		assurHeader.addNewTableCell().setText("Adresse Batiment");
		miseEnFormeCellules(assurHeader, "92D050", true, false);

		for (int i = 0; i < assurances.size(); i++) {
			Assurance a = assurances.get(i);
			XWPFTableRow row = assurTable.createRow();
			row.getCell(0).setText(a.getNumeroAssurance());
			row.getCell(1).setText(a.getTypeAssurance());
			row.getCell(2).setText(String.valueOf(a.getPrime()));
			row.getCell(3).setText(String.valueOf(a.getMontant()));
			row.getCell(4).setText(a.getAgence());
			row.getCell(5).setText(a.getAdresseAgence());
			row.getCell(6).setText(a.getTelAgence());
			row.getCell(7).setText(a.getBatiment().getAdresse());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// BIENS LOUABLES
		XWPFParagraph propTitle = document.createParagraph();
		propTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runPropTitle = propTitle.createRun();
		runPropTitle.setBold(true);
		runPropTitle.setText("3. Propriétés (BienLouable)");
		runPropTitle.addCarriageReturn();

		DaoBienLouable daoBien = new DaoBienLouable();
		List<BienLouable> biens = daoBien.findAll();

		XWPFTable propTable = document.createTable();
		XWPFTableRow headerRow = propTable.getRow(0);
		headerRow.getCell(0).setText("ID Bien");
		headerRow.addNewTableCell().setText("Adresse");
		headerRow.addNewTableCell().setText("Type");
		headerRow.addNewTableCell().setText("Surface");
		headerRow.addNewTableCell().setText("Nb Pièces");
		headerRow.addNewTableCell().setText("Adresse Batiment");
		miseEnFormeCellules(headerRow, "92D050", true, false);

		for (int i = 0; i < biens.size(); i++) {
			BienLouable b = biens.get(i);
			XWPFTableRow row = propTable.createRow();
			row.getCell(0).setText(b.getIdBienLouable());
			row.getCell(1).setText(b.getAdresse());
			row.getCell(2).setText(b.getTypeBienLouable());
			row.getCell(3).setText(String.valueOf(b.getSurfaceHabituable()));
			row.getCell(4).setText(String.valueOf(b.getNbPieces()));
			row.getCell(5).setText(b.getBatiment().getAdresse());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// CONTRATS
		XWPFParagraph contractTitle = document.createParagraph();
		contractTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runContractTitle = contractTitle.createRun();
		runContractTitle.addCarriageReturn();
		runContractTitle.setBold(true);
		runContractTitle.setText("4. Contrats de location");
		runContractTitle.addCarriageReturn();

		DaoContratLocation daoCL = new DaoContratLocation();
		List<ContratLocation> contrats = daoCL.findAll();

		XWPFTable contractTable = document.createTable();
		XWPFTableRow contractHeader = contractTable.getRow(0);
		contractHeader.getCell(0).setText("N° Contrat");
		contractHeader.addNewTableCell().setText("Bien ID");
		contractHeader.addNewTableCell().setText("Montant Mensuel");
		contractHeader.addNewTableCell().setText("Provision Charge");
		contractHeader.addNewTableCell().setText("Solde");
		contractHeader.addNewTableCell().setText("Date Début");
		contractHeader.addNewTableCell().setText("Date Fin");
		miseEnFormeCellules(contractHeader, "92D050", true, false);

		for (int i = 0; i < contrats.size(); i++) {
			ContratLocation c = contrats.get(i);
			XWPFTableRow row = contractTable.createRow();
			row.getCell(0).setText(c.getNumeroDeContrat());
			row.getCell(1).setText(c.getBienLouable().getIdBienLouable());
			row.getCell(2).setText(String.valueOf(c.getMontantMensuel()));
			row.getCell(3).setText(String.valueOf(c.getProvisionCharge()));
			row.getCell(4).setText(String.valueOf(c.getSolde()));
			row.getCell(5).setText(String.valueOf(c.getDateDebut()));
			row.getCell(6).setText(String.valueOf(c.getDateFin()));

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// LOCATAIRES
		XWPFParagraph locTitle = document.createParagraph();
		locTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runLocTitle = locTitle.createRun();
		runLocTitle.addCarriageReturn();
		runLocTitle.setBold(true);
		runLocTitle.setText("5. Locataires");
		runLocTitle.addCarriageReturn();

		DaoLocataire daoLoc = new DaoLocataire();
		List<Locataire> locataires = daoLoc.findAll();

		XWPFTable locTable = document.createTable();
		XWPFTableRow locHeader = locTable.getRow(0);
		locHeader.getCell(0).setText("ID Locataire");
		locHeader.addNewTableCell().setText("Nom");
		locHeader.addNewTableCell().setText("Prénom");
		locHeader.addNewTableCell().setText("Adresse");
		locHeader.addNewTableCell().setText("Téléphone");
		locHeader.addNewTableCell().setText("Email");
		miseEnFormeCellules(locHeader, "92D050", true, false);

		for (int i = 0; i < locataires.size(); i++) {
			Locataire l = locataires.get(i);
			XWPFTableRow row = locTable.createRow();
			row.getCell(0).setText(l.getIdLocataire());
			row.getCell(1).setText(l.getNom());
			row.getCell(2).setText(l.getPrenom());
			row.getCell(3).setText(l.getAdresse());
			row.getCell(4).setText(l.getTel());
			row.getCell(5).setText(l.getEmail());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// PAIEMENTS
		XWPFParagraph payTitle = document.createParagraph();
		payTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runPayTitle = payTitle.createRun();
		runPayTitle.addCarriageReturn();
		runPayTitle.setBold(true);
		runPayTitle.setText("6. Paiements");
		runPayTitle.addCarriageReturn();

		DaoPaiement daoPay = new DaoPaiement();
		List<Paiement> paiements = daoPay.findAll();

		XWPFTable payTable = document.createTable();
		XWPFTableRow payHeader = payTable.getRow(0);
		payHeader.getCell(0).setText("ID Paiement");
		payHeader.addNewTableCell().setText("Contrat N°");
		payHeader.addNewTableCell().setText("Montant");
		payHeader.addNewTableCell().setText("Date Paiement");
		payHeader.addNewTableCell().setText("Designation");
		miseEnFormeCellules(payHeader, "92D050", true, false);

		for (int i = 0; i < paiements.size(); i++) {
			Paiement p = paiements.get(i);
			XWPFTableRow row = payTable.createRow();
			row.getCell(0).setText(p.getId_paiement());
			row.getCell(1).setText(p.getContratLocation().getNumeroDeContrat());
			row.getCell(2).setText(String.valueOf(p.getMontant()));
			row.getCell(3).setText(String.valueOf(p.getDatepaiement()));
			row.getCell(4).setText(p.getDesignation());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// CHARGES GENERALES
		XWPFParagraph chargeTitle = document.createParagraph();
		chargeTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runChargeTitle = chargeTitle.createRun();
		runChargeTitle.addCarriageReturn();
		runChargeTitle.setBold(true);
		runChargeTitle.setText("7. Charges Générales");
		runChargeTitle.addCarriageReturn();

		DaoChargesGenerales daoCharge = new DaoChargesGenerales();
		List<ChargesGenerales> charges = daoCharge.findAll();

		XWPFTable chargeTable = document.createTable();
		XWPFTableRow chargeHeader = chargeTable.getRow(0);
		chargeHeader.getCell(0).setText("ID Charge");
		chargeHeader.addNewTableCell().setText("Type");
		chargeHeader.addNewTableCell().setText("Montant Total");
		chargeHeader.addNewTableCell().setText("Pourcentage");
		chargeHeader.addNewTableCell().setText("Quotité");
		chargeHeader.addNewTableCell().setText("Date Charge");
		chargeHeader.addNewTableCell().setText("Bien Louable");
		miseEnFormeCellules(chargeHeader, "92D050", true, false);

		for (int i = 0; i < charges.size(); i++) {
			ChargesGenerales c = charges.get(i);
			XWPFTableRow row = chargeTable.createRow();
			row.getCell(0).setText(c.getIdChargesGenerales());
			row.getCell(1).setText(c.getTypeCharge());
			row.getCell(2).setText(String.valueOf(c.getMontant()));
			row.getCell(3).setText(String.valueOf(c.getPourcentage()));
			row.getCell(4).setText(String.valueOf(c.getQuotite()));
			row.getCell(5).setText(String.valueOf(c.getDateCharge()));
			row.getCell(6).setText(c.getBienLouable().getIdBienLouable());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		// COMPTEURS
		XWPFParagraph compteurTitle = document.createParagraph();
		compteurTitle.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun runCompteurTitle = compteurTitle.createRun();
		runCompteurTitle.addCarriageReturn();
		runCompteurTitle.setBold(true);
		runCompteurTitle.setText("8. Compteurs");
		runCompteurTitle.addCarriageReturn();

		DaoCompteur daoCompteur = new DaoCompteur();
		List<Compteur> compteurs = daoCompteur.findAll();

		XWPFTable compteurTable = document.createTable();
		XWPFTableRow compteurHeader = compteurTable.getRow(0);
		compteurHeader.getCell(0).setText("ID Compteur");
		compteurHeader.addNewTableCell().setText("Type");
		compteurHeader.addNewTableCell().setText("Partie Fixe");
		compteurHeader.addNewTableCell().setText("Partie Variable");
		compteurHeader.addNewTableCell().setText("Total");
		compteurHeader.addNewTableCell().setText("Date Installation");
		compteurHeader.addNewTableCell().setText("Index Ancien");
		compteurHeader.addNewTableCell().setText("Index Nouveau");
		compteurHeader.addNewTableCell().setText("Bien Louable");
		miseEnFormeCellules(compteurHeader, "92D050", true, false);

		for (int i = 0; i < compteurs.size(); i++) {
			Compteur comp = compteurs.get(i);
			XWPFTableRow row = compteurTable.createRow();
			row.getCell(0).setText(comp.getIdCompteur());
			row.getCell(1).setText(comp.getType());
			row.getCell(2).setText(String.valueOf(comp.getPartieFixe()));
			row.getCell(3).setText(String.valueOf(comp.getPartieVariable()));
			row.getCell(4).setText(String.valueOf(comp.getTotal()));
			row.getCell(5).setText(String.valueOf(comp.getDateInstallation()));
			row.getCell(6).setText(String.valueOf(comp.getIndexAncien()));
			row.getCell(7).setText(String.valueOf(comp.getIndexNouveau()));
			row.getCell(8).setText(comp.getBienLouable().getIdBienLouable());

			String color = (i % 2 == 0) ? "CCFF66" : "99CCFF";
			miseEnFormeCellules(row, color, false, false);
		}

		document.write(fileOut);
		fileOut.close();
		modele.close();
		document.close();
	}

	public static void miseEnFormeCellules(XWPFTableRow row, String hexColor, boolean gras, boolean italique) {
		for (XWPFTableCell cell : row.getTableCells()) {
			XWPFParagraph paragraph = cell.getParagraphs().get(0);
			paragraph.setIndentationFirstLine(0);
			XWPFRun run = paragraph.getRuns().get(0);
			run.setBold(gras);
			run.setItalic(italique);
			cell.setColor(hexColor);
		}
	}

}
