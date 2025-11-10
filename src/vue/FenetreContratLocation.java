package vue;

import controleur.GestionFenetreContratLocation;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreBienLouable;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.Panel;

public class FenetreContratLocation extends JInternalFrame {
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
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);
		
		JMenu mnProfil = new JMenu("Profil");
		menuBar.add(mnProfil);
		
		JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
		mnProfil.add(mntmDeconnecter);
		
		JMenu mnBatiment = new JMenu("Batiment");
		menuBar.add(mnBatiment);
		
		JMenuItem mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
		mnBatiment.add(mntmAjouterBat);
		
		JMenuItem mntmSupprimerBat = new JMenuItem("Supprimer bâtiment");
		mnBatiment.add(mntmSupprimerBat);
		
		JMenuItem mntmAssurance = new JMenuItem("Assurance");
		mnBatiment.add(mntmAssurance);
		
		JMenuItem mntmCompteur = new JMenuItem("Compteurs");
		mnBatiment.add(mntmCompteur);
		
		JMenuItem mntmCharge = new JMenuItem("Charges");
		mnBatiment.add(mntmCharge);
		
		JMenu mnBienLouable = new JMenu("Bien louable");
		menuBar.add(mnBienLouable);
		
		JMenuItem mntmContratLocation = new JMenuItem("Contrat location");
		mnBienLouable.add(mntmContratLocation);
		
		JMenuItem mntmCompteurBL = new JMenuItem("Compteurs");
		mnBienLouable.add(mntmCompteurBL);
		
		JMenuItem mntmTravaux = new JMenuItem("Travaux");
		mnBienLouable.add(mntmTravaux);
		
		JMenuItem mntmChargesBL = new JMenuItem("Charges");
		mnBienLouable.add(mntmChargesBL);
		
		JMenuItem mntmDiagnostic = new JMenuItem("Diagnostics");
		mnBienLouable.add(mntmDiagnostic);
		
		JMenuItem mntmLocataire = new JMenuItem("Locataires");
		mnBienLouable.add(mntmLocataire);
		
		JMenu mnPaiement = new JMenu("Paiement");
		menuBar.add(mnPaiement);
		
		JMenuItem mntmHistorique = new JMenuItem("Historique De Paiements");
		mnPaiement.add(mntmHistorique);
		
		JMenuItem mntmAjout = new JMenuItem("Ajouter Paiement");
		mnPaiement.add(mntmAjout);
		
		this.gestionClicContratLocation = new GestionFenetreContratLocation(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		
		/*footer*/
		
		JButton btnNewButton_1 = new JButton("Annuler");
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(gestionClicContratLocation);
		JPanel footerPanel = new JPanel();
		
		
		
		
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY)); // thin line on top
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
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Num\u00E9ro de contrat", "Date d\u00E9but", "Date fin", "Montant de caution", "Provision charge", "Solde", "Montant Mensuel", "Date versement", "Index Compteur eau", "Indexe compteur \u00E9lectricit\u00E9"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		true, true, true, true, true, true, true, true, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        
        Panel Title_1 = new Panel();
        panel_1.add(Title_1, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Contrats de locations :");
        Title_1.add(lblNewLabel_1_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);
        
        JButton btnNewButton_2 = new JButton("Ajouter");
        panel_2.add(btnNewButton_2);
        
        JButton btnNewButtonAnnuler = new JButton("Annuler");
        btnNewButtonAnnuler.addActionListener(gestionClicContratLocation);
        panel_2.add(btnNewButtonAnnuler);
        table.getColumnModel().getColumn(8).setResizable(false);
        table.getColumnModel().getColumn(9).setResizable(false);
	}
	
	
	

}

