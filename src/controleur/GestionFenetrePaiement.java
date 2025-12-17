package controleur;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.*;

public class GestionFenetrePaiement extends GestionHeaderEtFooter {

    private FenetrePaiement fenetre;
    private String idLoc;
    private List<Paiement> paiements;


    public GestionFenetrePaiement(FenetrePaiement fenetre, String idLoc) {
        super(fenetre);
        this.fenetre = fenetre;
        this.idLoc = idLoc;
        chargerDonnees();
        afficherDetailsPaiement();
        setProgressBar();


    }

    @Override
    protected void gererBoutonSpecifique(String texte) {

        switch (texte) {

            case "Ajouter paiement":
                FenetreAjouterPaiement fenAjouterPaiement = new FenetreAjouterPaiement();
                fenetre.getLayeredPane().add(fenAjouterPaiement);
                fenAjouterPaiement.setVisible(true);
                break;
        }
    }

    
    @Override
    protected void gererBoutonRetour(String texte) throws SQLException {
        if ("Retour".equals(texte)) {
        	DaoLocataire dl = new DaoLocataire();
        	List<Locataire> liste = dl.findLocatairesMemeBien(idLoc);
            FenetreLocataire fen = new FenetreLocataire("Paiement",liste);
            fen.setVisible(true);
            fenetre.dispose();
        }
    }
    
    public void chargerDonnees()  {
    	DaoPaiement dao;
        try {
            dao = new DaoPaiement();
            paiements = dao.findPaiementsByLocataire(idLoc); // store in field
            DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
            model.setRowCount(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Paiement p : paiements) {
                String dateFormatee = p.getDatepaiement().toLocalDate().format(formatter);
                Object[] ligne = {p.getId_paiement(), p.getContratLocation().getNumeroDeContrat(), dateFormatee, p.getMontant()};
                model.addRow(ligne);
            }

            for (Paiement p : paiements) {
                Object[] ligne = {p.getId_paiement(), p.getContratLocation().getNumeroDeContrat(), 
                                  p.getDatepaiement().toString(), p.getMontant()};
                model.addRow(ligne);
            }
            fenetre.getLblPaiementMois().setText(String.format("%.2f", getMontantPaiementMois()));
            java.time.LocalDate dernier = getDateDernierPaiement();
            fenetre.getLblDateDernierPaiement().setText(
                dernier != null ? dernier.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "Aucun paiement"
            );
            fenetre.getLblTotalPaiementAnnees().setText(String.format("%.2f", getMontantTotalAnnee()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                    fenetre.getLblValPaiement().setText(String.valueOf(montant));
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
    
    private double getMontantTotalAnnee() {
    	double total = 0;
       LocalDate today = LocalDate.now();
        for (Paiement p : paiements) {
            LocalDate dateP = p.getDatepaiement().toLocalDate();
            if (dateP.getYear() == today.getYear()) {
                total += p.getMontant();
            }
        }
        return total;
    }
    
    private double getMontantPaiementMois() {
    	double total = 0;
        LocalDate today = LocalDate.now();
        for (Paiement p : paiements) {
            LocalDate dateP = p.getDatepaiement().toLocalDate();
            if (dateP.getYear() == today.getYear() && dateP.getMonthValue() == today.getMonthValue()) {
                total += p.getMontant();
            }
        }
        return total;
    }
    
    private void filterPaiementsParMois(String mois) {
    	DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
        model.setRowCount(0);

        for (Paiement p : paiements) {
            LocalDate datePaiement = p.getDatepaiement().toLocalDate();
            boolean ajouter = false;

            if ("Mois".equals(mois)) {
                ajouter = true; 
            } else {
                int moisInt = convertirMoisEnInt(mois);
                if (datePaiement.getMonthValue() == moisInt) {
                    ajouter = true;
                }
            }

            if (ajouter) {
                Object[] ligne = {
                    p.getId_paiement(),
                    p.getContratLocation().getNumeroDeContrat(),
                    p.getDatepaiement().toString(),
                    p.getMontant()
                };
                model.addRow(ligne);
            }
        }
    }
    
    private int convertirMoisEnInt(String mois) {
    	switch(mois) {
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
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        if (e.getSource() == fenetre.getComboBoxMois()) {
            String moisSelectionne = (String) fenetre.getComboBoxMois().getSelectedItem();
            filterPaiementsParMois(moisSelectionne);
        }
    }
    
    private void setProgressBar() {
    	DaoPaiement dao = new DaoPaiement();
    	List<Paiement> listeToutesPaiements = dao.findAll();
    	double totalPaiement = 0;
    	for (Paiement p : listeToutesPaiements) {
    		totalPaiement += p.getMontant();
    	}
    	double total = 0;
    	List<Paiement> paiements = dao.findPaiementsByLocataire(idLoc);
    	for (Paiement p2 : paiements) {
    		total += p2.getMontant();
    	}
    
    	int progress = (int) ((total / totalPaiement) * 100); 
    	fenetre.getProgressBar().setValue(progress);    }


}
