package controleur;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.Diagnostics;
import modele.dao.DaoDiagnostics;
import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter {

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

	private boolean isExpiringThisMonth(java.util.Date date) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int monthNow = cal.get(java.util.Calendar.MONTH);
		int yearNow = cal.get(java.util.Calendar.YEAR);

		cal.setTime(date);
		int monthDiag = cal.get(java.util.Calendar.MONTH);
		int yearDiag = cal.get(java.util.Calendar.YEAR);

		return monthNow == monthDiag && yearNow == yearDiag;
	}
}
