package vue;

import controleur.GestionFenetreContratLocation;
import modele.BienLouable;
import modele.ContratLocation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.awt.event.ActionListener;

public class FenetreContratLocation extends FenetreBase {
	private GestionFenetreContratLocation gestionClicContratLocation;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String fenDavant;
	private ContratLocation cl;
	private JTextField textFieldNomLoc;
	private JTextField textFieldNdC;
	private JTextField textFieldPeriode;
	private JTextField textFieldMontantC;
	private JTextField textFieldProvCharge;
	private JTextField textFieldLoyerMen;
	private JTextField textFieldCptEau;
	private JTextField textFieldCptElec;
	private JTextField textFieldCptGaz;
	private JTextField textFieldSolde;
	private JLabel lblTitreTable;
	private BienLouable bl;
	private JButton btnAjouter;

	public FenetreContratLocation(String f, ContratLocation cl, BienLouable bl) throws SQLException {
		super();
		this.fenDavant = f;
		this.bl = bl;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.cl = cl;

		// header
		this.setJMenuBar(createHeader());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		// footer
		getContentPane().add(createFooter(), BorderLayout.SOUTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		Panel Title_1 = new Panel();
		panel_1.add(Title_1, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Contrats locations ");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		Title_1.add(lblTitre);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");
		panel_2.add(btnRetour);
		btnRetour.addActionListener((ActionListener) gestionClicContratLocation);

		btnAjouter = new JButton("Ajouter");
		panel_2.add(btnAjouter);

		JButton btnAnnuler = new JButton("Annuler");
		panel_2.add(btnAnnuler);

		JButton btnRevalLoyer = new JButton("Revaloriser loyer");
		panel_2.add(btnRevalLoyer);

		JButton btnRevalCharge = new JButton("Revaloriser charge");
		panel_2.add(btnRevalCharge);

		JButton btnReguCharges = new JButton("Regulariser charge");
		panel_2.add(btnReguCharges);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 1176, 0 };
		gbl_panel_3.rowHeights = new int[] { 430, 0, 250, 0, 40 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.EAST;
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.rowHeights = new int[] { 25, 35, 35, 35, 35, 35, 35, 35, 40 };
		gbl_panel_4.columnWidths = new int[] { 350, 626, 200 };
		gbl_panel_4.columnWeights = new double[] { Double.MIN_VALUE, 1.0 };
		gbl_panel_4.rowWeights = new double[] {};
		panel_4.setLayout(gbl_panel_4);

		JLabel labelNom = new JLabel("Nom : ");
		GridBagConstraints gbc_labelNom = new GridBagConstraints();
		gbc_labelNom.anchor = GridBagConstraints.EAST;
		gbc_labelNom.insets = new Insets(0, 0, 5, 5);
		gbc_labelNom.gridx = 0;
		gbc_labelNom.gridy = 0;
		panel_4.add(labelNom, gbc_labelNom);

		textFieldNomLoc = new JTextField();
		textFieldNomLoc.setForeground(Color.BLACK);
		textFieldNomLoc.setBorder(BorderFactory.createEmptyBorder());
		textFieldNomLoc.setEditable(false);
		GridBagConstraints gbc_textFieldNomLoc = new GridBagConstraints();
		gbc_textFieldNomLoc.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNomLoc.fill = GridBagConstraints.BOTH;
		gbc_textFieldNomLoc.gridx = 1;
		gbc_textFieldNomLoc.gridy = 0;
		panel_4.add(textFieldNomLoc, gbc_textFieldNomLoc);
		textFieldNomLoc.setColumns(10);

		JLabel lblNC = new JLabel("Numero de contrat : ");
		GridBagConstraints gbc_lblNC = new GridBagConstraints();
		gbc_lblNC.anchor = GridBagConstraints.EAST;
		gbc_lblNC.insets = new Insets(0, 0, 5, 5);
		gbc_lblNC.gridx = 0;
		gbc_lblNC.gridy = 1;
		panel_4.add(lblNC, gbc_lblNC);

		textFieldNdC = new JTextField();
		textFieldNdC.setEditable(false);
		textFieldNdC.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_textFieldNdC = new GridBagConstraints();
		gbc_textFieldNdC.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNdC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNdC.gridx = 1;
		gbc_textFieldNdC.gridy = 1;
		panel_4.add(textFieldNdC, gbc_textFieldNdC);
		textFieldNdC.setColumns(10);

		JLabel lblValidite = new JLabel("Validite de contrat : ");
		GridBagConstraints gbc_lblValidite = new GridBagConstraints();
		gbc_lblValidite.anchor = GridBagConstraints.EAST;
		gbc_lblValidite.insets = new Insets(0, 0, 5, 5);
		gbc_lblValidite.gridx = 0;
		gbc_lblValidite.gridy = 2;
		panel_4.add(lblValidite, gbc_lblValidite);

		textFieldPeriode = new JTextField();
		textFieldPeriode.setEditable(false);
		textFieldPeriode.setBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_textFieldPeriode = new GridBagConstraints();
		gbc_textFieldPeriode.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPeriode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPeriode.gridx = 1;
		gbc_textFieldPeriode.gridy = 2;
		panel_4.add(textFieldPeriode, gbc_textFieldPeriode);
		textFieldPeriode.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Montant de caution : ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldMontantC = new JTextField();
		textFieldMontantC.setEditable(false);
		textFieldMontantC.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldMontantC = new GridBagConstraints();
		gbc_textFieldMontantC.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMontantC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMontantC.gridx = 1;
		gbc_textFieldMontantC.gridy = 3;
		panel_4.add(textFieldMontantC, gbc_textFieldMontantC);
		textFieldMontantC.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Provision Charge : ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldProvCharge = new JTextField();
		textFieldProvCharge.setEditable(false);
		textFieldProvCharge.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldProvCharge = new GridBagConstraints();
		gbc_textFieldProvCharge.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldProvCharge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProvCharge.gridx = 1;
		gbc_textFieldProvCharge.gridy = 4;
		panel_4.add(textFieldProvCharge, gbc_textFieldProvCharge);
		textFieldProvCharge.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Loyer mensuel : ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textFieldLoyerMen = new JTextField();
		textFieldLoyerMen.setBorder(BorderFactory.createEmptyBorder());

		textFieldLoyerMen.setEditable(false);
		GridBagConstraints gbc_textFieldLoyerMen = new GridBagConstraints();
		gbc_textFieldLoyerMen.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLoyerMen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLoyerMen.gridx = 1;
		gbc_textFieldLoyerMen.gridy = 5;
		panel_4.add(textFieldLoyerMen, gbc_textFieldLoyerMen);
		textFieldLoyerMen.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Index Compteur Eau Ancien: : ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textFieldCptEau = new JTextField();
		textFieldCptEau.setEditable(false);
		textFieldCptEau.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldCptEau = new GridBagConstraints();
		gbc_textFieldCptEau.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCptEau.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCptEau.gridx = 1;
		gbc_textFieldCptEau.gridy = 6;
		panel_4.add(textFieldCptEau, gbc_textFieldCptEau);
		textFieldCptEau.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Index Compteur Electricite Ancien: : ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textFieldCptElec = new JTextField();
		textFieldCptElec.setEditable(false);
		textFieldCptElec.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldCptElec = new GridBagConstraints();
		gbc_textFieldCptElec.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCptElec.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCptElec.gridx = 1;
		gbc_textFieldCptElec.gridy = 7;
		panel_4.add(textFieldCptElec, gbc_textFieldCptElec);
		textFieldCptElec.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Index Compteur Gaz Ancien: : ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);

		textFieldCptGaz = new JTextField();
		textFieldCptGaz.setEditable(false);
		textFieldCptGaz.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldCptGaz = new GridBagConstraints();
		gbc_textFieldCptGaz.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCptGaz.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCptGaz.gridx = 1;
		gbc_textFieldCptGaz.gridy = 8;
		panel_4.add(textFieldCptGaz, gbc_textFieldCptGaz);
		textFieldCptGaz.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Solde : ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);

