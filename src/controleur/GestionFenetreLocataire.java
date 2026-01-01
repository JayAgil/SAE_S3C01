package controleur;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoPaiement;
import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter {

	private FenetreLocataire fenetre;
	private List<Locataire> locataires;
	private Locataire locataireSelectionne;

	public GestionFenetreLocataire(FenetreLocataire fenetre, List<Locataire> locataires) {
		super(fenetre);
		this.fenetre = fenetre;
		this.locataires = locataires;
		chargerDonnes();
		afficherTextFields();
		
		if (locataires != null && !locataires.isEmpty()) {
	        locataireSelectionne = locataires.get(0);
	        fenetre.getTable().setRowSelectionInterval(0, 0);
	        afficherDetails(locataireSelectionne);
	    }
		}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {

		switch (texte) {

		case "Ajouter locataire":
			FenetreAjouterLocataire fenAjouterLocataire = new FenetreAjouterLocataire();
			fenetre.getLayeredPane().add(fenAjouterLocataire);
			fenAjouterLocataire.setVisible(true);
			break;
		case "Paiement":
			 DaoPaiement dao = new DaoPaiement();
	         List<Paiement> paiements = dao.findPaiementsByLocataire(locataireSelectionne.getIdLocataire()); 
			 if (locataireSelectionne != null) {
	                new FenetrePaiement(paiements,locataireSelectionne.getIdLocataire()).setVisible(true);
	                fenetre.dispose();
	            } else {
	                JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un locataire !");
	            }
	            break;
		}
	}
	

	@Override
	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
			String fenAvant = fenetre.getNomFenAvant();
			switch (fenAvant) {
			case "FenetreBienLouable":
				FenetreBienLouable fp2 = new FenetreBienLouable("FenPrincipale", this.fenetre.getBl());
				fp2.setVisible(true);
				this.fenetre.dispose();
				break;
			case "FenContratLocation":
				FenetreContratLocation fp3 = new FenetreContratLocation("FenBienLouable",null);
				fp3.setVisible(true);
				break;
			case "FenPrincipale":
				FenetrePrincipale fp4 = new FenetrePrincipale();
				fp4.setVisible(true);
				break;
				
			}}
		
		
	}

	public void chargerDonnes() {
		JTable table = fenetre.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); 
		for (Locataire loc : locataires) {
			Object[] ligne = { loc.getIdLocataire(), loc.getNom(), loc.getPrenom(), loc.getAdresse(), loc.getTel(), loc.getEmail() };
			model.addRow(ligne);
		}

	}
	
	private void afficherTextFields() {
		JTable table = fenetre.getTable();
		table.getSelectionModel().addListSelectionListener(e -> {
	    if (!e.getValueIsAdjusting()) {
	            int selectedRow = table.getSelectedRow();

	            if (selectedRow >= 0) {
	            	locataireSelectionne = locataires.get(selectedRow);
	                afficherDetails(locataireSelectionne);
	            }
	        }
	    });
		 
	}
	private void afficherDetails(Locataire loc) {
	    fenetre.getTextFieldNom().setText(loc.getNom());
	    fenetre.getTextFieldPrenom().setText(loc.getPrenom());
	    fenetre.getTextFieldTel().setText(loc.getTel());
	    String dateNaissance = loc.getDateDeNaissance()
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
fenetre.getTextFieldDateNaissance().setText(dateNaissance);	    fenetre.getTextFieldEmail().setText(loc.getEmail());
	    fenetre.getTextFieldLieuNaissance().setText(loc.getLieuDeNaissance());
	    fenetre.getTextFieldProfession().setText(loc.getProfession());
	    fenetre.getTextFieldSalaire().setText(String.valueOf(loc.getSalaire()));
	    fenetre.getTextFieldSituationFamiliale().setText(loc.getSituationFamiliale());
	    fenetre.getTextFieldAdresse().setText(loc.getAdresse());
	    ImageIcon icon = new ImageIcon(loc.getImage());
	    fenetre.getLblPhoto().setIcon(icon);
	}

}
