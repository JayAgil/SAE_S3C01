package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JTable;

import modele.BienLouable;
import modele.dao.DaoBienLouable;
import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener {

	private FenetreBienLouable fenetrebienlouable;

	public GestionFenetreBienLouable(FenetreBienLouable fenetre) {
		super(fenetre);
		this.fenetrebienlouable = fenetre;
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {

		case "Diagnostics":
			new FenetreDiagnostic().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Contrat":
			new FenetreContratLocation("FenBienLouable").setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Charges":
			new FenetreCharges("FenetreBienLouable").setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Travaux":
			new FenetreTravaux().setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Compteur":
			new FenetreCompteurs("FenereBienLouable").setVisible(true);
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
			int column = table.columnAtPoint(e.getPoint());
			int targetColumn = 0;
			if (column == targetColumn) {
				FenetreLocataire fen = new FenetreLocataire("FenetreLocataire");
				fen.setVisible(true);
				fenetre.dispose();
			}
			return;
		}
		try {
			DaoBienLouable daoBien = new DaoBienLouable();
			BienLouable bien = daoBien.findById(idBien);
			if (bien != null) {
				remplirFormulaire(bien);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private void remplirFormulaire(BienLouable b) {

	    fenetrebienlouable.getTextFieldNom().setText(b.get);
	    fenetrebienlouable.getTextFieldLoyerMen(String.valueOf(b.getLoyerMensuel()));
	    fenetrebienlouable.getTextFieldNF().setText(b.getNumeroFiscale());
	    fenetrebienlouable.getTextFieldAdresse().setText(b.getAdresse());
	    fenetrebienlouable.getTextFieldSurfaceHab().setText(String.valueOf(b.getSurfaceHabitable()));
	    fenetrebienlouable.getTextFieldNbDPieces().setText(String.valueOf(b.getNombrePieces()));
	    fenetrebienlouable.getTextFieldBienLoauble().setText(b.getTypeBien());
	    fenetrebienlouable.getTextFieldBatiment().setText(b.getBatiment());
	    fenetrebienlouable.getTextFieldDT(String.valueOf(b.getTotalCharges()));
	    fenetrebienlouable.getTextFieldTotalCharges().setText(b.getDateFinContrat());
	    fenetrebienlouable.getTextFieldDFC().setText(b.getDateFinContrat());
	    fenetrebienlouable.getTextFieldDP().setText(b.getDateFinContrat());
	    
	}


	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
			FenetrePrincipale fp = new FenetrePrincipale();
			fp.setVisible(true);
		}
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
