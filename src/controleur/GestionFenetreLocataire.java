package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.ContratLocation;
import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoContratLocation;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter implements MouseListener{

	private FenetreLocataire fenetre;
	private List<Locataire> locataires;
	private Locataire locataireSelectionne;

	@SuppressWarnings("deprecation")
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
		if (this.fenetre.getNomFenAvant() == "FenPrincipale") {
			this.fenetre.getBtnAjouterLocataire().hide();
		}
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {

		switch (texte) {

		case "Ajouter locataire":
			FenetreAjouterLocataire fenAjouterLocataire = new FenetreAjouterLocataire(this, this.fenetre.getBl());
			fenetre.getLayeredPane().add(fenAjouterLocataire);
			fenAjouterLocataire.setVisible(true);
			break;
		case "Retirer locataire":
			if (locataireSelectionne != null) {
				int confirm = JOptionPane.showConfirmDialog(fenetre, "Voulez-vous vraiment supprimer ce locataire ?",
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					try {
						DaoLocataire dao = new DaoLocataire();
						dao.delete(locataireSelectionne);
						locataires.remove(locataireSelectionne);
						chargerDonnes();
						locataireSelectionne = null;
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(fenetre, "Erreur lors de la suppression du locataire !");
					}
				}
			} else {
				JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un locataire !");
			}
			break;

		case "Paiement":
			DaoPaiement dao = new DaoPaiement();
			List<Paiement> paiements = dao.findPaiementsByLocataire(locataireSelectionne.getIdLocataire());
			if (locataireSelectionne != null) {
				new FenetrePaiement("FenLocataire", paiements, locataireSelectionne.getIdLocataire(),
						locataireSelectionne).setVisible(true);
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
			case "FenPrincipale":
				FenetrePrincipale fp4 = new FenetrePrincipale();
				fp4.setVisible(true);
				break;

			}
		}

	}

	public void chargerDonnes() {
		DaoContratLocation dao;
		try {
			dao = new DaoContratLocation();
			JTable table = fenetre.getTable();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			for (Locataire loc : locataires) {
				ContratLocation cl = dao.findContratLocataionByLocataire(loc.getIdLocataire());
				Object[] ligne = { loc.getIdLocataire(), loc.getNom(), loc.getPrenom(), loc.getAdresse(), loc.getTel(),
						loc.getEmail(), cl.getDateDebut(), cl.getDateFin() };
				model.addRow(ligne);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		String dateNaissance = loc.getDateDeNaissance().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		fenetre.getTextFieldDateNaissance().setText(dateNaissance);
		fenetre.getTextFieldEmail().setText(loc.getEmail());
		fenetre.getTextFieldLieuNaissance().setText(loc.getLieuDeNaissance());
		fenetre.getTextFieldProfession().setText(loc.getProfession());
		fenetre.getTextFieldSalaire().setText(String.valueOf(loc.getSalaire()));
		fenetre.getTextFieldSituationFamiliale().setText(loc.getSituationFamiliale());
		fenetre.getTextFieldAdresse().setText(loc.getAdresse());
	}

	public void setLocataires(List<Locataire> locataires) {
		this.locataires = locataires;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
