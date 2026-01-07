package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.Diagnostics;
import modele.dao.DaoDiagnostics;
import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter implements MouseListener {

	private FenetreDiagnostic fenetre;
	private BienLouable bL;

	public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
		super(fenetre);
		this.fenetre = fenetre;
		this.bL = fenetre.getBien();
		this.fenetre.getTable().addMouseListener(this);
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {
		case "Ajouter":
			FenetreAjouterDiagnostic fenAjouterDiagnostic = new FenetreAjouterDiagnostic(bL, this);
			fenAjouterDiagnostic.setVisible(true);
			break;
		case "Retour":
			FenetreBienLouable fenBienLouable = new FenetreBienLouable("FenPrincipale", this.bL);
			fenBienLouable.setVisible(true);
			fenetre.dispose();
			break;
		}
	}

	protected void gererMenuSpecifique(String texte) {
	}

	public void chargerDonnees() throws SQLException {
		if (bL == null)
			return;

		DaoDiagnostics daoDiag = new DaoDiagnostics();
		try {
			List<Diagnostics> diagnostics = daoDiag.findDiagnosticsByIdBien(bL.getIdBienLouable());
			DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
			model.setRowCount(0);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			for (Diagnostics d : diagnostics) {
				model.addRow(new Object[] { d.getTypeDiagnostics(),
						d.getDateRealisation() != null ? sdf.format(d.getDateRealisation()) : "",
						d.getDateValidite() != null ? sdf.format(d.getDateValidite()) : "", d.getFichier(),
						d.getBienLouable() != null ? d.getBienLouable().getIdBienLouable() : "" });
			}

			int nbValides = (int) diagnostics.stream()
					.filter(d -> d.getDateValidite() != null && d.getDateValidite().after(new java.util.Date()))
					.count();

			int nbExpirant = (int) diagnostics.stream()
					.filter(d -> d.getDateValidite() != null && isExpiringThisMonth(d.getDateValidite())).count();

			fenetre.getLblnbDiag().setText(String.valueOf(nbValides));
			fenetre.getLblnbDiagExp().setText(String.valueOf(nbExpirant));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void ouvrirPDF() {
		int selectedRow = fenetre.getTable().getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un diagnostic.", "Aucune sélection",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String path = (String) fenetre.getTable().getValueAt(selectedRow, 3);
		if (path == null || path.isEmpty()) {
			JOptionPane.showMessageDialog(fenetre, "Aucun fichier associé à ce diagnostic.", "Fichier manquant",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			File file = new File(System.getProperty("user.dir"), path);
			if (!file.exists()) {
				JOptionPane.showMessageDialog(fenetre, "Le fichier PDF est introuvable :\n" + file.getAbsolutePath(),
						"Fichier introuvable", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (java.awt.Desktop.isDesktopSupported()) {
				java.awt.Desktop.getDesktop().open(file);
			} else {
				JOptionPane.showMessageDialog(fenetre, "Votre système ne permet pas l'ouverture automatique des PDF.",
						"Fonction non supportée", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(fenetre, "Impossible d'ouvrir le PDF : " + e.getMessage(),
					"Erreur", javax.swing.JOptionPane.ERROR_MESSAGE);
		}

	}

	private boolean isExpiringThisMonth(java.util.Date date) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int monthNow = cal.get(java.util.Calendar.MONTH);
		int yearNow = cal.get(java.util.Calendar.YEAR);

		cal.setTime(date);
		int monthDiag = cal.get(java.util.Calendar.MONTH);
		int yearDiag = cal.get(java.util.Calendar.YEAR);

		return monthNow == monthDiag && yearNow == yearDiag;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 1) {
			ouvrirPDF();
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
}
