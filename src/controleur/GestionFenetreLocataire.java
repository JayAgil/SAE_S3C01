package controleur;

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
import modele.dao.DaoGarant;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.*;

/**
 * Contrôleur de la fenêtre d'affichage et de gestion des locataires.
 * Permet de gérer l'affichage, l'ajout, la suppression et les paiements des locataires.
 * Gère également la sélection et l'affichage des informations détaillées d'un locataire.
 */
public class GestionFenetreLocataire extends GestionHeaderEtFooter {

	/** Fenêtre graphique associée aux locataires */
    private FenetreLocataire fenetre;

    /** Liste des locataires affichés dans la fenêtre */
    private List<Locataire> locataires;

    /** Locataire actuellement sélectionné */
    private Locataire locataireSelectionne;

    /**
     * Constructeur du contrôleur.
     *
     * @param fenetre   FenetreLocataire à gérer
     * @param locataires Liste des locataires à afficher (peut être null)
     */
	@SuppressWarnings("deprecation")
	public GestionFenetreLocataire(FenetreLocataire fenetre, List<Locataire> locataires) {
		super(fenetre);
		this.fenetre = fenetre;
		this.locataires = locataires;
		
        // Charger les locataires dans la table
		chargerDonnes();
        // Afficher les champs de texte pour les détails
		afficherTextFields();

        // Si des locataires existent, sélectionner le premier
		if (locataires != null && !locataires.isEmpty()) {
			locataireSelectionne = locataires.get(0);
			fenetre.getTable().setRowSelectionInterval(0, 0);
			afficherDetails(locataireSelectionne);
		}
		
        // Masquer le bouton d'ajout si la fenêtre précédente est la fenêtre principale
		if (this.fenetre.getNomFenAvant() == "FenPrincipale") {
			this.fenetre.getBtnAjouterLocataire().hide();
		}
	}

	/**
     * Gère les actions spécifiques des boutons.
     * 
     * @param texte texte du bouton cliqué
     * @throws SQLException en cas d'erreur SQL
     */
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
						DaoContratLocation daoContrat = new DaoContratLocation();
						ContratLocation contrat = daoContrat
								.findContratLocataionByLocataire(locataireSelectionne.getIdLocataire());
						double solde = contrat.getSolde();

						// On ne retire pas de locataire si le contrat possede un solde nul
						// afin de pouvoir d'abord régler son solde
						if (solde != 0.0) {
							JOptionPane.showMessageDialog(fenetre,
									"Impossible de supprimer ce locataire : un contrat possède un solde non nul ("
											+ solde + ").");
							break;
						}

						DaoLocataire dao = new DaoLocataire();
						DaoGarant dG = new DaoGarant();

						dG.delete(dG.findByLoc(locataireSelectionne.getIdLocataire()));
						dao.delete(locataireSelectionne);

						locataires.remove(locataireSelectionne);
						chargerDonnes();
						locataireSelectionne = null;
					} catch (SQLException ex) {
						if (ex.getErrorCode() == -20012) {
							JOptionPane.showMessageDialog(fenetre,
									"Impossible de supprimer ce locataire : un contrat associé possède un solde non nul.");

						} else {
							JOptionPane.showMessageDialog(fenetre, "Erreur lors de la suppression du locataire !");
						}

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

	/**
     * Gère les actions spécifiques des boutons.
     * 
     * @param texte texte du bouton cliqué
     * @throws SQLException en cas d'erreur SQL
     */
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

	/**
     * Charge les données des locataires dans la table.
     */
	public void chargerDonnes() {
		try {
			DaoLocataire daoLoc = new DaoLocataire();
			if (this.fenetre.getNomFenAvant().equals("FenPrincipale")) {
				this.locataires = daoLoc.findAll();
			} else {
				List<Locataire> locs = daoLoc.findLocataireByBienLouable(fenetre.getBl().getIdBienLouable());
				this.locataires = locs;
			}

			JTable table = fenetre.getTable();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			DaoContratLocation daoCL = new DaoContratLocation();

			for (Locataire loc : this.locataires) {
				ContratLocation cl = daoCL.findContratLocataionByLocataire(loc.getIdLocataire());

				model.addRow(new Object[] { loc.getIdLocataire(), loc.getNom(), loc.getPrenom(), loc.getAdresse(),
						loc.getTel(), loc.getEmail(), cl != null ? cl.getDateDebut() : null,
						cl != null ? cl.getDateFin() : null });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	 /**
     * Configure les champs de texte pour afficher les détails du locataire sélectionné.
     */
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

	/**
     * Affiche les détails du locataire sélectionné dans les champs de texte.
     * 
     * @param loc locataire à afficher
     */
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

	 /**
     * Définit la liste des locataires.
     * 
     * @param locataires nouvelle liste de locataires
     */
	public void setLocataires(List<Locataire> locataires) {
		this.locataires = locataires;
	}


}
