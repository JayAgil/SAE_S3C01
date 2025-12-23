package vue;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;

public class FenetrePaiement extends FenetreBase {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private GestionFenetrePaiement gestionClic;

	private JTable table;
	private JProgressBar progressBar;

	private JLabel lblTotalPaiementAnnees;
	private JLabel lblTotalPaiementMois;
	private JLabel lblDateDernierPaiement;
	private JLabel lblValDate;
	private JLabel lblValPaiement;

	private JComboBox<String> comboBoxMois;
	private String idLocataire;

	public FenetrePaiement(String idLocataire) throws SQLException {
		super();
		this.idLocataire = idLocataire;
		this.gestionClic = new GestionFenetrePaiement(this, idLocataire);

		setTitle("Application Gestion");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		setJMenuBar(createHeader());

		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		gestionClic.initialize();

		/* ================= HEADER ================= */
		JPanel header = new JPanel();
		JLabel lblTitre = new JLabel("Paiement");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		header.add(lblTitre);
		contentPane.add(header, BorderLayout.NORTH);

		/* ================= MAIN PANEL ================= */
		JPanel mainPanel = new JPanel(new GridBagLayout());
		contentPane.add(mainPanel, BorderLayout.CENTER);

		/* ---------- INFO PANEL ---------- */
		JPanel infoPanel = new JPanel(new GridLayout(1, 2));

		JPanel leftInfo = new JPanel();
		leftInfo.add(new JLabel("Date paiement : "));
		lblValDate = new JLabel("—");
		leftInfo.add(lblValDate);

		JPanel rightInfo = new JPanel();
		rightInfo.add(new JLabel("Montant paiement : "));
		lblValPaiement = new JLabel("— €");
		rightInfo.add(lblValPaiement);

		infoPanel.add(leftInfo);
		infoPanel.add(rightInfo);

		GridBagConstraints gbcInfo = new GridBagConstraints();
		gbcInfo.gridx = 0;
		gbcInfo.gridy = 0;
		gbcInfo.weightx = 1;
		gbcInfo.weighty = 0;
		gbcInfo.fill = GridBagConstraints.BOTH;
		gbcInfo.insets = new Insets(5, 5, 5, 5);
		mainPanel.add(infoPanel, gbcInfo);

		/* ---------- FILTER PANEL ---------- */
		JPanel filterPanel = new JPanel();
		comboBoxMois = new JComboBox<>(new String[]{
				"Mois", "Janvier", "Février", "Mars", "Avril", "Mai",
				"Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"
		});
		comboBoxMois.addActionListener(gestionClic);
		filterPanel.add(comboBoxMois);

		GridBagConstraints gbcFilter = new GridBagConstraints();
		gbcFilter.gridx = 0;
		gbcFilter.gridy = 1;
		gbcFilter.weightx = 1;
		gbcFilter.weighty = 0;
		gbcFilter.fill = GridBagConstraints.BOTH;
		gbcFilter.insets = new Insets(5, 5, 5, 5);
		mainPanel.add(filterPanel, gbcFilter);

		/* ---------- TABLE ---------- */
		table = new JTable(new DefaultTableModel(
				new Object[][]{},
				new String[]{"ID Paiement", "ID Contrat", "Date Paiement", "Montant"}
		));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 260));

		GridBagConstraints gbcTable = new GridBagConstraints();
		gbcTable.gridx = 0;
		gbcTable.gridy = 2;
		gbcTable.weightx = 1;
		gbcTable.weighty = 0.55;
		gbcTable.fill = GridBagConstraints.BOTH;
		gbcTable.insets = new Insets(5, 5, 5, 5);
		mainPanel.add(scrollPane, gbcTable);

		/* ---------- TOTALS ---------- */
		JPanel totalsPanel = new JPanel(new GridLayout(1, 3, 10, 10));

		lblTotalPaiementAnnees = new JLabel("3600", SwingConstants.CENTER);
		lblTotalPaiementAnnees.setFont(new Font("Tahoma", Font.PLAIN, 40));

		lblTotalPaiementMois = new JLabel("1200", SwingConstants.CENTER);
		lblTotalPaiementMois.setFont(new Font("Tahoma", Font.PLAIN, 40));

		lblDateDernierPaiement = new JLabel("—", SwingConstants.CENTER);
		lblDateDernierPaiement.setFont(new Font("Tahoma", Font.PLAIN, 40));

		JPanel p1 = new JPanel(new BorderLayout());
		p1.setBorder(new TitledBorder("Total Année"));
		p1.add(lblTotalPaiementAnnees);

		JPanel p2 = new JPanel(new BorderLayout());
		p2.setBorder(new TitledBorder("Total Mois"));
		p2.add(lblTotalPaiementMois);

		JPanel p3 = new JPanel(new BorderLayout());
		p3.setBorder(new TitledBorder("Dernier Paiement"));
		p3.add(lblDateDernierPaiement);

		totalsPanel.add(p1);
		totalsPanel.add(p2);
		totalsPanel.add(p3);

		GridBagConstraints gbcTotals = new GridBagConstraints();
		gbcTotals.gridx = 0;
		gbcTotals.gridy = 3;
		gbcTotals.weightx = 1;
		gbcTotals.weighty = 0.25;
		gbcTotals.fill = GridBagConstraints.BOTH;
		gbcTotals.insets = new Insets(5, 5, 5, 5);
		mainPanel.add(totalsPanel, gbcTotals);

		/* ================= BOTTOM ================= */
		progressBar = new JProgressBar();
		progressBar.setValue(30);
		progressBar.setStringPainted(true);
		progressBar.setString("30 % de paiements reçus");

		JPanel buttons = new JPanel();
		JButton btnAjouter = new JButton("Ajouter paiement");
		JButton btnRetour = new JButton("Retour");

		btnAjouter.addActionListener(gestionClic);
		btnRetour.addActionListener(gestionClic);

		buttons.add(btnAjouter);
		buttons.add(btnRetour);

		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(progressBar, BorderLayout.NORTH);
		bottomPanel.add(buttons, BorderLayout.SOUTH);

		contentPane.add(bottomPanel, BorderLayout.SOUTH);
	}

	/* ================= GETTERS ================= */

	public JTable getTable() {
		return table;
	}

	public JComboBox<String> getComboBoxMois() {
		return comboBoxMois;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JLabel getLblTotalPaiementAnnees() {
		return lblTotalPaiementAnnees;
	}

	public JLabel getLblPaiementMois() {
		return lblTotalPaiementMois;
	}

	public JLabel getLblDateDernierPaiement() {
		return lblDateDernierPaiement;
	}

	public JLabel getLblValDate() {
		return lblValDate;
	}

	public JLabel getLblValPaiement() {
		return lblValPaiement;
	}
}
