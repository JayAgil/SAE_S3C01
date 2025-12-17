package controleur;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter {

	private FenetreLocataire fenetre;
	private List<Locataire> locataires;
	private Locataire locataireSelectionne;

	public GestionFenetreLocataire(FenetreLocataire fenetre, List<Locataire> locataires) {
		super(fenetre);
		this.fenetre = fenetre;
		this.locataires = locataires;
		afficherTextFields();
	}

	@Override
	protected void gererBoutonSpecifique(String texte) {

		switch (texte) {

		case "Ajouter locataire":
			FenetreAjouterLocataire fenAjouterLocataire = new FenetreAjouterLocataire();
			fenetre.getLayeredPane().add(fenAjouterLocataire);
			fenAjouterLocataire.setVisible(true);
			break;
		case "Paiement":
			
			 if (locataireSelectionne != null) {
	                new FenetrePaiement(locataireSelectionne.getIdLocataire()).setVisible(true);
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
			case "FenetrePrincipale":
				FenetrePrincipale fp1 = new FenetrePrincipale();
				fp1.setVisible(true);
				break;
			case "BienLouable":
				FenetreBienLouable fp2 = new FenetreBienLouable(null, null);
				fp2.setVisible(true);
				break;
			case "FenContratLocation":
				FenetreContratLocation fp3 = new FenetreContratLocation("FenBienLouable",null);
				fp3.setVisible(true);
				break;
			default:
				FenetreBienLouable fpDefault = new FenetreBienLouable(null, null);
				fpDefault.setVisible(true);
				break;
			}
		}
	}

	public void chargerDonnes() {
		JTable table = fenetre.getTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); 
		for (Locataire loc : fenetre.getListe()) {
			Object[] ligne = { loc.getIdLocataire(), loc.getNom(), loc.getPrenom(), loc.getTel(), loc.getAdresse() };
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
	    ImageIcon icon = new ImageIcon("images/locataire1.jpg");
	    fenetre.getLblPhoto().setIcon(icon);
	}

}
