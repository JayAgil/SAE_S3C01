package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.*;
import modele.dao.*;
import vue.*;

/**
 * Contrôleur de la fenêtre de gestion des biens louables. Cette classe permet :
 * <li>d'afficher les biens louables d’un bâtiment</li>
 * <li>de sélectionner un bien et afficher ses informations détaillées</li>
 * <li>de gérer les contrats, charges, travaux, compteurs et locataires</li>
 * <li>d'assurer la navigation entre les différentes fenêtres associées</li>
 */
public class GestionFenetreBienLouable extends GestionHeaderEtFooter implements MouseListener {

    private FenetreBienLouable fenetre;
    private BienLouable bien;
    private String idBien;

    /**
     * Constructeur du contrôleur de la fenêtre Bien Louable.
     *
     * @param fenetre fenêtre Bien Louable associée
     * @param bien    bien louable sélectionné
     */
    public GestionFenetreBienLouable(FenetreBienLouable fenetre, BienLouable bien) {
        super(fenetre);
        this.fenetre = fenetre;
        this.bien = bien;

        // Ajout du MouseListener sur le tableau
        fenetre.getTable().addMouseListener(this);
    }

    // --- DAO Helpers simplifiés ---
    private List<BienLouable> getBiensDuBatiment() {
        if (bien == null || bien.getBatiment() == null) return Collections.emptyList();
        try { return new DaoBienLouable().findByBatiment(bien.getBatiment().getAdresse()); }
        catch (SQLException e) { e.printStackTrace(); return Collections.emptyList(); }
    }

    private ContratLocation getContrat(String id) throws SQLException { return new DaoContratLocation().findCLByBien(id); }
    private List<ChargesGenerales> getCharges(String id) throws SQLException { return new DaoChargesGenerales().findByIdBien(id); }
    private List<Compteur> getCompteurs(String id) throws SQLException { return new DaoCompteur().findByIdBien(id); }
    private Facture getDernierTravaux(String id) throws SQLException { return new DaoFacture().findDateDernierTravauxByBien(id); }
    private List<Locataire> getLocataires(String idContrat) throws SQLException { return new DaoLocataire().findLocataireByContrat(idContrat); }
    private Paiement getDernierPaiement(String idContrat) throws SQLException { return new DaoPaiement().findDateDernierPaiementByCL(idContrat); }

    public BienLouable getBien() { return bien; }