		textFieldSolde = new JTextField();
		textFieldSolde.setEditable(false);
		textFieldSolde.setBorder(BorderFactory.createEmptyBorder());

		GridBagConstraints gbc_textFieldSolde = new GridBagConstraints();
		gbc_textFieldSolde.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSolde.gridx = 1;
		gbc_textFieldSolde.gridy = 9;
		panel_4.add(textFieldSolde, gbc_textFieldSolde);
		textFieldSolde.setColumns(10);

		lblTitreTable = new JLabel("Tous les contrats sous le bien");
		lblTitreTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblTitreTable = new GridBagConstraints();
		gbc_lblTitreTable.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitreTable.gridx = 0;
		gbc_lblTitreTable.gridy = 1;
		panel_3.add(lblTitreTable, gbc_lblTitreTable);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_3.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.addMouseListener(this.gestionClicContratLocation);
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Nom du locataire", "Numero De Contrat", "Date Fin", "Montant Mensuel", "Solde" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 3;
		panel_3.add(panel_5, gbc_panel_5);

		this.gestionClicContratLocation = new GestionFenetreContratLocation(this, this.cl, bl);
		this.gestionClicContratLocation.initialize();
		btnAjouter.addActionListener(gestionClicContratLocation);
		btnAnnuler.addActionListener(gestionClicContratLocation);
		btnRevalLoyer.addActionListener(this.gestionClicContratLocation);
		btnRevalCharge.addActionListener(this.gestionClicContratLocation);
		btnReguCharges.addActionListener(this.gestionClicContratLocation);
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JTextField getTextFieldNomLoc() {
		return textFieldNomLoc;
	}

