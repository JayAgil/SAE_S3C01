package vue;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;
import modele.Paiement;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class FenetrePaiement extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestionFenetrePaiement gestionClic;
	private JTable table;
	private String idLoc;
	private List<Paiement> paiements;
	private JLabel lblTotalPaiementAnnees;
	private JLabel lblDateDernierPaiement;
	private JLabel lblValDate;
	private JLabel lblValPaiement;
	private JComboBox comboBoxMois;
	private JComboBox comboBoxAnnee;
	private String nomFenAvant;

	public String getNomFenAvant() {
		return nomFenAvant;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FenetrePaiement frame = new FenetrePaiement(null,null,null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FenetrePaiement(String nomFenAvant,List<Paiement> liste, String idLoc) throws SQLException {
		super();
		this.nomFenAvant = nomFenAvant;
		this.paiements = liste;
		this.idLoc = idLoc;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setTitle("Application Gestion");

		// header
		this.setJMenuBar(createHeader());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new BorderLayout());

		contentPane.add(mainPanel, BorderLayout.CENTER);
		contentPane.add(mainPanel, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		mainPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 0, 5));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);

		JLabel lblDatePaiement = new JLabel("Date paiement :");
		lblDatePaiement.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblDatePaiement);

	    lblValDate = new JLabel("");
		panel_1.add(lblValDate);

		Component horizontalStrut = Box.createHorizontalStrut(600);
		panel_1.add(horizontalStrut);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		JLabel lblMontant = new JLabel("Montant paiement :");
		lblMontant.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblMontant);

		lblValPaiement = new JLabel("");
		panel_5.add(lblValPaiement);

		Component horizontalStrut_1 = Box.createHorizontalStrut(600);
		panel_5.add(horizontalStrut_1);

		JPanel panelButtons = new JPanel();
		mainPanel.add(panelButtons, BorderLayout.SOUTH);

		JButton btnAjouterPaiement = new JButton("Ajouter paiement");
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelButtons.add(btnAjouterPaiement);

		JButton btnRetour = new JButton("Retour");
		panelButtons.add(btnRetour);

		JPanel panel_7 = new JPanel();
		mainPanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);

		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_9.add(scrollPane_1);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 300, 300 };
		gbl_panel_10.rowHeights = new int[] { 150 };
		gbl_panel_10.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel_10.rowWeights = new double[] { 0.0 };
		panel_10.setLayout(gbl_panel_10);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Montant Total", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_10.add(panel_12, gbc_panel_12);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Date Dernier Paiement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 0;
		panel_10.add(panel_11, gbc_panel_11);

		lblDateDernierPaiement = new JLabel("1300");
		lblDateDernierPaiement.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_11.add(lblDateDernierPaiement);
		
		comboBoxAnnee = new JComboBox();
		comboBoxAnnee.setModel(new DefaultComboBoxModel(new String[] {"Année", "2023", "2024", "2025", "2026"}));
		panel_8.add(comboBoxAnnee);

		comboBoxMois = new JComboBox();
		comboBoxMois.setModel(new DefaultComboBoxModel(new String[] { "Mois", "Janvier", "Février", "Mars", "Avril ",
				"Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Decembre" }));
		panel_8.add(comboBoxMois);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Paiement", "ID Contrat", "Date Paiement", "Montant" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table);

		lblTotalPaiementAnnees = new JLabel("3600");
		lblTotalPaiementAnnees.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel_12.add(lblTotalPaiementAnnees);

		contentPane.add(createFooter(), BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Paiement");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblTitre);

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);

		gestionClic = new GestionFenetrePaiement(this,this.paiements,idLoc);
		this.gestionClic.initialize();
		comboBoxMois.addActionListener(gestionClic);
		comboBoxAnnee.addActionListener(gestionClic);
		btnAjouterPaiement.addActionListener(this.gestionClic);
		btnRetour.addActionListener(gestionClic);

	}

	public JComboBox getComboBoxAnnee() {
		return comboBoxAnnee;
	}

	public JComboBox getComboBoxMois() {
		return comboBoxMois;
	}

	public void disableMenuItems(boolean actif) {

	}

	public JTable getTable() {
		return table;
	}

	public JLabel getLblTotalPaiementAnnees() {
		return lblTotalPaiementAnnees;
	}

	public JLabel getLblDateDernierPaiement() {
		return lblDateDernierPaiement;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getLblValDate() {
		return lblValDate;
	}

	public JLabel getLblValPaiement() {
		return lblValPaiement;
	}

}