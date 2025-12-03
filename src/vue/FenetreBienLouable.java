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

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

	
public class FenetreBienLouable extends FenetreBase {
	private GestionFenetreBienLouable gestionClicBienLouable;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnPaiement;
	private JMenu mnBatiment;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreBienLouable frame = new FenetreBienLouable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreBienLouable() {
		this.gestionClicBienLouable = new GestionFenetreBienLouable(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);
		
		//header
        JMenu mnProfil = new JMenu("Profil");
        menuBar.add(mnProfil);

        JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
        mntmDeconnecter.addActionListener(this.gestionClicBienLouable);
        mnProfil.add(mntmDeconnecter);

        mnBatiment = new JMenu("Batiment");
        menuBar.add(mnBatiment);

        JMenuItem mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
        mntmAjouterBat.addActionListener(this.gestionClicBienLouable);
        mnBatiment.add(mntmAjouterBat);

        JMenuItem mntmAssurance = new JMenuItem("Assurance");
        mntmAssurance.addActionListener(this.gestionClicBienLouable);
        mnBatiment.add(mntmAssurance);

        JMenuItem mntmCompteur = new JMenuItem("Compteurs bâtiment");
        mntmCompteur.addActionListener(this.gestionClicBienLouable);
        mnBatiment.add(mntmCompteur);

        JMenuItem mntmCharge = new JMenuItem("Charges bâtiment");
        mntmCharge.addActionListener(this.gestionClicBienLouable);
        mnBatiment.add(mntmCharge);

        JMenu mnBienLouable = new JMenu("Bien louable");
        menuBar.add(mnBienLouable);

        JMenuItem mntmContratLocation = new JMenuItem("Contrat location");
        mntmContratLocation.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmContratLocation);

