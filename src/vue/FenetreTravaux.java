package vue;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreTravaux;

import javax.swing.JScrollPane;
import java.awt.Font;



public class FenetreTravaux extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private GestionFenetreTravaux gestionClic;
	private JMenu mnBatiment;
	private JMenuItem mntmTravaux;
	private JMenu mnPaiement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreTravaux frame = new FenetreTravaux();
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
	@SuppressWarnings("serial")
	public FenetreTravaux() {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreTravaux(this);
		setBounds(100, 100, 1200, 800);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel_11 = new JPanel();
        getContentPane().add(panel_11, BorderLayout.NORTH);
        panel_11.setLayout(new GridLayout(0, 1, 0, 0));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));
        panel_11.add(menuBar);

      //header
        JMenu mnProfil = new JMenu("Profil");
        menuBar.add(mnProfil);

        JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
        mntmDeconnecter.addActionListener(this.gestionClic);
        mnProfil.add(mntmDeconnecter);

        mnBatiment = new JMenu("Batiment");
        menuBar.add(mnBatiment);

        JMenuItem mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
        mntmAjouterBat.addActionListener(this.gestionClic);
        mnBatiment.add(mntmAjouterBat);

        JMenuItem mntmAssurance = new JMenuItem("Assurance");
        mntmAssurance.addActionListener(this.gestionClic);
        mnBatiment.add(mntmAssurance);

        JMenuItem mntmCompteur = new JMenuItem("Compteurs bâtiment");
        mntmCompteur.addActionListener(this.gestionClic);
        mnBatiment.add(mntmCompteur);

        JMenuItem mntmCharge = new JMenuItem("Charges bâtiment");
        mntmCharge.addActionListener(this.gestionClic);
        mnBatiment.add(mntmCharge);

        JMenu mnBienLouable = new JMenu("Bien louable");
        menuBar.add(mnBienLouable);

        JMenuItem mntmContratLocation = new JMenuItem("Contrat location");
        mntmContratLocation.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmContratLocation);

        JMenuItem mntmCompteurBL = new JMenuItem("Compteurs bien louable");
        mntmCompteurBL.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmCompteurBL);

        mntmTravaux = new JMenuItem("Travaux");
        mntmTravaux.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmTravaux);

        JMenuItem mntmChargesBL = new JMenuItem("Charges bien louable");
        mntmChargesBL.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmChargesBL);

        JMenuItem mntmDiagnostic = new JMenuItem("Diagnostics");
        mntmDiagnostic.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmDiagnostic);

        JMenuItem mntmLocataire = new JMenuItem("Locataires");
        mntmLocataire.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmLocataire);
        
        mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClic);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClic);
        mnPaiement.add(mntmAjout);
        this.gestionClic.initialize();

        JPanel panel_12 = new JPanel();
        getContentPane().add(panel_12, BorderLayout.SOUTH);

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(1500, 30));
        footerPanel.setBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));
        panel_12.add(footerPanel);

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        
        JButton btnAjouterTravaux = new JButton("Ajouter travaux");
        btnAjouterTravaux.addActionListener(this.gestionClic);
        panel_1.add(btnAjouterTravaux);
        
        JButton btnAjouterEntreprise = new JButton("Ajouter entreprise");
        btnAjouterEntreprise.addActionListener(this.gestionClic);
        panel_1.add(btnAjouterEntreprise);
        
        JButton btnGenFacture = new JButton("Générer facture");
        btnGenFacture.addActionListener(this.gestionClic);
        panel_1.add(btnGenFacture);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panel_1.add(btnRetour);
                
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Num\u00E9ro facture", "Montant", "Date de facture", "Compte bancaire", "Montant devis", "Date de paiement", "D\u00E9signation travaux", "Entreprise"
        	}
        ) {
        	@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
        		String.class, String.class, String.class, String.class, Float.class, String.class, String.class, String.class
        	};
        	@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(58);
        table.getColumnModel().getColumn(2).setPreferredWidth(91);
        table.addMouseListener(this.gestionClic);

        scrollPane.setViewportView(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JLabel lblTravaux = new JLabel("Travaux");
        lblTravaux.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(lblTravaux, BorderLayout.NORTH);


	}
	
	
	
	public void disableMenuItems(boolean actif) {
    	this.mnBatiment.setEnabled(actif);
    	this.mnPaiement.setEnabled(actif);
    	this.mntmTravaux.setEnabled(actif);

    }

	public JTable getTable() {
		return table;
	}
	

}