    // --- Gestion des boutons ---
    @Override
    protected void gererBoutonSpecifique(String texte) throws SQLException {
        switch (texte) {
            case "Diagnostics" -> {
                BienLouable bL = new DaoBienLouable().findById(fenetre.getChosenBien());
                new FenetreDiagnostic(bL).setVisible(true);
                fenetre.dispose();
            }
            case "Contrat" -> {
                if (idBien == null || idBien.isEmpty()) {
                    JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un bien louable avant d'ouvrir le contrat", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                bien = new DaoBienLouable().findById(idBien);
                ContratLocation cl = getContrat(idBien);
                new FenetreContratLocation("FenBienLouable", cl, bien).setVisible(true);
                fenetre.dispose();
            }
            case "Charges" -> { new FenetreCharges("FenetreBienLouable", getCharges(bien.getIdBienLouable()), bien).setVisible(true); fenetre.dispose(); }
            case "Travaux" -> { new FenetreTravaux("FenetreBienLouable", Collections.singletonList(getDernierTravaux(bien.getIdBienLouable())), bien).setVisible(true); fenetre.dispose(); }
            case "Ajouter" -> {
                Batiment bat = new DaoBatiment().findBatimentByBien(bien.getIdBienLouable());
                FenetreAjouterBienLouable ajout = new FenetreAjouterBienLouable(bat, this);
                fenetre.getLayeredPane().add(ajout); ajout.setVisible(true);
            }
            case "Retirer" -> {
                int idx = fenetre.getTable().getSelectedRow();
                if (idx != -1) {
                    BienLouable toDelete = getBiensDuBatiment().get(idx);
                    new DaoBienLouable().delete(toDelete);
                    chargerDonnees();
                }
                if (!getBiensDuBatiment().isEmpty()) {
                    bien = getBiensDuBatiment().get(0);
                    idBien = bien.getIdBienLouable();
                    chargerBienEtRemplirFormulaire(idBien);
                }
                JOptionPane.showMessageDialog(fenetre, "Bien Louable retiré avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
            }
            case "Locataire" -> {
                if (idBien == null || idBien.isEmpty()) {
                    JOptionPane.showMessageDialog(fenetre, "Choisissez un bien avant d'aller à la fenêtre locataire!", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else ouvrirFenetreLocataire(idBien);
            }
            case "Compteur" -> { new FenetreCompteurs("FenetreBienLouable", getCompteurs(fenetre.getChosenBien()), bien).setVisible(true); fenetre.dispose(); }
        }
    }

    // --- Chargement des données d’un bien ---
    public void chargerBienEtRemplirFormulaire(String idBien) {
        try {
            bien = new DaoBienLouable().findById(idBien);
            ContratLocation cl = getContrat(idBien);

            List<Locataire> loc = (cl != null) ? getLocataires(cl.getNumeroDeContrat()) : Collections.emptyList();
            Paiement dernierPaiement = (cl != null) ? getDernierPaiement(cl.getNumeroDeContrat()) : null;
            double totalCharge = getCharges(idBien).stream().mapToDouble(ChargesGenerales::getMontant).sum();
            Facture facture = getDernierTravaux(idBien);

            remplirFormulaire(bien, cl, totalCharge, loc, facture, dernierPaiement);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // --- Ouvrir la fenêtre locataire ---
    private void ouvrirFenetreLocataire(String idBien) {
        try {
            List<Locataire> locataires = new DaoLocataire().findLocataireByBienLouable(idBien);
            if (locataires == null || locataires.isEmpty()) {
                JOptionPane.showMessageDialog(fenetre, "Ce bien n'a pas de locataire", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            bien = new DaoBienLouable().findById(idBien);
            new FenetreLocataire("FenetreBienLouable", locataires, bien).setVisible(true);
            fenetre.dispose();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    // --- Charger tous les biens dans le tableau ---
    public void chargerDonnees() {
        DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
        model.setRowCount(0);
        List<BienLouable> liste = getBiensDuBatiment();
        liste.forEach(b -> model.addRow(new Object[]{b.getIdBienLouable(), b.getAdresse(), b.getNbPieces(), b.getTypeBienLouable()}));

        boolean hasBien = !liste.isEmpty();
        fenetre.getBtnContrat().setEnabled(hasBien);
        fenetre.getBtnCharge().setEnabled(hasBien);
        fenetre.getBtnTravaux().setEnabled(hasBien);
        fenetre.getBtnCompteur().setEnabled(hasBien);
    }

    /**
     * Remplit le formulaire avec les données du bien sélectionné.
     */
    public void remplirFormulaire(BienLouable bien, ContratLocation cl, double charge, List<Locataire> loc, Facture fac, Paiement date) {
        fenetre.getTextFieldNom().setText(!loc.isEmpty() ? loc.get(0).getNom() : "Aucun locataire");
        fenetre.getTextFieldLoyerMen().setText(cl != null ? String.format("%.2f €", cl.getMontantMensuel()) : "Pas de contrat");

        fenetre.getTextFieldNF().setText(bien != null ? bien.getNumeroFiscale() : "—");
        fenetre.getTextFieldAdresse().setText(bien != null ? bien.getAdresse() : "—");
        fenetre.getTextFieldSurfaceHab().setText(bien != null ? String.valueOf(bien.getSurfaceHabituable()) : "—");
        fenetre.getTextFieldNbDPieces().setText(bien != null ? String.valueOf(bien.getNbPieces()) : "—");
        fenetre.getTextFieldBienLoauble().setText(bien != null ? bien.getTypeBienLouable() : "—");
        fenetre.getTextFieldBatiment().setText(bien != null && bien.getBatiment() != null ? bien.getBatiment().getAdresse() : "Aucun bâtiment");

        fenetre.getTextFieldDFC().setText(cl != null && cl.getDateFin() != null ? cl.getDateFin().toString() : "Pas de contrat actif");
        fenetre.getTextFieldDT().setText(fac != null && fac.getDateDeFacture() != null ? fac.getDateDeFacture().toString() : "Aucun travaux enregistré");
        fenetre.getTextFieldTotalCharges().setText(charge > 0 ? String.format("%.2f €", charge) : "Aucune charge");
        fenetre.getTextFieldDP().setText(date != null && date.getDatepaiement() != null ? date.getDatepaiement().toString() : "Aucun paiement enregistré");
    }

    @Override
    protected void gererBoutonRetour(String texte) {
        if ("Retour".equals(texte)) {
            fenetre.dispose();
            new FenetrePrincipale().setVisible(true);
        }
    }

    // --- MouseListener methods ---
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            JTable table = (JTable) e.getSource();
            int row = table.rowAtPoint(e.getPoint());
            if (row == -1) return;

            idBien = table.getModel().getValueAt(table.convertRowIndexToModel(row), 0).toString();
            if (e.getClickCount() == 2) ouvrirFenetreLocataire(idBien);
            else chargerBienEtRemplirFormulaire(idBien);
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