        JMenuItem mntmCompteurBL = new JMenuItem("Compteurs bien louable");
        mntmCompteurBL.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmCompteurBL);

        JMenuItem mntmTravaux = new JMenuItem("Travaux");
        mntmTravaux.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmTravaux);

        JMenuItem mntmChargesBL = new JMenuItem("Charges bien louable");
        mntmChargesBL.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmChargesBL);

        JMenuItem mntmDiagnostic = new JMenuItem("Diagnostics");
        mntmDiagnostic.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmDiagnostic);

        JMenuItem mntmLocataire = new JMenuItem("Locataires");
        mntmLocataire.addActionListener(this.gestionClicBienLouable);
        mnBienLouable.add(mntmLocataire);
        
        mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClicBienLouable);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClicBienLouable);
        mnPaiement.add(mntmAjout);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
        this.gestionClicBienLouable.initialize();

		
		JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY)); 
        footerPanel.setBackground(new Color(214, 214, 214)); 
        footerPanel.setPreferredSize(new Dimension(584, 30));

        JLabel footerLabel = new JLabel("Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        
        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel_2.add(panel, BorderLayout.SOUTH);
        
        JButton btnRetour = new JButton("Retour");
        panel.add(btnRetour);
        btnRetour.addActionListener(gestionClicBienLouable);
        
        JButton btnRevaloriser = new JButton("Revaloriser");
        btnRevaloriser.addActionListener(this.gestionClicBienLouable);
        panel.add(btnRevaloriser);
        
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
        
        JButton btnContrat= new JButton("Contrat");
        btnContrat.addActionListener(this.gestionClicBienLouable);
        panel.add(btnContrat);
        
        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, BorderLayout.CENTER);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{1176, 0};
        gbl_panel_3.rowHeights = new int[] {450, 250, 0};
        gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel_3);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 0;
        panel_3.add(panel_4, gbc_panel_4);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.rowHeights = new int[] {0, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_panel_4.columnWidths = new int[] {350, 600, 200};
        gbl_panel_4.columnWeights = new double[]{0.0, 1.0};
        gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0};
        panel_4.setLayout(gbl_panel_4);
        
        JLabel lblNewLabel = new JLabel("Nom Locataire : ");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel_4.add(lblNewLabel, gbc_lblNewLabel);
        
        textFieldNom = new JTextField();
        textFieldNom.setEditable(false);
        GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
        gbc_textFieldNom.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNom.gridx = 1;
        gbc_textFieldNom.gridy = 0;
        panel_4.add(textFieldNom, gbc_textFieldNom);
        textFieldNom.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Loyer mensuel : ");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        textFieldLoyerMen = new JTextField();
        textFieldLoyerMen.setEditable(false);
        GridBagConstraints gbc_textFieldLoyerMen = new GridBagConstraints();
        gbc_textFieldLoyerMen.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldLoyerMen.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldLoyerMen.gridx = 1;
        gbc_textFieldLoyerMen.gridy = 1;
        panel_4.add(textFieldLoyerMen, gbc_textFieldLoyerMen);
        textFieldLoyerMen.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Numero Fiscale :");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textFieldNF = new JTextField();
        textFieldNF.setEditable(false);
        GridBagConstraints gbc_textFieldNF = new GridBagConstraints();
        gbc_textFieldNF.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNF.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNF.gridx = 1;
        gbc_textFieldNF.gridy = 2;
        panel_4.add(textFieldNF, gbc_textFieldNF);
        textFieldNF.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Adresse : ");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textFieldAdresse = new JTextField();
        textFieldAdresse.setEditable(false);
        GridBagConstraints gbc_textFieldAdresse = new GridBagConstraints();
        gbc_textFieldAdresse.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldAdresse.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldAdresse.gridx = 1;
        gbc_textFieldAdresse.gridy = 3;
        panel_4.add(textFieldAdresse, gbc_textFieldAdresse);
        textFieldAdresse.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Surface Habituable : ");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 4;
        panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textFieldSurfaceHab = new JTextField();
        textFieldSurfaceHab.setEditable(false);
        GridBagConstraints gbc_textFieldSurfaceHab = new GridBagConstraints();
        gbc_textFieldSurfaceHab.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldSurfaceHab.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSurfaceHab.gridx = 1;
        gbc_textFieldSurfaceHab.gridy = 4;
        panel_4.add(textFieldSurfaceHab, gbc_textFieldSurfaceHab);
        textFieldSurfaceHab.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Nombre de pieces : ");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 5;
        panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textFieldNbDPieces = new JTextField();
        textFieldNbDPieces.setEditable(false);
        GridBagConstraints gbc_textFieldNbDPieces = new GridBagConstraints();
        gbc_textFieldNbDPieces.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNbDPieces.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNbDPieces.gridx = 1;
        gbc_textFieldNbDPieces.gridy = 5;
        panel_4.add(textFieldNbDPieces, gbc_textFieldNbDPieces);
        textFieldNbDPieces.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Type bien louable : ");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 6;
        panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFieldBienLoauble = new JTextField();
        textFieldBienLoauble.setEditable(false);
        GridBagConstraints gbc_textFieldBienLoauble = new GridBagConstraints();
        gbc_textFieldBienLoauble.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldBienLoauble.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBienLoauble.gridx = 1;
        gbc_textFieldBienLoauble.gridy = 6;
        panel_4.add(textFieldBienLoauble, gbc_textFieldBienLoauble);
        textFieldBienLoauble.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Batiment : ");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 7;
        panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textFieldBatiment = new JTextField();
        textFieldBatiment.setEditable(false);
        GridBagConstraints gbc_textFieldBatiment = new GridBagConstraints();
        gbc_textFieldBatiment.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldBatiment.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldBatiment.gridx = 1;
        gbc_textFieldBatiment.gridy = 7;
        panel_4.add(textFieldBatiment, gbc_textFieldBatiment);
        textFieldBatiment.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Date de derniere travaux : ");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 8;
        panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        textFieldDT = new JTextField();
        textFieldDT.setEditable(false);
        GridBagConstraints gbc_textFieldDT = new GridBagConstraints();
        gbc_textFieldDT.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldDT.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDT.gridx = 1;
        gbc_textFieldDT.gridy = 8;
        panel_4.add(textFieldDT, gbc_textFieldDT);
        textFieldDT.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("Total Charges : ");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 9;
        panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);
        
        textFieldTotalCharges = new JTextField();
        textFieldTotalCharges.setEditable(false);
        GridBagConstraints gbc_textFieldTotalCharges = new GridBagConstraints();
        gbc_textFieldTotalCharges.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldTotalCharges.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldTotalCharges.gridx = 1;
        gbc_textFieldTotalCharges.gridy = 9;
        panel_4.add(textFieldTotalCharges, gbc_textFieldTotalCharges);
        textFieldTotalCharges.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("Date Fin de Contrat : ");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 10;
        panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);
        
        textFieldDFC = new JTextField();
        textFieldDFC.setEditable(false);
        GridBagConstraints gbc_textFieldDFC = new GridBagConstraints();
        gbc_textFieldDFC.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldDFC.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDFC.gridx = 1;
        gbc_textFieldDFC.gridy = 10;
        panel_4.add(textFieldDFC, gbc_textFieldDFC);
        textFieldDFC.setColumns(10);
        
        JLabel lblNewLabel_11 = new JLabel("Dernier Paiement : ");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 11;
        panel_4.add(lblNewLabel_11, gbc_lblNewLabel_11);
        
        textFieldDP = new JTextField();
        textFieldDP.setEditable(false);
        GridBagConstraints gbc_textFieldDP = new GridBagConstraints();
        gbc_textFieldDP.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldDP.gridx = 1;
        gbc_textFieldDP.gridy = 11;
        panel_4.add(textFieldDP, gbc_textFieldDP);
        textFieldDP.setColumns(10);
        
        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.fill = GridBagConstraints.BOTH;
        gbc_panel_5.gridx = 0;
        gbc_panel_5.gridy = 1;
        panel_3.add(panel_5, gbc_panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"Id Bien Louble", "Adresse", "Nombre Pieces", "Type Bien"
        	}
        ));
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
        
        JLabel lblTitre = new JLabel("Biens louables");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_1.add(lblTitre);

	}
	
	public JTable getTable() {
		return table;
	}
	
	@Override
    public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
    }
	
}
