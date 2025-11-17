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

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;

public class FenetreCharges extends JFrame implements ActionListener {

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
		
		/*---------------------------------------------------*/
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 726, 442);
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
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"Types charges", "Montant", "Pourcentage", "Quotite"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, Float.class, Float.class, String.class
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
        table.getColumnModel().getColumn(0).setPreferredWidth(92);
        table.setEnabled(false);
        
        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);
        
        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(this);
        panel_2.add(btnQuitter);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this);
        panel_2.add(btnRetour);
        
        Component verticalStrut_1 = Box.createVerticalStrut(70);
        panel_2.add(verticalStrut_1);
        
        Panel Title = new Panel();
        panel_1.add(Title, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Charges");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
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
	
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Retour" :
			break;
		case "Quitter" :
			break;
		}
		
	}
}
