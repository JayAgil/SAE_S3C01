package controleur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ChargesGenerales;
import modele.dao.DaoBienLouable;
import vue.*;

public class GestionFenetreCharges extends GestionHeaderEtFooter{

    private FenetreCharges fenetre;
    private List<ChargesGenerales> donnees = new ArrayList<>();

    public GestionFenetreCharges(FenetreCharges fenetre, List<ChargesGenerales> list) throws SQLException {
        super(fenetre);
        this.fenetre = fenetre;
        this.donnees = list;
    }
   

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter charge":
                FenetreAjouterCharge fenAjouterCharge = new FenetreAjouterCharge();
                fenetre.getLayeredPane().add(fenAjouterCharge);
                fenAjouterCharge.setVisible(true);
                break;

            case "Quitter":
                fenetre.dispose();
                break;
        }
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
    protected void gererBoutonRetour(String texte) throws SQLException {
    	if ("Retour".equals(texte)) {
    	    fenetre.dispose();
    	    String fenAvant = fenetre.getFenetreAvant();

    	    switch (fenAvant) {
    	        case "FenPrincipale":
    	            FenetrePrincipale fp1 = new FenetrePrincipale();
    	            fp1.setVisible(true);
    	            break;
    	        case "FenetreBienLouable":
    	        	DaoBienLouable dBL = new DaoBienLouable();
    	        	BienLouable data = dBL.findByIdCharge(donnees.get(0).getIdChargesGenerales());
    	            FenetreBienLouable fp2 = new FenetreBienLouable("FenPrincipale", data);
    	            fp2.setVisible(true);
    	            break;
    	        default:
				FenetreBienLouable fpDefault;
				try {
					fpDefault = new FenetreBienLouable(null, null);
    	            fpDefault.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	            break;
    	    }
    	}
    }

}
