package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreBienLouable;
import modele.Assurance;
import modele.BienLouable;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreBienLouable extends FenetreBase {
	private GestionFenetreBienLouable gestionClicBienLouable;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNom;
	private JTextField textFieldLoyerMen;
	private JTextField textFieldNF;
	private JTextField textFieldAdresse;
	private JTextField textFieldSurfaceHab;
	private JTextField textFieldNbDPieces;
	private JTextField textFieldBienLoauble;
	private JTextField textFieldBatiment;
	private JTextField textFieldDT;
	private JTextField textFieldTotalCharges;
	private JTextField textFieldDFC;
	private JTextField textFieldDP;
	private BienLouable bienLouable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreBienLouable frame = new FenetreBienLouable(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FenetreBienLouable(String nomFenAvant, BienLouable bienLouables) throws SQLException {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.bienLouable = bienLouables;
		this.gestionClicBienLouable = new GestionFenetreBienLouable(this, this.bienLouable);
		// header
		this.setJMenuBar(createHeader());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.gestionClicBienLouable.initialize();

		getContentPane().add(createFooter(), BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.SOUTH);

		JButton btnRetour = new JButton("Retour");
		panel.add(btnRetour);
		btnRetour.addActionListener(gestionClicBienLouable);

		JButton btnCompteur = new JButton("Compteur");
		panel.add(btnCompteur);

		Component verticalStrut = Box.createVerticalStrut(40);
		panel.add(verticalStrut);

		JButton btnDiagnostic = new JButton("Diagnostics");
		btnDiagnostic.addActionListener(this.gestionClicBienLouable);
		panel.add(btnDiagnostic);

		JButton btnTravaux = new JButton("Travaux");
		btnTravaux.addActionListener(this.gestionClicBienLouable);
		panel.add(btnTravaux);

		JButton btnCharge = new JButton("Charges");
		btnCharge.addActionListener(this.gestionClicBienLouable);
		panel.add(btnCharge);

		JButton btnContrat = new JButton("Contrat");
		btnContrat.addActionListener(this.gestionClicBienLouable);
		panel.add(btnContrat);

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 1176, 0 };
		gbl_panel_3.rowHeights = new int[] { 450, 0, 250, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_3.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gbl_panel_4.columnWidths = new int[] { 350, 600, 200 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel = new JLabel("Nom Locataire : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		textFieldNom = new JTextField();
		textFieldNom.setEditable(false);
		textFieldNom.setBorder(null);

		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 1;
		gbc_textFieldNom.gridy = 0;
		panel_4.add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Loyer mensuel : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldLoyerMen = new JTextField();
		textFieldLoyerMen.setEditable(false);
		textFieldLoyerMen.setBorder(null);

		GridBagConstraints gbc_textFieldLoyerMen = new GridBagConstraints();
		gbc_textFieldLoyerMen.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLoyerMen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLoyerMen.gridx = 1;
		gbc_textFieldLoyerMen.gridy = 1;
		panel_4.add(textFieldLoyerMen, gbc_textFieldLoyerMen);
		textFieldLoyerMen.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Numero Fiscale :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldNF = new JTextField();
		textFieldNF.setEditable(false);
		textFieldNF.setBorder(null);

		GridBagConstraints gbc_textFieldNF = new GridBagConstraints();
		gbc_textFieldNF.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNF.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNF.gridx = 1;
		gbc_textFieldNF.gridy = 2;
		panel_4.add(textFieldNF, gbc_textFieldNF);
		textFieldNF.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Adresse : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldAdresse = new JTextField();
		textFieldAdresse.setEditable(false);
		textFieldAdresse.setBorder(null);

		GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
		gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse.gridx = 1;
		gbc_textFieldAdresse.gridy = 3;
		panel_4.add(textFieldAdresse, gbc_textFieldAdresse);
		textFieldAdresse.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Surface Habituable : ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);

		textFieldSurfaceHab = new JTextField();
		textFieldSurfaceHab.setEditable(false);
		textFieldSurfaceHab.setBorder(null);

		GridBagConstraints gbc_textFieldSurfaceHab = new GridBagConstraints();
		gbc_textFieldSurfaceHab.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSurfaceHab.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSurfaceHab.gridx = 1;
		gbc_textFieldSurfaceHab.gridy = 4;
		panel_4.add(textFieldSurfaceHab, gbc_textFieldSurfaceHab);
		textFieldSurfaceHab.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Nombre de pieces : ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		textFieldNbDPieces = new JTextField();
		textFieldNbDPieces.setEditable(false);
		textFieldNbDPieces.setBorder(null);

		
		GridBagConstraints gbc_textFieldNbDPieces = new GridBagConstraints();
		gbc_textFieldNbDPieces.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNbDPieces.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNbDPieces.gridx = 1;
		gbc_textFieldNbDPieces.gridy = 5;
		panel_4.add(textFieldNbDPieces, gbc_textFieldNbDPieces);
		textFieldNbDPieces.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Type bien louable : ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);

		textFieldBienLoauble = new JTextField();
		textFieldBienLoauble.setEditable(false);
		textFieldBienLoauble.setBorder(null);

		GridBagConstraints gbc_textFieldBienLoauble = new GridBagConstraints();
		gbc_textFieldBienLoauble.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBienLoauble.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBienLoauble.gridx = 1;
		gbc_textFieldBienLoauble.gridy = 6;
		panel_4.add(textFieldBienLoauble, gbc_textFieldBienLoauble);
		textFieldBienLoauble.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Batiment : ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);

		textFieldBatiment = new JTextField();
		textFieldBatiment.setEditable(false);
		textFieldBatiment.setBorder(null);

		GridBagConstraints gbc_textFieldBatiment = new GridBagConstraints();
		gbc_textFieldBatiment.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBatiment.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBatiment.gridx = 1;
		gbc_textFieldBatiment.gridy = 7;
		panel_4.add(textFieldBatiment, gbc_textFieldBatiment);
		textFieldBatiment.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Date de derniere travaux : ");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);

		textFieldDT = new JTextField();
		textFieldDT.setEditable(false);
		textFieldDT.setBorder(null);

		GridBagConstraints gbc_textFieldDT = new GridBagConstraints();
		gbc_textFieldDT.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDT.gridx = 1;
		gbc_textFieldDT.gridy = 8;
		panel_4.add(textFieldDT, gbc_textFieldDT);
		textFieldDT.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Total Charges : ");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);

		textFieldTotalCharges = new JTextField();
		textFieldTotalCharges.setEditable(false);
		textFieldTotalCharges.setBorder(null);

		GridBagConstraints gbc_textFieldTotalCharges = new GridBagConstraints();
		gbc_textFieldTotalCharges.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTotalCharges.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotalCharges.gridx = 1;
		gbc_textFieldTotalCharges.gridy = 9;
		panel_4.add(textFieldTotalCharges, gbc_textFieldTotalCharges);
		textFieldTotalCharges.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Date Fin de Contrat : ");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 10;
		panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);

		textFieldDFC = new JTextField();
		textFieldDFC.setEditable(false);
		textFieldDFC.setBorder(null);

		GridBagConstraints gbc_textFieldDFC = new GridBagConstraints();
		gbc_textFieldDFC.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDFC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDFC.gridx = 1;
		gbc_textFieldDFC.gridy = 10;
		panel_4.add(textFieldDFC, gbc_textFieldDFC);
		textFieldDFC.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Dernier Paiement : ");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 11;
		panel_4.add(lblNewLabel_11, gbc_lblNewLabel_11);

		textFieldDP = new JTextField();
		textFieldDP.setEditable(false);
		textFieldDP.setBorder(null);

		GridBagConstraints gbc_textFieldDP = new GridBagConstraints();
		gbc_textFieldDP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDP.gridx = 1;
		gbc_textFieldDP.gridy = 11;
		panel_4.add(textFieldDP, gbc_textFieldDP);
		textFieldDP.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_3.add(panel_6, gbc_panel_6);
		
		JLabel lblTitreTable = new JLabel("Tous les biens sous le batiment");
		lblTitreTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(lblTitreTable);

		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 2;
		panel_3.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		table = new JTable();
		table.addMouseListener(this.gestionClicBienLouable);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "Id Bien Louble", "Adresse", "Nombre Pieces", "Type Bien" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		scrollPane.setViewportView(table);
		btnCompteur.addActionListener(gestionClicBienLouable);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblTitre = new JLabel("Bien louable");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lblTitre);

		this.gestionClicBienLouable.chargerDonnees();

		if (this.bienLouable != null) {
			this.gestionClicBienLouable.chargerBienEtRemplirFormulaire(this.bienLouable.getIdBienLouable());
			
		}
	}

	public JTextField getTextFieldNom() {
		return textFieldNom;
	}

	public void setTextFieldNom(JTextField textFieldNom) {
		this.textFieldNom = textFieldNom;
	}

	public JTextField getTextFieldLoyerMen() {
		return textFieldLoyerMen;
	}

	public void setTextFieldLoyerMen(JTextField textFieldLoyerMen) {
		this.textFieldLoyerMen = textFieldLoyerMen;
	}

	public JTextField getTextFieldNF() {
		return textFieldNF;
	}

	public void setTextFieldNF(JTextField textFieldNF) {
		this.textFieldNF = textFieldNF;
	}

	public JTextField getTextFieldAdresse() {
		return textFieldAdresse;
	}

	public void setTextFieldAdresse(JTextField textFieldAdresse) {
		this.textFieldAdresse = textFieldAdresse;
	}

	public JTextField getTextFieldSurfaceHab() {
		return textFieldSurfaceHab;
	}

	public void setTextFieldSurfaceHab(JTextField textFieldSurfaceHab) {
		this.textFieldSurfaceHab = textFieldSurfaceHab;
	}

	public JTextField getTextFieldNbDPieces() {
		return textFieldNbDPieces;
	}

	public void setTextFieldNbDPieces(JTextField textFieldNbDPieces) {
		this.textFieldNbDPieces = textFieldNbDPieces;
	}

	public JTextField getTextFieldBienLoauble() {
		return textFieldBienLoauble;
	}

	public void setTextFieldBienLoauble(JTextField textFieldBienLoauble) {
		this.textFieldBienLoauble = textFieldBienLoauble;
	}

	public JTextField getTextFieldBatiment() {
		return textFieldBatiment;
	}

	public void setTextFieldBatiment(JTextField textFieldBatiment) {
		this.textFieldBatiment = textFieldBatiment;
	}

	public JTextField getTextFieldDT() {
		return textFieldDT;
	}

	public void setTextFieldDT(JTextField textFieldDT) {
		this.textFieldDT = textFieldDT;
	}

	public JTextField getTextFieldTotalCharges() {
		return textFieldTotalCharges;
	}

	public void setTextFieldTotalCharges(JTextField textFieldTotalCharges) {
		this.textFieldTotalCharges = textFieldTotalCharges;
	}

	public JTextField getTextFieldDFC() {
		return textFieldDFC;
	}

	public void setTextFieldDFC(JTextField textFieldDFC) {
		this.textFieldDFC = textFieldDFC;
	}

	public JTextField getTextFieldDP() {
		return textFieldDP;
	}

	public void setTextFieldDP(JTextField textFieldDP) {
		this.textFieldDP = textFieldDP;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTable getTable() {
		return table;
	}

	public String getChosenBien() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			return table.getValueAt(selectedRow, 0).toString();
		}
		if (table.getRowCount() > 0) {
			return table.getValueAt(0, 0).toString();
		}
		return "";
	}

}