	public void setTextFieldNomLoc(JTextField textFieldNomLoc) {
		this.textFieldNomLoc = textFieldNomLoc;
	}

	public JTextField getTextFieldNdC() {
		return textFieldNdC;
	}

	public void setTextFieldNdC(JTextField textFieldNdC) {
		this.textFieldNdC = textFieldNdC;
	}

	public JTextField getTextFieldPeriode() {
		return textFieldPeriode;
	}

	public void setTextFieldPeriode(JTextField textFieldPeriode) {
		this.textFieldPeriode = textFieldPeriode;
	}

	public JTextField getTextFieldMontantC() {
		return textFieldMontantC;
	}

	public void setTextFieldMontantC(JTextField textFieldMontantC) {
		this.textFieldMontantC = textFieldMontantC;
	}

	public JTextField getTextFieldProvCharge() {
		return textFieldProvCharge;
	}

	public void setTextFieldProvCharge(JTextField textFieldProvCharge) {
		this.textFieldProvCharge = textFieldProvCharge;
	}

	public JTextField getTextFieldLoyerMen() {
		return textFieldLoyerMen;
	}

	public void setTextFieldLoyerMen(JTextField textFieldLoyerMen) {
		this.textFieldLoyerMen = textFieldLoyerMen;
	}

	public JTextField getTextFieldCptEau() {
		return textFieldCptEau;
	}

	public void setTextFieldCptEau(JTextField textFieldCptEau) {
		this.textFieldCptEau = textFieldCptEau;
	}

	public JTextField getTextFieldCptElec() {
		return textFieldCptElec;
	}

	public void setTextFieldCptElec(JTextField textFieldCptElec) {
		this.textFieldCptElec = textFieldCptElec;
	}

	public JTextField getTextFieldCptGaz() {
		return textFieldCptGaz;
	}

	public void setTextFieldCptGaz(JTextField textFieldCptGaz) {
		this.textFieldCptGaz = textFieldCptGaz;
	}

	public JTextField getTextFieldSolde() {
		return textFieldSolde;
	}

	public void setTextFieldSolde(JTextField textFieldSolde) {
		this.textFieldSolde = textFieldSolde;
	}

	public JLabel getTitreTable() {
		return lblTitreTable;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setFenDavant(String fenDavant) {
		this.fenDavant = fenDavant;
	}

	public String getFenDavant() {
		return this.fenDavant;
	}

	public JTable getTable() {
		return this.table;
	}

}
