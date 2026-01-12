package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import controleur.GestionFenetrePrincipale;

public class FenetrePrincipale extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GestionFenetrePrincipale gestionClic;
	private JTable table;
	private JPanel panelRevenu;
	private JPanel panelNbLoyePasPaye;
	private JPanel panelSoldeNonPaye;
	private JPanel panelNbLoyePasPaye_1;
	private JButton btnImporter;
	private JLabel lblRevenu;
	private JLabel lblSolde;
	private JLabel lblPasPaye;
	private JLabel lblPasPaye_1;
	private JComboBox<String> cbBatiment;
	private JButton btnAjouterBien;

	/**
	 * Création de la vue 
	 */
	public FenetrePrincipale() {
		super();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelContent = new JPanel(); contentPane.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = new JPanel();
		panelContent.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));

		JPanel panelNorthCenter = new JPanel();
		panelNorth.add(panelNorthCenter);
		panelNorthCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component horizontalStrut = Box.createHorizontalStrut(10);
		panelNorthCenter.add(horizontalStrut);

		panelRevenu = new JPanel();
		FlowLayout fl_panelRevenu = (FlowLayout) panelRevenu.getLayout();
		fl_panelRevenu.setHgap(15);
		panelRevenu.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Location Cumul\u00E9e", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelRevenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelNorthCenter.add(panelRevenu);

		lblRevenu = new JLabel("180.000");
		lblRevenu.setBackground(Color.WHITE);
		lblRevenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelRevenu.add(lblRevenu);

		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		panelNorthCenter.add(horizontalStrut_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		panelNorthCenter.add(horizontalStrut_2);

		panelNbLoyePasPaye = new JPanel();
		FlowLayout fl_panelNbLoyePasPaye = (FlowLayout) panelNbLoyePasPaye.getLayout();
		fl_panelNbLoyePasPaye.setHgap(15);
		panelNbLoyePasPaye.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Taux d'occupation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNorthCenter.add(panelNbLoyePasPaye);

		lblPasPaye = new JLabel("      0      ");
		lblPasPaye.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelNbLoyePasPaye.add(lblPasPaye);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panelNorthCenter.add(horizontalStrut_3);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 10));

		JPanel panel = new JPanel();
		panelNorth.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		Component verticalStrut_1 = Box.createVerticalStrut(50);
		panel.add(verticalStrut_1, BorderLayout.NORTH);

		JPanel panelNorthCenter_1 = new JPanel();
		panel.add(panelNorthCenter_1, BorderLayout.CENTER);
		panelNorthCenter_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		panelNorthCenter_1.add(horizontalStrut_6);

		panelSoldeNonPaye = new JPanel();
		FlowLayout fl_panelSoldeNonPaye = (FlowLayout) panelSoldeNonPaye.getLayout();
		fl_panelSoldeNonPaye.setHgap(15);
		panelSoldeNonPaye.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Total Solde Non Pay\u00E9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSoldeNonPaye.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelNorthCenter_1.add(panelSoldeNonPaye);

		lblSolde = new JLabel("180.000\r\n");
		lblSolde.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelSoldeNonPaye.setPreferredSize(new Dimension(180, 70));
		panelSoldeNonPaye.add(lblSolde);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(40);
		panelNorthCenter_1.add(horizontalStrut_1_1);

		Component horizontalStrut_2_1 = Box.createHorizontalStrut(40);
		panelNorthCenter_1.add(horizontalStrut_2_1);

		panelNbLoyePasPaye_1 = new JPanel();
		FlowLayout fl_panelNbLoyePasPaye_1 = (FlowLayout) panelNbLoyePasPaye_1.getLayout();
		fl_panelNbLoyePasPaye_1.setHgap(15);
		panelNbLoyePasPaye_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Contrats expirant ce mois", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNorthCenter_1.add(panelNbLoyePasPaye_1);

		lblPasPaye_1 = new JLabel("      8      ");
		lblPasPaye_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panelNbLoyePasPaye_1.setPreferredSize(new Dimension(180, 70));
		panelNbLoyePasPaye_1.add(lblPasPaye_1);

		Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
		panelNorthCenter_1.add(horizontalStrut_3_1);

		Component verticalStrut_2 = Box.createVerticalStrut(50);
		verticalStrut_2.setPreferredSize(new Dimension(0, 10));

		verticalStrut_2.setPreferredSize(new Dimension(0, 15));
		panel.add(verticalStrut_2, BorderLayout.SOUTH);

		JPanel panelSouth = new JPanel();
		panelContent.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setLayout(new BorderLayout(0, 0));

		JPanel panelSouthWest = new JPanel();
		panelSouth.add(panelSouthWest, BorderLayout.WEST);

		JButton btnQuitter = new JButton("Quitter");
		panelSouthWest.add(btnQuitter);

		JPanel panelSouthEast = new JPanel();
		panelSouth.add(panelSouthEast, BorderLayout.EAST);

		JButton btnAjouterIRL = new JButton("Ajouter IRL");

		panelSouthEast.add(btnAjouterIRL);

		btnAjouterBien = new JButton("Ajouter Bien");
		panelSouthEast.add(btnAjouterBien);
		btnAjouterBien.setVisible(false);

		JButton btnCharges = new JButton("Charges");
		panelSouthEast.add(btnCharges);

		JButton btnCompteurs = new JButton("Compteurs");
		panelSouthEast.add(btnCompteurs);

		JButton btnAssurance = new JButton("Assurance");
		panelSouthEast.add(btnAssurance);

		JButton btnRetirer = new JButton("Retirer");
		panelSouthEast.add(btnRetirer);

		btnImporter = new JButton("Importer Un Fichier CSV");
		panelSouthEast.add(btnImporter);

		JPanel panelCenter = new JPanel();
		panelContent.add(panelCenter);
		panelCenter.setLayout(new BorderLayout(0, 0));

		JPanel panelCenterCenter = new JPanel();
		panelCenter.add(panelCenterCenter);
		panelCenterCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelCenterCenter.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		getTableBienLouable().setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Contrat Location", "Nombre de piece", "Bien Louable", "Locataire R\u00E9f\u00E9rent"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(getTableBienLouable());

		JPanel panelCenterNorth = new JPanel();
		panelCenter.add(panelCenterNorth, BorderLayout.NORTH);
		panelCenterNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cbBatiment = new JComboBox<String>();
		cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCenterNorth.add(cbBatiment);

		JButton btnAjouterBatiment = new JButton("Ajouter");
		btnAjouterBatiment.setFont(new Font("Tahoma", Font.BOLD, 10));
		panelCenterNorth.add(btnAjouterBatiment);

		JPanel panelChart = new JPanel();
		panelCenter.add(panelChart, BorderLayout.SOUTH);

		JPanel panelMenuBar = new JPanel();
		contentPane.add(panelMenuBar, BorderLayout.NORTH);
		panelMenuBar.setLayout(new GridLayout(0, 1, 0, 0));

		// Création du header
		this.setJMenuBar(createHeader());
		JPanel panelFooter = new JPanel();
		contentPane.add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new GridLayout(1, 0, 0, 0));
		panelFooter.add(createFooter());

		Component horizontalStrut_4 = Box.createHorizontalStrut(10);
		horizontalStrut_4.setPreferredSize(new Dimension(10, 0));
		contentPane.add(horizontalStrut_4, BorderLayout.WEST);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(10, 0));
		contentPane.add(horizontalStrut_5, BorderLayout.EAST);

		this.setPreferredSize(new Dimension(1200, 800));
		this.setMinimumSize(new Dimension(1200, 800));
		this.setMaximumSize(new Dimension(1200, 800));
		this.setSize(new Dimension(1200, 800));
		this.pack();
		this.setLocationRelativeTo(null);

		gestionClic = new GestionFenetrePrincipale(this);
		panelRevenu.addMouseListener(this.gestionClic);
		panelNbLoyePasPaye.addMouseListener(this.gestionClic);
		panelSoldeNonPaye.addMouseListener(this.gestionClic);
		panelNbLoyePasPaye_1.addMouseListener(this.gestionClic);
		btnQuitter.addActionListener(this.gestionClic);
		btnAjouterIRL.addActionListener(this.gestionClic);
		btnAssurance.addActionListener(this.gestionClic);
		btnCompteurs.addActionListener(this.gestionClic);
		btnCharges.addActionListener(this.gestionClic);
		btnImporter.addActionListener(this.gestionClic);
		btnAjouterBatiment.addActionListener(this.gestionClic);
		cbBatiment.addActionListener(this.gestionClic);
		this.gestionClic.remplirStatistiques();
		gestionClic.remplirComboBatiment();
		gestionClic.remplirTableau();
		table.addMouseListener(this.gestionClic);
		btnRetirer.addActionListener(this.gestionClic);
		btnAjouterBien.addActionListener(this.gestionClic);
		gestionClic.initialize();

	}

	/**
	 * Retourne le bouton permettant d'ajouter un bien louable.
	 *
	 * @return le bouton "Ajouter Bien"
	 */
	public JButton getBtnAjouterBien() {
	    return btnAjouterBien;
	}

	/**
	 * Définit le bouton permettant d'ajouter un bien louable.
	 *
	 * @param btnAjouterBien le bouton à définir
	 */
	public void setBtnAjouterBien(JButton btnAjouterBien) {
	    this.btnAjouterBien = btnAjouterBien;
	}

	/**
	 * Retourne le bâtiment sélectionné dans la ComboBox.
	 * Si aucun élément n'est sélectionné, le premier élément est retourné.
	 *
	 * @return le nom du bâtiment sélectionné
	 */
	public String getChosenBatiment() {
	    if (cbBatiment.getSelectedItem() == null) {
	        return cbBatiment.getItemAt(0);
	    }
	    return cbBatiment.getSelectedItem().toString();
	}

	/**
	 * Retourne la table principale affichant les données.
	 *
	 * @return la JTable principale
	 */
	public JTable getTable() {
	    return this.table;
	}

	/**
	 * Retourne le menu "Bien Louable".
	 *
	 * @return le menu des biens louables
	 */
	public JMenu getMnBienLouable() {
	    return mnBienLouable;
	}

	/**
	 * Retourne le panneau affichant les revenus.
	 *
	 * @return le panel des revenus
	 */
	public JPanel getPanelRevenu() {
	    return this.panelRevenu;
	}

	/**
	 * Retourne le panneau affichant le nombre de loyers non payés.
	 *
	 * @return le panel des loyers non payés
	 */
	public JPanel getPanelNbLoyerPasPaye() {
	    return this.panelNbLoyePasPaye;
	}

	/**
	 * Retourne le panneau affichant le solde non payé.
	 *
	 * @return le panel du solde non payé
	 */
	public JPanel getPanelRevenu_1() {
	    return this.panelSoldeNonPaye;
	}

	/**
	 * Retourne le panneau affichant le nombre de loyers non payés (version secondaire).
	 *
	 * @return le panel correspondant
	 */
	public JPanel getPanelNbLoyePasPaye_1() {
	    return this.panelNbLoyePasPaye_1;
	}

	/**
	 * Retourne la table des biens louables.
	 *
	 * @return la JTable des biens louables
	 */
	public JTable getTableBienLouable() {
	    return table;
	}

	/**
	 * Retourne le label affichant le revenu.
	 *
	 * @return le label du revenu
	 */
	public JLabel getLblRevenu() {
	    return lblRevenu;
	}

	/**
	 * Définit le label du revenu.
	 *
	 * @param lblRevenu le label à définir
	 */
	public void setLblRevenu(JLabel lblRevenu) {
	    this.lblRevenu = lblRevenu;
	}

	/**
	 * Retourne le label affichant le solde.
	 *
	 * @return le label du solde
	 */
	public JLabel getLblRevenu_1() {
	    return lblSolde;
	}

	/**
	 * Définit le label du solde.
	 *
	 * @param lblRevenu_1 le label à définir
	 */
	public void setLblRevenu_1(JLabel lblRevenu_1) {
	    this.lblSolde = lblRevenu_1;
	}

	/**
	 * Retourne le label du solde.
	 *
	 * @return le label du solde
	 */
	public JLabel getLblSolde() {
	    return lblSolde;
	}

	/**
	 * Définit le label du solde.
	 *
	 * @param lblSolde le label à définir
	 */
	public void setLblSolde(JLabel lblSolde) {
	    this.lblSolde = lblSolde;
	}

	/**
	 * Retourne le label indiquant le montant non payé.
	 *
	 * @return le label "pas payé"
	 */
	public JLabel getLblPasPaye() {
	    return lblPasPaye;
	}

	/**
	 * Définit le label indiquant le montant non payé.
	 *
	 * @param lblPasPaye le label à définir
	 */
	public void setLblPasPaye(JLabel lblPasPaye) {
	    this.lblPasPaye = lblPasPaye;
	}

	/**
	 * Retourne le label indiquant le montant non payé (version secondaire).
	 *
	 * @return le label correspondant
	 */
	public JLabel getLblPasPaye_1() {
	    return lblPasPaye_1;
	}

	/**
	 * Définit le label indiquant le montant non payé (version secondaire).
	 *
	 * @param lblPasPaye_1 le label à définir
	 */
	public void setLblPasPaye_1(JLabel lblPasPaye_1) {
	    this.lblPasPaye_1 = lblPasPaye_1;
	}

	/**
	 * Définit la table principale.
	 *
	 * @param table la JTable à définir
	 */
	public void setTable(JTable table) {
	    this.table = table;
	}

	/**
	 * Retourne la ComboBox permettant de sélectionner un bâtiment.
	 *
	 * @return la ComboBox des bâtiments
	 */
	public JComboBox<String> getCbBatiment() {
	    return cbBatiment;
	}


}
