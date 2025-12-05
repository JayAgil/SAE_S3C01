package vue;

import controleur.GestionFenetreContratLocation;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class FenetreContratLocation extends FenetreBase {
	private GestionFenetreContratLocation gestionClicContratLocation;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNomLoc;
	private JTextField textFieldNdC;
	private JTextField textFieldPeriode;
	private JTextField textFieldMontantC;
	private JTextField textFieldProvCharge;
	private JTextField textFieldCptEau;
	private JTextField textFieldLoyerMen;
	private JTextField textFieldCptElec;
	private JTextField textFieldCptGaz;
	private JTextField textFieldSolde;
	private JMenu mnBatiment;
	private JMenu mnPaiement;
	private JMenuItem mntmContratLocation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreContratLocation frame = new FenetreContratLocation();
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
	public FenetreContratLocation() {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClicContratLocation = new GestionFenetreContratLocation(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);
		
		//header
        JMenu mnProfil = new JMenu("Profil");
        menuBar.add(mnProfil);

        JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
        mntmDeconnecter.addActionListener(this.gestionClicContratLocation);
        mnProfil.add(mntmDeconnecter);

        mnBatiment = new JMenu("Batiment");
        menuBar.add(mnBatiment);

        JMenuItem mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
        mntmAjouterBat.addActionListener(this.gestionClicContratLocation);
        mnBatiment.add(mntmAjouterBat);

        JMenuItem mntmAssurance = new JMenuItem("Assurance");
        mntmAssurance.addActionListener(this.gestionClicContratLocation);
        mnBatiment.add(mntmAssurance);

        JMenuItem mntmCompteur = new JMenuItem("Compteurs bâtiment");
        mntmCompteur.addActionListener(this.gestionClicContratLocation);
        mnBatiment.add(mntmCompteur);

        JMenuItem mntmCharge = new JMenuItem("Charges bâtiment");
        mntmCharge.addActionListener(this.gestionClicContratLocation);
        mnBatiment.add(mntmCharge);

        JMenu mnBienLouable = new JMenu("Bien louable");
        menuBar.add(mnBienLouable);

        mntmContratLocation = new JMenuItem("Contrat location");
        mntmContratLocation.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmContratLocation);

        JMenuItem mntmCompteurBL = new JMenuItem("Compteurs bien louable");
        mntmCompteurBL.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmCompteurBL);

        JMenuItem mntmTravaux = new JMenuItem("Travaux");
        mntmTravaux.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmTravaux);

        JMenuItem mntmChargesBL = new JMenuItem("Charges bien louable");
        mntmChargesBL.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmChargesBL);

        JMenuItem mntmDiagnostic = new JMenuItem("Diagnostics");
        mntmDiagnostic.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmDiagnostic);

        JMenuItem mntmLocataire = new JMenuItem("Locataires");
        mntmLocataire.addActionListener(this.gestionClicContratLocation);
        mnBienLouable.add(mntmLocataire);
        
        mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClicContratLocation);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClicContratLocation);
        mnPaiement.add(mntmAjout);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		this.gestionClicContratLocation.initialize();
		
		//footer
		JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214)); 
        footerPanel.setPreferredSize(new Dimension(584, 30));

        JLabel footerLabel = new JLabel("Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        
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
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(this.gestionClicContratLocation);
        panel_2.add(btnAjouter);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(gestionClicContratLocation);
        panel_2.add(btnAnnuler);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClicContratLocation);
        panel_2.add(btnRetour);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        GridBagLayout gbl_panel_3 = new GridBagLayout();
        gbl_panel_3.columnWidths = new int[]{1176, 0};
        gbl_panel_3.rowHeights = new int[] {430, 250, 0, 40};
        gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        panel_3.setLayout(gbl_panel_3);
        
        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 0;
        panel_3.add(panel_4, gbc_panel_4);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.rowHeights = new int[] {25, 35, 35, 35, 35, 35, 35, 35, 40};
        gbl_panel_4.columnWidths = new int[] {350, 626, 200};
        gbl_panel_4.columnWeights = new double[]{Double.MIN_VALUE, 1.0};
        gbl_panel_4.rowWeights = new double[]{};
        panel_4.setLayout(gbl_panel_4);
        
        JLabel labelNom = new JLabel("Nom : ");
        GridBagConstraints gbc_labelNom = new GridBagConstraints();
        gbc_labelNom.insets = new Insets(0, 0, 5, 5);
        gbc_labelNom.gridx = 0;
        gbc_labelNom.gridy = 0;
        panel_4.add(labelNom, gbc_labelNom);
        
        textFieldNomLoc = new JTextField();
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
        gbc_lblNC.insets = new Insets(0, 0, 5, 5);
        gbc_lblNC.gridx = 0;
        gbc_lblNC.gridy = 1;
        panel_4.add(lblNC, gbc_lblNC);
        
        textFieldNdC = new JTextField();
        textFieldNdC.setEditable(false);
        GridBagConstraints gbc_textFieldNdC = new GridBagConstraints();
        gbc_textFieldNdC.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNdC.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNdC.gridx = 1;
        gbc_textFieldNdC.gridy = 1;
        panel_4.add(textFieldNdC, gbc_textFieldNdC);
        textFieldNdC.setColumns(10);
        
        JLabel lblValidite = new JLabel("Validite de contrat : ");
        GridBagConstraints gbc_lblValidite = new GridBagConstraints();
        gbc_lblValidite.insets = new Insets(0, 0, 5, 5);
        gbc_lblValidite.gridx = 0;
        gbc_lblValidite.gridy = 2;
        panel_4.add(lblValidite, gbc_lblValidite);
        
        textFieldPeriode = new JTextField();
        textFieldPeriode.setEditable(false);
        GridBagConstraints gbc_textFieldPeriode = new GridBagConstraints();
        gbc_textFieldPeriode.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldPeriode.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldPeriode.gridx = 1;
        gbc_textFieldPeriode.gridy = 2;
        panel_4.add(textFieldPeriode, gbc_textFieldPeriode);
        textFieldPeriode.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Montant de caution : ");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 3;
        panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        textFieldMontantC = new JTextField();
        textFieldMontantC.setEditable(false);
        GridBagConstraints gbc_textFieldMontantC = new GridBagConstraints();
        gbc_textFieldMontantC.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldMontantC.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldMontantC.gridx = 1;
        gbc_textFieldMontantC.gridy = 3;
        panel_4.add(textFieldMontantC, gbc_textFieldMontantC);
        textFieldMontantC.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Provision Charge : ");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 4;
        panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        textFieldProvCharge = new JTextField();
        textFieldProvCharge.setEditable(false);
        GridBagConstraints gbc_textFieldProvCharge = new GridBagConstraints();
        gbc_textFieldProvCharge.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldProvCharge.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldProvCharge.gridx = 1;
        gbc_textFieldProvCharge.gridy = 4;
        panel_4.add(textFieldProvCharge, gbc_textFieldProvCharge);
        textFieldProvCharge.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Loyer mensuel : ");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 5;
        panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);
        
        textFieldLoyerMen = new JTextField();
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
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 6;
        panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
        
        textFieldCptEau = new JTextField();
        textFieldCptEau.setEditable(false);
        GridBagConstraints gbc_textFieldCptEau = new GridBagConstraints();
        gbc_textFieldCptEau.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldCptEau.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldCptEau.gridx = 1;
        gbc_textFieldCptEau.gridy = 6;
        panel_4.add(textFieldCptEau, gbc_textFieldCptEau);
        textFieldCptEau.setColumns(10);
        
        JLabel lblNewLabel_6 = new JLabel("Index Compteur Electricite Ancien: : ");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 7;
        panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
        
        textFieldCptElec = new JTextField();
        textFieldCptElec.setEditable(false);
        GridBagConstraints gbc_textFieldCptElec = new GridBagConstraints();
        gbc_textFieldCptElec.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldCptElec.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldCptElec.gridx = 1;
        gbc_textFieldCptElec.gridy = 7;
        panel_4.add(textFieldCptElec, gbc_textFieldCptElec);
        textFieldCptElec.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("Index Compteur Gaz Ancien: : ");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 8;
        panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
        
        textFieldCptGaz = new JTextField();
        textFieldCptGaz.setEditable(false);
        GridBagConstraints gbc_textFieldCptGaz = new GridBagConstraints();
        gbc_textFieldCptGaz.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldCptGaz.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldCptGaz.gridx = 1;
        gbc_textFieldCptGaz.gridy = 8;
        panel_4.add(textFieldCptGaz, gbc_textFieldCptGaz);
        textFieldCptGaz.setColumns(10);
        
        JLabel lblNewLabel_8 = new JLabel("Solde : ");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 9;
        panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
        
        textFieldSolde = new JTextField();
        textFieldSolde.setEditable(false);
        GridBagConstraints gbc_textFieldSolde = new GridBagConstraints();
        gbc_textFieldSolde.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldSolde.gridx = 1;
        gbc_textFieldSolde.gridy = 9;
        panel_4.add(textFieldSolde, gbc_textFieldSolde);
        textFieldSolde.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        panel_3.add(scrollPane, gbc_scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Nom du locataire", "Numero De Contrat", "Date Fin", "Montant Mensuel", "Solde"
        	}
        ));
        scrollPane.setViewportView(table);
        
        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.fill = GridBagConstraints.BOTH;
        gbc_panel_5.gridx = 0;
        gbc_panel_5.gridy = 2;
        panel_3.add(panel_5, gbc_panel_5);
	}
	
	@Override
	public void disableMenuItems(boolean actif) {
		this.mnBatiment.setEnabled(actif);
		this.mnPaiement.setEnabled(actif);
		this.mntmContratLocation.setEnabled(actif);
	}
	
	
}

