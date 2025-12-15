package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ChargesGenerales;
import modele.dao.DaoBienLouable;
import vue.*;

public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener {

	private FenetreBienLouable fenetrebienlouable;
	private List<BienLouable> donnee = new ArrayList<>();

	public GestionFenetreBienLouable(FenetreBienLouable fenetre, List<BienLouable> donnee) {
		super(fenetre);
		this.fenetrebienlouable = fenetre;
		this.donnee = donnee;
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
	
	public void chargerDonnees() throws SQLException {
        List<ChargesGenerales> liste = this.donnees;
        DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
        model.setRowCount(0);

        double totalEntretien = 0;
        double totalOrdures = 0;
        double totalAscenseur = 0;

        Map<String, Double> totalParBien = new HashMap<>();

        for (ChargesGenerales c : liste) {

            model.addRow(new Object[]{
                    c.getTypeCharge(),
                    c.getMontant(),
                    c.getPourcentage(),
                    c.getQuotite(),
                    c.getMontant() * c.getPourcentage(),
                    c.getMois()
            });
            switch (c.getTypeCharge()) {
                case "Entretien":
                    totalEntretien += c.getMontant();
                    break;
                case "Nettoyage":
                    totalOrdures += c.getMontant();
                    break;
                case "Ascenseur":
                    totalAscenseur += c.getMontant();
                    break;
            }
            String bien = c.getBienLouable().getIdBienLouable();
            totalParBien.put(
                    bien,
                    totalParBien.getOrDefault(bien, 0.0) + c.getMontant()
            );
        }
        fenetre.getLbltotalentretien().setText(String.valueOf(totalEntretien + " €"));
        fenetre.getLbltotalorduremenageres().setText(String.valueOf(totalOrdures + " €"));
        fenetre.getLbltotalascenceur().setText(String.valueOf(totalAscenseur + " €"));
        List<Map.Entry<String, Double>> sorted =
                totalParBien.entrySet().stream()
                        .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                        .toList();
        if (sorted.size() > 0) fenetre.getLbl1er().setText(sorted.get(0).getKey());
        if (sorted.size() > 1) fenetre.getLbl2nde().setText(sorted.get(1).getKey());
        if (sorted.size() > 2) fenetre.getLbl3eme().setText(sorted.get(2).getKey());
        double moyenne = totalParBien.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
        int scale = 2;
        double rounded = Math.round(moyenne * Math.pow(10, scale)) / Math.pow(10, scale);
        fenetre.getLblchargesmoyen().setText(String.valueOf(rounded + " €"));
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
