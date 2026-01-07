package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import controleur.GestionFenetreCompteurs;
import modele.BienLouable;
import modele.Compteur;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class FenetreCompteurs extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCompteurs;
	private GestionFenetreCompteurs gestionClic;
	private String fenetreAvant;
	private JLabel lbltotaleau;
	private JLabel lnltotalelec;
	private JLabel lbltotalgaz;
	private JScrollPane scrollPane;
	private List<Compteur> cpt;
	private BienLouable b;
	private JButton btnAjouterCompteur;

	public FenetreCompteurs(String fenetreAvant, List<Compteur> cpt, BienLouable b){
		super();
		this.b = b;
		this.fenetreAvant = fenetreAvant;
		this.cpt = cpt;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);

		// header
		this.setJMenuBar(createHeader());

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// footer
		getContentPane().add(createFooter(), BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null }, },
				new String[] { "Type", "Date", "Index ancien", "Index nouveau", "Consommation", "Partie Variable",
						"Partie Fixe", "Total" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		tableCompteurs = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Type", "Date", "Bien louable", "Index ancien", "Index nouveau", "Consommation", "Partie Variable", "Partie Fixe", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, true, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		scrollPane = new JScrollPane(tableCompteurs);
		panel.add(scrollPane, BorderLayout.NORTH);
		scrollPane.setPreferredSize(new Dimension(700, 300));

		JPanel panel_butons = new JPanel();
		panel.add(panel_butons, BorderLayout.SOUTH);
		panel_butons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAjouterCompteur = new JButton("Ajouter compteur");
		panel_butons.add(btnAjouterCompteur);

		JButton btnMAJ = new JButton("Mettre à jour");
		panel_butons.add(btnMAJ);

		JButton btnRetour = new JButton("Retour");
		panel_butons.add(btnRetour);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 400, 400, 400 };
		gbl_panel_2.rowHeights = new int[] { 230, 200 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_panel_2.rowWeights = new double[] { 1.0, 1.0 };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Total Eau",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 400 };
		gbl_panel_4.rowHeights = new int[] { 50, 180 };
		gbl_panel_4.columnWeights = new double[] { 1.0 };
		gbl_panel_4.rowWeights = new double[] { 0.0, 1.0 };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				"Total \u00C9lectricit\u00E9", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
		gbc_panel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4_1.fill = GridBagConstraints.BOTH;
		gbc_panel_4_1.gridx = 1;
		gbc_panel_4_1.gridy = 0;
		panel_2.add(panel_4_1, gbc_panel_4_1);
		GridBagLayout gbl_panel_4_1 = new GridBagLayout();
		gbl_panel_4_1.columnWidths = new int[] { 400 };
		gbl_panel_4_1.rowHeights = new int[] { 50, 180 };
		gbl_panel_4_1.columnWeights = new double[] { 1.0 };
		gbl_panel_4_1.rowWeights = new double[] { 0.0, 1.0 };
		panel_4_1.setLayout(gbl_panel_4_1);

		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_4_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Total Gaz",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4_2 = new GridBagConstraints();
		gbc_panel_4_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4_2.fill = GridBagConstraints.BOTH;
		gbc_panel_4_2.gridx = 2;
		gbc_panel_4_2.gridy = 0;
		panel_2.add(panel_4_2, gbc_panel_4_2);
		GridBagLayout gbl_panel_4_2 = new GridBagLayout();
		gbl_panel_4_2.columnWidths = new int[] { 400 };
		gbl_panel_4_2.rowHeights = new int[] { 50, 180 };
		gbl_panel_4_2.columnWeights = new double[] { 1.0 };
		gbl_panel_4_2.rowWeights = new double[] { 0.0, 1.0 };
		panel_4_2.setLayout(gbl_panel_4_2);

		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_4_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		Component verticalStrut = Box.createVerticalStrut(60);
		panel_1.add(verticalStrut);

		JLabel lblTitre = new JLabel("Compteurs");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblTitre);

		// icons
		ImageIcon eauIcon = new ImageIcon("img/water.png");
		Image imgEau = eauIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(imgEau));
		lblNewLabel.setHorizontalAlignment(JLabel.RIGHT);

		lbltotaleau = new JLabel("860");
		lbltotaleau.setFont(new Font("Tahoma", Font.PLAIN, 95));
		GridBagConstraints gbc_lbltotaleau = new GridBagConstraints();
		gbc_lbltotaleau.gridx = 0;
		gbc_lbltotaleau.gridy = 1;
		panel_4.add(lbltotaleau, gbc_lbltotaleau);

		ImageIcon elecIcon = new ImageIcon("img/electricity.png");
		Image imgElec = elecIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(imgElec));
		lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);

		lnltotalelec = new JLabel("900");
		lnltotalelec.setFont(new Font("Tahoma", Font.PLAIN, 95));
		GridBagConstraints gbc_lnltotalelec = new GridBagConstraints();
		gbc_lnltotalelec.gridx = 0;
		gbc_lnltotalelec.gridy = 1;
		panel_4_1.add(lnltotalelec, gbc_lnltotalelec);

		ImageIcon gazIcon = new ImageIcon("img/gaz.png");
		Image imgGaz = gazIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(imgGaz));
		lblNewLabel_2.setHorizontalAlignment(JLabel.RIGHT);

		lbltotalgaz = new JLabel("123");
		lbltotalgaz.setFont(new Font("Tahoma", Font.PLAIN, 95));
		GridBagConstraints gbc_lbltotalgaz = new GridBagConstraints();
		gbc_lbltotalgaz.gridx = 0;
		gbc_lbltotalgaz.gridy = 1;
		panel_4_2.add(lbltotalgaz, gbc_lbltotalgaz);

		this.gestionClic = new GestionFenetreCompteurs(this, cpt);
		this.gestionClic.initialize();
		btnAjouterCompteur.addActionListener(this.gestionClic);
		btnRetour.addActionListener(this.gestionClic);
		btnMAJ.addActionListener(this.gestionClic);

	}

	public JButton getBtnAjouterCompteur() {
		return btnAjouterCompteur;
	}

	public JTable getTableCompteurs() {
		return tableCompteurs;
	}

	public void setTableCompteurs(JTable tableCompteurs) {
		this.tableCompteurs = tableCompteurs;
	}

	public JLabel getLbltotaleau() {
		return lbltotaleau;
	}

	public void setLbltotaleau(JLabel lbltotaleau) {
		this.lbltotaleau = lbltotaleau;
	}

	public JLabel getLnltotalelec() {
		return lnltotalelec;
	}

	public void setLnltotalelec(JLabel lnltotalelec) {
		this.lnltotalelec = lnltotalelec;
	}

	public JLabel getLbltotalgaz() {
		return lbltotalgaz;
	}

	public void setLbltotalgaz(JLabel lbltotalgaz) {
		this.lbltotalgaz = lbltotalgaz;
	}

	public String getFenetreAvant() {
		return fenetreAvant;
	}

	public BienLouable getB() {
		return b;
	}

}