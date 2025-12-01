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

public class FenetreContratLocation extends JFrame {
	private GestionFenetreContratLocation gestionClicContratLocation;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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

        JMenu mnBatiment = new JMenu("Batiment");
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

        JMenuItem mntmContratLocation = new JMenuItem("Contrat location");
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
        
        JMenu mnPaiement = new JMenu("Paiement");
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
        
        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Num\u00E9ro contrat", "Date d\u00E9but", "Date fin", "Montant caution", "Provision charge", "Solde", "Montant mensuel", "Date versement", "Index eau", "Index \u00E9lectricit\u00E9", "Index gaz"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class, String.class, Float.class, Float.class, Float.class, Float.class, String.class, Float.class, Float.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(87);
        table.getColumnModel().getColumn(1).setPreferredWidth(66);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(89);
        table.getColumnModel().getColumn(5).setPreferredWidth(45);
        table.getColumnModel().getColumn(6).setPreferredWidth(97);
        table.getColumnModel().getColumn(7).setPreferredWidth(89);
        table.getColumnModel().getColumn(8).setPreferredWidth(61);
        
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
	}
	
}

