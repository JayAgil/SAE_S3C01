package controleur;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.BienLouable;
import modele.ContratLocation;
import modele.dao.DaoBatiment;
import modele.dao.DaoContratLocation;
import vue.FenetreAjouterContratLocation;

public class GestionFenetreAjouterContratLocation extends GestionButtonFenetreAjouter {

	private FenetreAjouterContratLocation fenetre;
	private BienLouable bl;
	private GestionFenetreContratLocation parent;

	public GestionFenetreAjouterContratLocation(FenetreAjouterContratLocation fenetre, BienLouable bl,
			GestionFenetreContratLocation parent) {
		this.fenetre = fenetre;
		this.bl = bl;
		this.parent = parent;
	}

	@Override
	protected List<JTextField> getTextFields() {
		return fenetre.getAllContratTextFields();
	}

	@Override
	protected JInternalFrame getFrame() {
		return fenetre;
	}

	@Override
	protected void gererAction() {
		try {
			DaoContratLocation dao = new DaoContratLocation();
			DaoBatiment daoBat = new DaoBatiment();
			List<JTextField> donnees = this.getTextFields();

			ContratLocation cl = new ContratLocation(donnees.get(0).getText(), // String numeroDeContrat
					Date.valueOf(donnees.get(1).getText()), // Date dateDebut
					Date.valueOf(donnees.get(2).getText()), // Date dateFin
					Double.parseDouble(donnees.get(3).getText()), // double montantDeCaution
					Double.parseDouble(donnees.get(4).getText()), // double provisionCharge
					Double.parseDouble(donnees.get(5).getText()), // double solde
					Double.parseDouble(donnees.get(6).getText()), // double montantMensuel
					Date.valueOf(donnees.get(7).getText()), // Date dateVersement
					Double.parseDouble(donnees.get(8).getText()), // double indexCompteurEau
					Double.parseDouble(donnees.get(9).getText()), // double indexCompteurElectricite
					Double.parseDouble(donnees.get(10).getText()), // double indexCompteurGaz
					bl // BienLouable
			);

			if (dao.create(cl) == 1) {
				JOptionPane.showMessageDialog(null, "Contrat location ajoutée avec succès !", "Succès",
						JOptionPane.INFORMATION_MESSAGE);

				this.parent.setContrats(dao.findByBatiment(daoBat.findBatimentByBien(bl.getIdBienLouable()).getAdresse()));
				this.parent.remplirTable();;
				this.fenetre.dispose();

			} else {
				JOptionPane.showMessageDialog(null, "Échec de l'ajout du contrat location.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 1) {
				JOptionPane.showMessageDialog(null, "Ce contrat existe déjà (clé primaire).", "Doublon",
						JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur base de données",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}