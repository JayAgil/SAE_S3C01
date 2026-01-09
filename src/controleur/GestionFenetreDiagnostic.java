package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import modele.BienLouable;
import modele.Diagnostics;
import modele.dao.DaoDiagnostics;
import vue.*;

public class GestionFenetreDiagnostic extends GestionHeaderEtFooter {

	private FenetreDiagnostic fenetre;
	private BienLouable bL;
	private List<Diagnostics> diagnostics;

	public GestionFenetreDiagnostic(FenetreDiagnostic fenetre) {
		super(fenetre);
		this.fenetre = fenetre;
		this.bL = fenetre.getBien();
		DaoDiagnostics daoDiag;
		try {
			daoDiag = new DaoDiagnostics();
			diagnostics = daoDiag.findDiagnosticsByIdBien(bL.getIdBienLouable());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.initialize();
	}

	@Override
	protected void gererBoutonSpecifique(String texte) throws SQLException {
		switch (texte) {
		case "Ajouter":
			FenetreAjouterDiagnostic fenAjouterDiagnostic = new FenetreAjouterDiagnostic(bL, this);
			this.fenetre.getLayeredPane().add(fenAjouterDiagnostic);
			fenAjouterDiagnostic.setVisible(true);
			break;
		case "Retour":
			FenetreBienLouable fenBienLouable = new FenetreBienLouable("FenPrincipale", this.bL);
			fenBienLouable.setVisible(true);
			fenetre.dispose();
			break;
		case "Mettre à jour":
			JTable table = fenetre.getTable();
			int row = table.getSelectedRow();
			if (row != -1) {
				String idDiagnostics = fenetre.getTable().getValueAt(row, 0).toString();
				String typeDiagnostics = fenetre.getTable().getValueAt(row, 1).toString();

				Date dateRealisation = Date.valueOf(fenetre.getTable().getValueAt(row, 2).toString());
				Date dateValidite = Date.valueOf(fenetre.getTable().getValueAt(row, 3).toString());

				String fichier = fenetre.getTable().getValueAt(row, 4).toString();

				Diagnostics d = new Diagnostics(idDiagnostics, typeDiagnostics, dateRealisation, dateValidite, fichier,
						bL);
				DaoDiagnostics dao = new DaoDiagnostics();
				dao.update(d);

				diagnostics = dao.findDiagnosticsByIdBien(bL.getIdBienLouable());

				chargerDonnees();
			}
		case "Retirer":
			int ligne = fenetre.getTable().getSelectedRow();
			if (ligne != -1) {
				String idDiagnostics = fenetre.getTable().getValueAt(ligne, 0).toString();
				String typeDiagnostics = fenetre.getTable().getValueAt(ligne, 1).toString();

				Date dateRealisation = Date.valueOf(fenetre.getTable().getValueAt(ligne, 2).toString());
				Date dateValidite = Date.valueOf(fenetre.getTable().getValueAt(ligne, 3).toString());

				String fichier = fenetre.getTable().getValueAt(ligne, 4).toString();

				Diagnostics diagnostic = new Diagnostics(idDiagnostics, typeDiagnostics, dateRealisation, dateValidite,
						fichier, bL);
				DaoDiagnostics dao = new DaoDiagnostics();
				dao.delete(diagnostic);

				diagnostics = dao.findDiagnosticsByIdBien(bL.getIdBienLouable());

				chargerDonnees();
			}

		}

	}

	public void chargerDonnees() throws SQLException {
		if (bL == null)
			return;

		DefaultTableModel model = (DefaultTableModel) fenetre.getTable().getModel();
		model.setRowCount(0);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (Diagnostics d : diagnostics) {
			model.addRow(new Object[] { d.getIdDiagnostics(), d.getTypeDiagnostics(),
					d.getDateRealisation() != null ? sdf.format(d.getDateRealisation()) : "",
					d.getDateValidite() != null ? sdf.format(d.getDateValidite()) : "", d.getFichier(),
					d.getBienLouable() != null ? d.getBienLouable().getIdBienLouable() : "" });
		}

		int nbValides = (int) diagnostics.stream()
				.filter(d -> d.getDateValidite() != null && d.getDateValidite().after(new java.util.Date())).count();

		int nbExpirant = (int) diagnostics.stream()
				.filter(d -> d.getDateValidite() != null && isExpiringThisMonth(d.getDateValidite())).count();

		fenetre.getLblnbDiag().setText(String.valueOf(nbValides));
		fenetre.getLblnbDiagExp().setText(String.valueOf(nbExpirant));

	}

	private void ouvrirPDF() {
		int selectedRow = fenetre.getTable().getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(fenetre, "Veuillez sélectionner un diagnostic.", "Aucune sélection",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		String path = (String) fenetre.getTable().getValueAt(selectedRow, 4);
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

	public void ouvrirButtonChoisir() {
		int selectedRow = fenetre.getTable().getSelectedRow();
		int selectedColumn = fenetre.getTable().getSelectedColumn();

		if (selectedRow != -1 && selectedColumn == 4) {
			fenetre.getBtnChoisir().setEnabled(true);
		} else {
			fenetre.getBtnChoisir().setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Choisir".equals(e.getActionCommand())) {

			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();

				File projectDir = new File(System.getProperty("user.dir"));
				String path;

				if (selectedFile.toPath().startsWith(projectDir.toPath())) {
					path = projectDir.toURI().relativize(selectedFile.toURI()).getPath();
				} else {
					path = selectedFile.getAbsolutePath();
				}

				int selectedRow = fenetre.getTable().getSelectedRow();
				int selectedColumn = fenetre.getTable().getSelectedColumn();

				if (selectedRow != -1 && selectedColumn != -1) {
					fenetre.getTable().setValueAt(path, selectedRow, selectedColumn);
				}
			}

		} else {
			super.actionPerformed(e);
		}
	}

	public void initialize() {
		super.initialize();
		try {
			this.fenetre.getTable().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						ouvrirPDF();
					}
				}
			});
			chargerDonnees();
			fenetre.getTable().getColumnModel().getSelectionModel().addListSelectionListener(e -> {
				if (!e.getValueIsAdjusting()) {
					ouvrirButtonChoisir();
				}
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
