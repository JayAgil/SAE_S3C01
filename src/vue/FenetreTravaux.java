package vue;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreTravaux;
import modele.BienLouable;
import modele.Facture;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FenetreTravaux extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private GestionFenetreTravaux gestionClic;

	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblMontantTotal;
	private JLabel lblNbTravaux;
	private List<Facture> factures;
	private JComboBox comboBox_Mois;
	private JComboBox comboBox_Annee;
	private BienLouable bien;
	private String fenetreAvant;
	private JButton btnAjouterTravaux;

	public FenetreTravaux(String fenAvant, List<Facture> liste, BienLouable bien) {
		super();
		this.fenetreAvant = fenAvant;
		this.bien = bien;
		this.factures = liste;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));

		this.setJMenuBar(createHeader());

		JPanel panel_12 = new JPanel();
		getContentPane().add(panel_12, BorderLayout.SOUTH);
		panel_12.add(createFooter());
		panel_12.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");
		panel_1.add(btnRetour);
		btnRetour.addActionListener(this.gestionClic);

		btnAjouterTravaux = new JButton("Ajouter travaux");
		panel_1.add(btnAjouterTravaux);

		JButton btnAjouterEntreprise = new JButton("Ajouter entreprise");
		panel_1.add(btnAjouterEntreprise);

		JButton btnGenFacture = new JButton("Visualiser facture");
		panel_1.add(btnGenFacture);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);

		JLabel lblTravaux = new JLabel("Travaux");
		lblTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		lblTravaux.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblTravaux);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "Num\u00E9ro facture", "Montant", "Date de facture", "Compte bancaire", "Montant devis",
						"Date de paiement", "D\u00E9signation travaux", "Entreprise" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Float.class,
					String.class, String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		panel_3.setLayout(new BorderLayout(0, 0));

		scrollPane.setViewportView(table);
		panel_3.add(scrollPane, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 100, 100 };
		gbl_panel_4.rowHeights = new int[] { 50 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_4.rowWeights = new double[] { 1.0 };
		panel_4.setLayout(gbl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Montant Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		lblMontantTotal = new JLabel("14,200");
		lblMontantTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontantTotal.setFont(new Font("Tahoma", Font.BOLD, 95));
		panel_5.add(lblMontantTotal);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(10);
		panel_5.add(panel_8, BorderLayout.NORTH);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Nombre de travaux effectu\u00E9s", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_4.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		lblNbTravaux = new JLabel("3");
		lblNbTravaux.setFont(new Font("Tahoma", Font.BOLD, 95));
		lblNbTravaux.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNbTravaux);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_7, BorderLayout.NORTH);

		JLabel lblMois = new JLabel("Mois : ");
		panel_7.add(lblMois);

		comboBox_Mois = new JComboBox();
		comboBox_Mois.setModel(new DefaultComboBoxModel(new String[] { "Tous", "Janvier", "Février", "Mars", "Avril",
				"Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" }));
		panel_7.add(comboBox_Mois);

		JLabel lblAnnee = new JLabel("Annee :");
		panel_7.add(lblAnnee);

		comboBox_Annee = new JComboBox();
		comboBox_Annee.setModel(new DefaultComboBoxModel(new String[] { "Tous", "2023", "2024", "2025", "2026" }));
		panel_7.add(comboBox_Annee);

		this.gestionClic = new GestionFenetreTravaux(this, this.factures);
		btnAjouterTravaux.addActionListener(this.gestionClic);
		btnAjouterEntreprise.addActionListener(this.gestionClic);
		btnGenFacture.addActionListener(this.gestionClic);
		comboBox_Mois.addActionListener(this.gestionClic);
		comboBox_Annee.addActionListener(this.gestionClic);
		this.gestionClic.initialize();
	}

	public JButton getBtnAjouterTravaux() {
		return btnAjouterTravaux;
	}

	public JComboBox getComboBox_Mois() {
		return comboBox_Mois;
	}

	public void setComboBox_Mois(JComboBox comboBox_Mois) {
		this.comboBox_Mois = comboBox_Mois;
	}

	public JComboBox getComboBox_Annee() {
		return comboBox_Annee;
	}

	public void setComboBox_Annee(JComboBox comboBox_Annee) {
		this.comboBox_Annee = comboBox_Annee;
	}

	public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
		this.mntmTravaux.setEnabled(actif);
	}

	public JTable getTable() {
		return table;
	}

	public JLabel getLblMontantTotal() {
		return lblMontantTotal;
	}

	public void setLblMontantTotal(JLabel lblMontantTotal) {
		this.lblMontantTotal = lblMontantTotal;
	}

	public JLabel getLblNbTravaux() {
		return lblNbTravaux;
	}

	public void setLblNbTravaux(JLabel lblNewLabel) {
		this.lblNbTravaux = lblNewLabel;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public BienLouable getBien() {
		return bien;
	}

	public String getFenetreAvant() {
		return fenetreAvant;
	}

}
