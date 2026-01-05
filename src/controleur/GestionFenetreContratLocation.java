package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.ContratLocation;
import modele.IRL;
import modele.Locataire;
import modele.dao.DaoBienLouable;
import modele.dao.DaoContratLocation;
import modele.dao.DaoIRL;
import modele.dao.DaoLocataire;
import vue.*;

public class GestionFenetreContratLocation extends GestionHeaderEtFooter implements MouseListener {

	private FenetreContratLocation fenetre;
	private ContratLocation cl;
	private List<ContratLocation> contrats;

	private ContratLocation selected;

	public GestionFenetreContratLocation(FenetreContratLocation fenetre, ContratLocation cl) throws SQLException {
		super(fenetre);
		this.fenetre = fenetre;
		this.cl = cl;
		this.contrats = new ArrayList<>(this.getDonneesContrats());
	}

	public List<ContratLocation> getDonneesContrats() throws SQLException {
		DaoContratLocation dCl = new DaoContratLocation();
		return dCl.findByContrat(this.cl.getNumeroDeContrat());
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {
		case "Ajouter":
			FenetreAjouterContratLocation fACL = new FenetreAjouterContratLocation();
			fenetre.getLayeredPane().add(fACL).setVisible(true);
			break;
			
		case "Annuler":
			fenetre.dispose();
			break;
			
		case "Revaloriser loyer":
			Calendar cal = Calendar.getInstance();
			int annne1 = cal.get(Calendar.YEAR);
			int annee2 = annne1 - 1;

			int mois = cal.get(Calendar.MONTH) + 1;
			int trimester = (mois - 1) / 3 + 1;

			DaoIRL daoIRL = new DaoIRL();
			DaoContratLocation daoCL = new DaoContratLocation();

			IRL irlCourant = daoIRL.findById(String.valueOf(annne1), String.valueOf(trimester));
			IRL irlPrecedent = daoIRL.findById(String.valueOf(annee2), String.valueOf(trimester));

			if (irlCourant == null || irlPrecedent == null) {
				JOptionPane.showMessageDialog(null,
						"IRL non trouvée pour le trimestre correspondant. Ajouter IRL avant de revaloriser", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			double valCourant = irlCourant.getIRL();
			double valPrecedent = irlPrecedent.getIRL();
			double min = selected.getMontantMensuel();
			double max = min * (valCourant / valPrecedent);

			String input = JOptionPane.showInputDialog(null,
					String.format("Veuillez entrer le loyer entre %.2f et %.2f €", min, max), "Revalorisation du loyer",
					JOptionPane.QUESTION_MESSAGE);

			if (input != null && !input.trim().isEmpty()) {
				double loyerNouveau;
				try {
					loyerNouveau = Double.parseDouble(input);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Entrée invalide. Veuillez entrer un nombre.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					break;
				}
				if (loyerNouveau < min || loyerNouveau > max) {
					JOptionPane.showMessageDialog(null,
							String.format("Le loyer doit être compris entre %.2f et %.2f €", min, max), "Erreur",
							JOptionPane.ERROR_MESSAGE);
				} else {
					loyerNouveau = Math.round(loyerNouveau * 100.0) / 100.0;
					selected.setMontantMensuel(loyerNouveau);
					daoCL.update(selected);

					JOptionPane.showMessageDialog(null,
							String.format("Loyer mis à jour avec succès : %.2f €", loyerNouveau), "Succès",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			break;
			
		case "Revaloriser charge":
			if (selected == null) {
				JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un contrat", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			double chargeActuelle = selected.getProvisionCharge();
			String inputCharge = JOptionPane.showInputDialog(fenetre, String
					.format("Provision actuelle : %.2f €\nEntrez la nouvelle provision de charges :", chargeActuelle),
					"Revalorisation des charges", JOptionPane.QUESTION_MESSAGE);

			if (inputCharge == null || inputCharge.trim().isEmpty())
				break;

			double nouvelleCharge;
			try {
				nouvelleCharge = Double.parseDouble(inputCharge);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(fenetre, "Entrée invalide. Veuillez entrer un nombre.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			if (nouvelleCharge < 0) {
				JOptionPane.showMessageDialog(fenetre, "La provision de charges ne peut pas être négative.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

			selected.setProvisionCharge(nouvelleCharge);
			DaoContratLocation daoCLCharge = new DaoContratLocation();
			daoCLCharge.update(selected);
			fenetre.getTextFieldProvCharge().setText(String.valueOf(nouvelleCharge));
			JOptionPane.showMessageDialog(fenetre,
					String.format("Provision de charges mise à jour : %.2f €", nouvelleCharge), "Succès",
					JOptionPane.INFORMATION_MESSAGE);
			break;

		}
	}

	@Override
	protected void gererMenuSpecifique(String texte) {
	}

	@Override
	protected void gererBoutonRetour(String texte) throws SQLException {
		if ("Retour".equals(texte)) {
			if (fenetre.getFenDavant().equals("FenBienLouable")) {
				DaoBienLouable dBL = new DaoBienLouable();
				BienLouable bL = dBL.findByIdContrat(this.cl.getNumeroDeContrat());
				FenetreBienLouable fp = new FenetreBienLouable("FenPrincipale", bL);
				fp.setVisible(true);
				fenetre.dispose();
			}
			if (fenetre.getFenDavant().equals("FenPrincipale")) {
				FenetrePrincipale fp = new FenetrePrincipale();
				fp.setVisible(true);
				fenetre.dispose();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof JTable) {
			JTable table = (JTable) e.getSource();
			int row = table.getSelectedRow();
			if (row >= 0 && row < contrats.size()) {
				ContratLocation contratSelectionne = contrats.get(row);
				this.selected = contrats.get(row);
				afficherContrat(contratSelectionne);
				if (e.getClickCount() == 2) {
					fenetre.dispose();
					FenetreLocataire fen = new FenetreLocataire("FenContratLocation", null, null);
					fen.setVisible(true);
				}
			}
		}
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

	public void initialize() {
		try {
			remplirTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (!contrats.isEmpty()) {
			fenetre.getTable().setRowSelectionInterval(0, 0);
			selected = contrats.get(0);
			afficherContrat(selected);
		}
		fenetre.getTable().addMouseListener(this);
	}

	private void remplirTable() throws SQLException {
		DefaultTableModel model = (DefaultTableModel) this.fenetre.getTable().getModel();
		model.setRowCount(0);
		DaoLocataire dL = new DaoLocataire();
		for (ContratLocation c : contrats) {
			String nomLoc = dL.findLocataireByContrat(c.getNumeroDeContrat()).get(0).getNom();
			model.addRow(new Object[] { nomLoc, c.getNumeroDeContrat(), c.getDateFin(), c.getMontantMensuel(),
					c.getSolde() });
		}
		fenetre.getTable().addMouseListener(this);
	}

	private void afficherContrat(ContratLocation c) {
		fenetre.getTextFieldNdC().setText(c.getNumeroDeContrat());
		fenetre.getTextFieldPeriode().setText(c.getDateDebut() + " → " + c.getDateFin());
		fenetre.getTextFieldMontantC().setText(String.valueOf(c.getMontantDeCaution()));
		fenetre.getTextFieldProvCharge().setText(String.valueOf(c.getProvisionCharge()));
		fenetre.getTextFieldLoyerMen().setText(String.valueOf(c.getMontantMensuel()));
		fenetre.getTextFieldCptEau().setText(String.valueOf(c.getIndexCompteurEau()));
		fenetre.getTextFieldCptElec().setText(String.valueOf(c.getIndexCompteurElectricite()));
		fenetre.getTextFieldCptGaz().setText(String.valueOf(c.getIndexCompteurGaz()));
		fenetre.getTextFieldSolde().setText(String.valueOf(c.getSolde()));

		try {
			DaoLocataire dL = new DaoLocataire();
			List<Locataire> locataires = dL.findLocataireByContrat(c.getNumeroDeContrat());
			if (!locataires.isEmpty()) {
				fenetre.getTextFieldNomLoc().setText(locataires.get(0).getNom());
			} else {
				fenetre.getTextFieldNomLoc().setText("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fenetre.getTextFieldNomLoc().setText("");
		}
	}

}
