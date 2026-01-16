package controleur;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modele.Assurance;
import modele.Batiment;
import modele.dao.DaoAssurance;
import modele.dao.DaoBatiment;
import modele.dao.DaoBienLouable;
import vue.FenetreAjouterAssurance;
import vue.FenetreAssurance;
import vue.FenetrePrincipale;

/**
 * Contrôleur de la fenêtre d'affichage et de gestion des assurances. Permet
 * d'ajouter, modifier, supprimer et afficher l'assurance d'un bâtiment.
 */
public class GestionFenetreAssurance extends GestionHeaderEtFooter {

	private FenetreAssurance fenetre;
	private String bat;

	/**
	 * Constructeur du contrôleur Assurance.
	 *
	 * @param fenetre fenêtre d'assurance associée
	 */
	public GestionFenetreAssurance(FenetreAssurance fenetre) {
		super(fenetre);
		this.fenetre = fenetre;
		this.bat = this.fenetre.getBat();
		hideBtnAjouter();
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
		case "Ajouter assurance":
			ouvrirFenetreAjouterAssurance();
			break;
		case "Retirer":
			DaoAssurance dAss = new DaoAssurance();
			Assurance ass = dAss.findById((this.fenetre.getTextFieldNumAssurance().getText()));
			dAss.delete(ass);
			this.gererBoutonRetour("Retour");
			break;
		case "Modifier":
			DaoAssurance dA = new DaoAssurance();
			Assurance a = dA.findById(this.fenetre.getTextFieldNumAssurance().getText());
			a.setAdresseAgence(this.fenetre.getTextFieldAdresseAgence().getText());
			a.setAgence(this.fenetre.getTextFieldAgence().getText());
			a.setTelAgence(this.fenetre.getTextFieldTelAgence().getText());
			a.setPrime(Double.parseDouble(this.fenetre.getTxtFieldPrime().getText()));
			a.setMontant(Double.parseDouble(this.fenetre.getTxtFieldMontant().getText()));
			a.setTypeAssurance(this.fenetre.getTxtFieldType().getText());
			dA.update(a);
			chargerAssuranceBatiment(this.bat);
			JOptionPane.showMessageDialog(null, "Modification succès", "Information", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	/**
	 * Gère le bouton retour vers la fenêtre principale.
	 *
	 * @param texte texte du bouton cliqué
	 */
	@Override
	protected void gererBoutonRetour(String texte) {
		if ("Retour".equals(texte)) {
			FenetrePrincipale fp = new FenetrePrincipale();
			fp.setVisible(true);
			fenetre.dispose();
		}
	}

	/**
	 * Charge l'assurance associée à un bâtiment.
	 *
	 * @param batiment adresse du bâtiment
	 * @throws SQLException en cas d'erreur SQL
	 */
	public void chargerAssuranceBatiment(String batiment) throws SQLException {
		DaoAssurance daoAssurance = new DaoAssurance();
		DaoBienLouable dB = new DaoBienLouable();
		Assurance assurance = daoAssurance.findByBatiment(batiment);
		int nbBiens = dB.findByIdBat(batiment).size();
		if (assurance == null) {
			afficherAucuneAssurance(nbBiens);
		} else {
			afficherAssuranceBatiment(assurance, nbBiens);
		}
	}

	/**
	 * Affiche les informations d'assurance d'un bâtiment.
	 *
	 * @param assurance assurance du bâtiment
	 * @param nbBiens   nombre de biens louables
	 */
	public void afficherAssuranceBatiment(Assurance assurance, int nbBiens) {
		this.fenetre.getTextFieldNumAssurance().setText(assurance.getNumeroAssurance());
		this.fenetre.getTxtFieldPrime().setText(String.valueOf(assurance.getPrime()));
		this.fenetre.getTxtFieldType().setText(assurance.getTypeAssurance());
		this.fenetre.getTextFieldAgence().setText(assurance.getAgence());
		this.fenetre.getTextFieldTelAgence().setText(assurance.getAdresseAgence());
		this.fenetre.getTextFieldTelAgence().setText(assurance.getTelAgence());
		this.fenetre.getLblNbBien().setText(String.valueOf(nbBiens));
		this.fenetre.getTxtFieldMontant().setText(String.valueOf(assurance.getMontant()));
		this.fenetre.getTextFieldAdresseAgence().setText(assurance.getAdresseAgence());
	}

	/**
	 * Affiche l'absence d'assurance pour un bâtiment.
	 *
	 * @param nbBiens nombre de biens louables
	 */
	public void afficherAucuneAssurance(int nbBiens) {
		fenetre.getTextFieldNumAssurance().setText("");
		fenetre.getTxtFieldPrime().setText("");
		fenetre.getTxtFieldType().setText("");
		fenetre.getTextFieldAgence().setText("");
		fenetre.getTextFieldTelAgence().setText("");
		fenetre.getTextFieldAdresseAgence().setText("");
		fenetre.getTxtFieldMontant().setText("");

		fenetre.getLblNbBien().setText(String.valueOf(nbBiens));

		JOptionPane.showMessageDialog(fenetre, "Ce bâtiment n'a pas encore d'assurance.\nVeuillez en ajouter une.",
				"Aucune assurance", JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Ouvre la fenêtre d'ajout d'une assurance.
	 */
	private void ouvrirFenetreAjouterAssurance() {
		try {
			DaoBatiment dao = new DaoBatiment();
			Batiment b = dao.findById(this.bat);
			FenetreAjouterAssurance fenAjouterAssurance = new FenetreAjouterAssurance(b, this);
			fenetre.getLayeredPane().add(fenAjouterAssurance);
			fenAjouterAssurance.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cache le bouton "Ajouter" si une assurance existe déjà.
	 */
	@SuppressWarnings("deprecation")
	public void hideBtnAjouter() {
		DaoBatiment daoBat;
		try {
			daoBat = new DaoBatiment();
			Batiment b = daoBat.findById(bat);
			DaoAssurance dao = new DaoAssurance();
			if (dao.findByBatiment(b.getAdresse()) != null) {
				this.fenetre.getBtnAjouter().hide();
				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
