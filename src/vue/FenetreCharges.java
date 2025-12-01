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
import javax.swing.table.DefaultTableModel;


import controleur.GestionFenetreCharges;


import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreCharges extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GestionFenetreCharges gestionClic;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCharges frame = new FenetreCharges();
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
	public FenetreCharges() {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreCharges(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);
		
		//header
        JMenu mnProfil = new JMenu("Profil");
        menuBar.add(mnProfil);

        JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
        mntmDeconnecter.addActionListener(this.gestionClic);
        mnProfil.add(mntmDeconnecter);

        JMenu mnBatiment = new JMenu("Batiment");
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

        JMenuItem mntmTravaux = new JMenuItem("Travaux");
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
        
        JMenu mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClic);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClic);
        mnPaiement.add(mntmAjout);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_1.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        		{null, null, null, null, null, null},
        	},
        	new String[] {
        		"Types charges", "Montant Total", "Pourcentage", "Quotite", "Montant ", "Mois"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, Float.class, Float.class, String.class, Object.class, Object.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(92);
        table.setEnabled(false);
        
        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this.gestionClic);
        
        JButton btnAjouter = new JButton("Ajouter charge");
        btnAjouter.addActionListener(this.gestionClic);
        panel_2.add(btnAjouter);
        panel_2.add(btnAnnuler);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panel_2.add(btnRetour);
        
        Component verticalStrut_1 = Box.createVerticalStrut(70);
        panel_2.add(verticalStrut_1);
        
        Panel Title = new Panel();
        panel_1.add(Title, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Charges");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        Title.add(lblTitre);
        
        Component verticalStrut = Box.createVerticalStrut(70);
        Title.add(verticalStrut);
        
        JPanel contentPane_1 = new JPanel();
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(contentPane_1, BorderLayout.SOUTH);
        contentPane_1.setLayout(new BorderLayout(0, 0));
        
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(584, 30));
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));
        contentPane_1.add(footerPanel, BorderLayout.NORTH);
        
        JLabel footerLabel = new JLabel("Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);
	}
	
}
