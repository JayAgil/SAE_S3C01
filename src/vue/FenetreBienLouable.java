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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	
public class FenetreBienLouable extends JFrame {
	private GestionFenetreBienLouable gestionClicBienLouable;
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

        JMenu mnBatiment = new JMenu("Batiment");
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
        
        JMenu mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClicBienLouable);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClicBienLouable);
        mnPaiement.add(mntmAjout);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
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
        btnCompteur.addActionListener(gestionClicBienLouable);
        
        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(this.gestionClicBienLouable);
        table.setEnabled(false);
        scrollPane.setRowHeaderView(table);
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
        		"ID", "Num\u00E9ro Fiscale", "Adresse", "Surface habitable", "Nb pi\u00E8ces", "Type de bien"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class, String.class, Float.class, Integer.class, String.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Biens louables");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_1.add(lblTitre);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(144);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getColumnModel().getColumn(5).setPreferredWidth(245);

	}
	
	public JTable getTable() {
		return table;
	}

}
