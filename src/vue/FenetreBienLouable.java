package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreBienLouable;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.Panel;
	
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
		
		/*--------------------------*/
		this.gestionClicBienLouable = new GestionFenetreBienLouable(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY)); // thin line on top
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
        
        JButton btnNewButtonQuitter = new JButton("Quitter");
        panel.add(btnNewButtonQuitter);
        btnNewButtonQuitter.addActionListener(gestionClicBienLouable);
        
        JButton btnNewButtonRevaloriser = new JButton("Revaloriser");
        panel.add(btnNewButtonRevaloriser);
        
        JButton btnNewButtonCompteur = new JButton("Compteur");
        panel.add(btnNewButtonCompteur);
        btnNewButtonCompteur.addActionListener(gestionClicBienLouable);
        
        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane);
        
        table = new JTable();
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
        	},
        	new String[] {
        		"ID", "Num\u00E9ro Fiscale", "Adresse", "Surface habitable", "Nb pi\u00E8ces", "Type de bien"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        
        JPanel panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{83, 0, 0};
        gbl_panel_1.rowHeights = new int[]{21, 21, 0, 0, 21, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
        panel_1.setLayout(gbl_panel_1);
        
        
        JButton btnNewButton_1_1 = new JButton("Diagnostics");
        GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
        gbc_btnNewButton_1_1.gridwidth = 3;
        gbc_btnNewButton_1_1.gridheight = 7;
        gbc_btnNewButton_1_1.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_1_1.weighty = 1.0;
        gbc_btnNewButton_1_1.weightx = 1.0;
        gbc_btnNewButton_1_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_1_1.gridx = 0;
        gbc_btnNewButton_1_1.gridy = 0;
        panel_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);
        btnNewButton_1_1.addActionListener(gestionClicBienLouable);
        
        JButton btnNewButton_1 = new JButton("Travaux");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.gridheight = 6;
        gbc_btnNewButton_1.gridwidth = 3;
        gbc_btnNewButton_1.weighty = 1.0;
        gbc_btnNewButton_1.weightx = 1.0;
        gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 1;
        panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
        btnNewButton_1.addActionListener(gestionClicBienLouable);
        
        JButton btnNewButton_2 = new JButton("Charges");
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.gridheight = 6;
        gbc_btnNewButton_2.gridwidth = 3;
        gbc_btnNewButton_2.weighty = 1.0;
        gbc_btnNewButton_2.weightx = 1.0;
        gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 2;
        panel_1.add(btnNewButton_2, gbc_btnNewButton_2);
        btnNewButton_2.addActionListener(gestionClicBienLouable);
        
        JButton btnNewButton = new JButton("Contrat");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 3;
        gbc_btnNewButton.gridheight = 0;
        gbc_btnNewButton.weighty = 1.0;
        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 3;
        panel_1.add(btnNewButton, gbc_btnNewButton);
        
        Panel Title = new Panel();
        panel_2.add(Title, BorderLayout.NORTH);
        
        JLabel lblNewLabel_1_1 = new JLabel("Biens louables :");
        Title.add(lblNewLabel_1_1);
        btnNewButton.addActionListener(gestionClicBienLouable);
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
}
