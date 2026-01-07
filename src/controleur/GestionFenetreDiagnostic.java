package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.Diagnostics;
import modele.dao.DaoDiagnostics;
import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter  implements MouseListener{

	private FenetreDiagnostic fenetre;
	private BienLouable bL;

	public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
		super(fenetre);
		this.fenetre = fenetre;
		this.bL = fenetre.getBien();
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
	
	private void openSelectedPDF() {
		int selectedRow = fenetre.getTable().getSelectedRow();
		if (selectedRow == -1)
			return; // nothing selected

		String path = (String) fenetre.getTable().getValueAt(selectedRow, 3); // column 3 = Fichier
		if (path == null || path.isEmpty()) {
			System.out.println("No PDF path set for this diagnostic.");
			return;
		}

		try {
			// Construct file path relative to project
			File file = new File(System.getProperty("user.dir"), path);
			if (!file.exists()) {
				System.out.println("File does not exist: " + file.getAbsolutePath());
				return;
			}

			// Open the PDF
			if (java.awt.Desktop.isDesktopSupported()) {
				java.awt.Desktop.getDesktop().open(file);
			} else {
				System.out.println("Desktop not supported. Cannot open PDF.");
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
		if (e.getClickCount() == 2) {
			openSelectedPDF();
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
