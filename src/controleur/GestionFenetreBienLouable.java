package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Batiment;
import modele.BienLouable;
import modele.ChargesGenerales;
import modele.Compteur;
import modele.ContratLocation;
import modele.Facture;
import modele.Locataire;
import modele.Paiement;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienLouable;
import modele.dao.DaoChargesGenerales;
import modele.dao.DaoCompteur;
import modele.dao.DaoContratLocation;
import modele.dao.DaoFacture;
import modele.dao.DaoLocataire;
import modele.dao.DaoPaiement;
import vue.FenetreAjouterBienLouable;
import vue.FenetreBienLouable;
import vue.FenetreCharges;
import vue.FenetreCompteurs;
import vue.FenetreContratLocation;
import vue.FenetreDiagnostic;
import vue.FenetreLocataire;
import vue.FenetrePrincipale;
import vue.FenetreTravaux;

/**
 * Contrôleur de la fenêtre de gestion des biens louables. Cette classe permet :
 * <li>d'afficher les biens louables d’un bâtiment</li>
 * <li>de sélectionner un bien et afficher ses informations détaillées</li>
 * <li>de gérer les contrats, charges, travaux, compteurs et locataires</li>
 * <li>d'assurer la navigation entre les différentes fenêtres associées</li>
 */
public class GestionFenetreBienLouable extends GestionHeaderEtFooter {

	private FenetreBienLouable fenetrebienlouable;
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
		this.fenetrebienlouable = fenetre;
		this.bien = bien;

