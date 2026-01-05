package controleur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

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
                FenetreAjouterCharge fenAjouterCharge = new FenetreAjouterCharge(this.fenetre.getBl(),this);
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

        String selectedAnnee = (String) fenetre.getComboBoxAnnee().getSelectedItem();
        Integer annee = null; 
        if (!"Année".equals(selectedAnnee)) {
            annee = Integer.parseInt(selectedAnnee);
        }

        int mois = fenetre.getComboBoxMois().getSelectedIndex(); 

        double totalEntretien = 0;
        double totalOrdures = 0;
        double totalAscenseur = 0;

        Map<String, Double> totalParBien = new HashMap<>();

        for (ChargesGenerales c : liste) {
            Date d = c.getDateCharge();
            if (d != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                int chargeAnnee = cal.get(Calendar.YEAR);
                int chargeMois = cal.get(Calendar.MONTH) + 1; 

                boolean memeAnnee = (annee == null || chargeAnnee == annee);
                boolean memeMois = (mois == 0 || chargeMois == mois);

                if (memeAnnee && memeMois) {
                    model.addRow(new Object[]{
                            c.getTypeCharge(),
                            c.getMontant(),
                            c.getPourcentage(),
                            c.getQuotite(),
                            c.getMontant() * c.getPourcentage(),
                            c.getDateCharge()
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
                    totalParBien.put(bien, totalParBien.getOrDefault(bien, 0.0) + c.getMontant());
                }
            }
        }

        fenetre.getLbltotalentretien().setText(String.format("%.2f €", totalEntretien));
        fenetre.getLbltotalorduremenageres().setText(String.format("%.2f €", totalOrdures));
        fenetre.getLbltotalascenceur().setText(String.format("%.2f €", totalAscenseur));

        Map<String, Double> totalParBienAll = new HashMap<>();
        for (ChargesGenerales c : donnees) {
            String bien = c.getBienLouable().getIdBienLouable();
            totalParBienAll.put(bien, totalParBienAll.getOrDefault(bien, 0.0) + c.getMontant());
        }

        List<Map.Entry<String, Double>> sorted =
                totalParBienAll.entrySet().stream()
                    .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                    .toList();

        fenetre.getLbl1er().setText(sorted.size() > 0 ? sorted.get(0).getKey() : "");
        fenetre.getLbl2nde().setText(sorted.size() > 1 ? sorted.get(1).getKey() : "");
        fenetre.getLbl3eme().setText(sorted.size() > 2 ? sorted.get(2).getKey() : "");

        double moyenne = totalParBien.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        fenetre.getLblchargesmoyen().setText(String.format("%.2f €", moyenne));
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
    public void setDonnees(List<ChargesGenerales> donnees) {
		this.donnees = donnees;
	}


}
