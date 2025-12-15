package controleur;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Locataire;
import vue.*;

public class GestionFenetreLocataire extends GestionHeaderEtFooter {

	private FenetreLocataire fenetre;
	private List<Locataire> locataires;

	public GestionFenetreLocataire(FenetreLocataire fenetre, List<Locataire> locataires) {
		super(fenetre);
		this.fenetre = fenetre;
		this.locataires = locataires;
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
			new FenetrePaiement(locataires).setVisible(true);
			fenetre.dispose();
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
		for (Locataire loc : fenetre.getListe()) {
			Object[] ligne = { loc.getIdLocataire(), loc.getNom(), loc.getPrenom(), loc.getTel(), loc.getAdresse() };
			model.addRow(ligne);
		}

	}

}