		fenetrebienlouable.getTable().addMouseListener(new MouseAdapter() {

			/**
			 * Gère la sélection d’un bien dans le tableau. Un double-clic ouvre la fenêtre
			 * des locataires, un simple clic affiche les informations du bien.
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table = (JTable) e.getSource();
				int row = table.rowAtPoint(e.getPoint());
				if (row == -1)
					return;

				int modelRow = table.convertRowIndexToModel(row);
				idBien = table.getModel().getValueAt(modelRow, 0).toString();

				if (e.getClickCount() == 2) {
					ouvrirFenetreLocataire(idBien);
				} else {
					chargerBienEtRemplirFormulaire(idBien);
				}
			}
		});
	}

	/**
	 * Retourne la liste des biens louables du bâtiment courant.
	 *
	 * @return liste des biens louables
	 */
	public List<BienLouable> getListBienWithTheBienNow() {
		if (bien == null || bien.getBatiment() == null) {
			return Collections.emptyList();
		}

		try {
			DaoBienLouable daoBL = new DaoBienLouable();
			String idBatiment = bien.getBatiment().getAdresse();
			return daoBL.findByBatiment(idBatiment);
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	/**
	 * Récupère le contrat de location associé à un bien.
	 *
	 * @return contrat de location
	 * @throws SQLException en cas d'erreur SQL
	 */
	public ContratLocation getDonneesContratByBien() throws SQLException {
		DaoContratLocation dCL = new DaoContratLocation();
		String idBien = this.fenetrebienlouable.getChosenBien();
		return dCL.findCLByBien(idBien);
	}

	/**
	 * Récupère les charges générales d’un bien.
	 *
	 * @return liste des charges générales
	 * @throws SQLException en cas d'erreur SQL
	 */
	public List<ChargesGenerales> getDonneesChargesGeneraleByBien() throws SQLException {
		DaoChargesGenerales dao = new DaoChargesGenerales();
		return dao.findByIdBien(bien.getIdBienLouable());
	}

	/**
	 * Récupère les compteurs associés à un bien.
	 *
	 * @return liste des compteurs
	 * @throws SQLException en cas d'erreur SQL
	 */
	public List<Compteur> getDonneesCompteur() throws SQLException {
		DaoCompteur dao = new DaoCompteur();
		String idBien = this.fenetrebienlouable.getChosenBien();
		return dao.findByIdBien(idBien);
	}

	/**
	 * Récupère les travaux (factures) d’un bien.
	 *
	 * @return liste des factures
	 * @throws SQLException en cas d'erreur SQL
	 */
	public List<Facture> getDonneesTravauxByBien() throws SQLException {
		DaoFacture dao = new DaoFacture();
		return dao.findFactureByBienLouable(this.bien.getIdBienLouable());

	}

	/**
	 * Retourne le bien actuellement sélectionné.
	 *
	 * @return bien louable
	 */
	public BienLouable getBien() {
		return bien;
	}

	/**
	 * Gère les actions spécifiques des boutons de la fenêtre.
	 *
	 * @param texte texte du bouton cliqué
	 * @throws SQLException en cas d'erreur SQL
	 */
	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {

		case "Diagnostics":
			DaoBienLouable dBL = new DaoBienLouable();
			BienLouable bL = dBL.findById(this.fenetrebienlouable.getChosenBien());
			new FenetreDiagnostic(bL).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Contrat":
			DaoContratLocation dCl = new DaoContratLocation();
			DaoBienLouable daob = new DaoBienLouable();
			this.bien = daob.findById(this.idBien);
			if (this.bien == null) {
				JOptionPane.showMessageDialog(fenetre,
						String.format("Veuillez selectionner un bien louable avant d'ouvrir le contrat"), "Information",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				ContratLocation cl = dCl.findCLByBien(this.idBien);
				new FenetreContratLocation("FenBienLouable", cl, this.bien).setVisible(true);
				fenetrebienlouable.dispose();
			}
			break;

		case "Charges":
			new FenetreCharges("FenetreBienLouable", getDonneesChargesGeneraleByBien(), bien).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Travaux":
			new FenetreTravaux("FenetreBienLouable", getDonneesTravauxByBien(), bien).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		case "Ajouter":
			DaoBatiment dao = new DaoBatiment();
			Batiment b = dao.findBatimentByBien(bien.getIdBienLouable());
			FenetreAjouterBienLouable ajout = new FenetreAjouterBienLouable(b, this);
			fenetre.getLayeredPane().add(ajout);
			ajout.setVisible(true);
			break;

		case "Retirer":
			JTable table = this.fenetrebienlouable.getTable();
			int idx = table.getSelectedRow();
			if (idx != -1) {
				BienLouable bien = this.getListBienWithTheBienNow().get(idx);
				try {
					DaoBienLouable dB = new DaoBienLouable();
					dB.delete(bien);
					this.chargerDonnees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
			bien = this.getListBienWithTheBienNow().get(0);
			idBien = this.getListBienWithTheBienNow().get(0).getIdBienLouable();
			this.chargerBienEtRemplirFormulaire(idBien);
			JOptionPane.showMessageDialog(fenetre, String.format("Bien Louable retiré avec succès"), "Succès",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case "Locataire":
			if (idBien == null || idBien == "") {
				JOptionPane.showMessageDialog(null,
						"Attention! Choisissez un bien avant d'aller à la fenêtre locaraire!", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
			ouvrirFenetreLocataire(idBien);
			break;
		case "Compteur":
			new FenetreCompteurs("FenetreBienLouable", getDonneesCompteur(), bien).setVisible(true);
			fenetrebienlouable.dispose();
			break;

		}
	}

	/**
	 * Charge les données d’un bien et met à jour le formulaire.
	 *
	 * @param idBien identifiant du bien
	 */
	public void chargerBienEtRemplirFormulaire(String idBien) {
		try {
			DaoBienLouable daoBien = new DaoBienLouable();
			BienLouable bienSelectionne = daoBien.findById(idBien);

			if (bienSelectionne == null) {
				return;
			}
			DaoContratLocation daoCL = new DaoContratLocation();
			ContratLocation contrat = daoCL.findCLByBien(idBien);

			List<Locataire> locataires = Collections.emptyList();
			Paiement dernierPaiement = null;

			if (contrat != null) {
				DaoLocataire daoLoc = new DaoLocataire();
				locataires = daoLoc.findLocataireByContrat(contrat.getNumeroDeContrat());

				DaoPaiement daoPaiement = new DaoPaiement();
				dernierPaiement = daoPaiement.findDateDernierPaiementByCL(contrat.getNumeroDeContrat());
			}

			DaoChargesGenerales daoCharge = new DaoChargesGenerales();
			List<ChargesGenerales> charges = daoCharge.findByIdBien(idBien);

			double totalCharge = 0.0;
			if (charges != null && !charges.isEmpty()) {
				totalCharge = charges.stream().mapToDouble(ChargesGenerales::getMontant).sum();
			}

			DaoFacture daoFacture = new DaoFacture();
			Facture facture = daoFacture.findDateDernierTravauxByBien(idBien);

			this.bien = bienSelectionne;

			remplirFormulaire(bienSelectionne, contrat, totalCharge, locataires, facture, dernierPaiement);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ouvre la fenêtre des locataires d’un bien.
	 *
	 * @param idBien identifiant du bien
	 */
	private void ouvrirFenetreLocataire(String idBien) {
		try {
			DaoLocataire daoLocataire = new DaoLocataire();
			List<Locataire> locataires = daoLocataire.findLocataireByBienLouable(idBien);
			if (locataires == null) {
				JOptionPane.showMessageDialog(null, "Ce bien n'a pas de locataire", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				DaoBienLouable db = new DaoBienLouable();
				BienLouable bien = db.findById(idBien);
				FenetreLocataire fen = new FenetreLocataire("FenetreBienLouable", locataires, bien);
				fen.setVisible(true);
				fenetre.dispose();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Charge les biens louables dans le tableau.
	 *
	 * @throws SQLException en cas d'erreur SQL
	 */
	public void chargerDonnees() throws SQLException {

		List<BienLouable> liste = getListBienWithTheBienNow();
		DefaultTableModel model = (DefaultTableModel) fenetrebienlouable.getTable().getModel();

		model.setRowCount(0);

		for (BienLouable b : liste) {
			model.addRow(
					new Object[] { b.getIdBienLouable(), b.getAdresse(), b.getNbPieces(), b.getTypeBienLouable() });
		}
		boolean hasBien = !liste.isEmpty();

		fenetrebienlouable.getBtnContrat().setEnabled(hasBien);
		fenetrebienlouable.getBtnCharge().setEnabled(hasBien);
		fenetrebienlouable.getBtnTravaux().setEnabled(hasBien);
		fenetrebienlouable.getBtnCompteur().setEnabled(hasBien);

	}

	/**
	 * Remplit le formulaire avec les données du bien sélectionné.
	 *
	 * @param bien   bien louable
	 * @param cl     contrat de location
	 * @param charge montant total des charges
	 * @param loc    liste des locataires
	 * @param fac    dernière facture
	 * @param date   dernier paiement
	 */
	public void remplirFormulaire(BienLouable bien, ContratLocation cl, double charge, List<Locataire> loc, Facture fac,
			Paiement date) {

		if (loc != null && !loc.isEmpty()) {
			fenetrebienlouable.getTextFieldNom().setText(loc.get(0).getNom());
		} else {
			fenetrebienlouable.getTextFieldNom().setText("Aucun locataire");
		}

		if (cl != null) {
			fenetrebienlouable.getTextFieldLoyerMen().setText(String.format("%.2f €", cl.getMontantMensuel()));
		} else {
			fenetrebienlouable.getTextFieldLoyerMen().setText("Pas de contrat");
		}

		if (bien != null) {
			fenetrebienlouable.getTextFieldNF().setText(bien.getNumeroFiscale());

			fenetrebienlouable.getTextFieldAdresse().setText(bien.getAdresse());

			fenetrebienlouable.getTextFieldSurfaceHab().setText(String.valueOf(bien.getSurfaceHabituable()));

			fenetrebienlouable.getTextFieldNbDPieces().setText(String.valueOf(bien.getNbPieces()));

			fenetrebienlouable.getTextFieldBienLoauble().setText(bien.getTypeBienLouable());

			if (bien.getBatiment() != null) {
				fenetrebienlouable.getTextFieldBatiment().setText(bien.getBatiment().getAdresse());
			} else {
				fenetrebienlouable.getTextFieldBatiment().setText("Aucun bâtiment");
			}
		} else {
			fenetrebienlouable.getTextFieldNF().setText("—");
			fenetrebienlouable.getTextFieldAdresse().setText("—");
			fenetrebienlouable.getTextFieldSurfaceHab().setText("—");
			fenetrebienlouable.getTextFieldNbDPieces().setText("—");
			fenetrebienlouable.getTextFieldBienLoauble().setText("—");
			fenetrebienlouable.getTextFieldBatiment().setText("—");
		}

		if (cl != null && cl.getDateFin() != null) {
			fenetrebienlouable.getTextFieldDFC().setText(cl.getDateFin().toString());
		} else {
			fenetrebienlouable.getTextFieldDFC().setText("Pas de contrat actif");
		}

		if (fac != null && fac.getDateDeFacture() != null) {
			fenetrebienlouable.getTextFieldDT().setText(fac.getDateDeFacture().toString());
		} else {
			fenetrebienlouable.getTextFieldDT().setText("Aucun travaux enregistré");
		}

		if (charge > 0) {
			fenetrebienlouable.getTextFieldTotalCharges().setText(String.format("%.2f €", charge));
		} else {
			fenetrebienlouable.getTextFieldTotalCharges().setText("Aucune charge");
		}

		if (date != null && date.getDatepaiement() != null) {
			fenetrebienlouable.getTextFieldDP().setText(date.getDatepaiement().toString());
		} else {
			fenetrebienlouable.getTextFieldDP().setText("Aucun paiement enregistré");
		}
	}

	/**
	 * Gère le retour vers la fenêtre principale.
	 *
	 * @param texte texte du bouton cliqué
	 */
	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			fenetre.dispose();
			new FenetrePrincipale().setVisible(true);
		}
	}
}
