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
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
	
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
        
        Component verticalStrut_1 = Box.createVerticalStrut(40);
        panel.add(verticalStrut_1);
        btnCompteur.addActionListener(gestionClicBienLouable);
        
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
        
        JPanel panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{83, 0, 0};
        gbl_panel_1.rowHeights = new int[]{21, 0, 0, 21, 0, 0, 0, 0, 0, 0, 21, 0, 0, 0, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0};
        panel_1.setLayout(gbl_panel_1);
        
        
        JButton btnDiagnostic = new JButton("Diagnostics");
        GridBagConstraints gbc_btnDiagnostic = new GridBagConstraints();
        gbc_btnDiagnostic.insets = new Insets(0, 0, 5, 0);
        gbc_btnDiagnostic.gridwidth = 3;
        gbc_btnDiagnostic.gridheight = 13;
        gbc_btnDiagnostic.anchor = GridBagConstraints.NORTH;
        gbc_btnDiagnostic.weighty = 1.0;
        gbc_btnDiagnostic.weightx = 1.0;
        gbc_btnDiagnostic.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDiagnostic.gridx = 0;
        gbc_btnDiagnostic.gridy = 0;
        panel_1.add(btnDiagnostic, gbc_btnDiagnostic);
        btnDiagnostic.addActionListener(gestionClicBienLouable);
        
        Component verticalStrut_2 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
        gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_2.gridx = 2;
        gbc_verticalStrut_2.gridy = 2;
        panel_1.add(verticalStrut_2, gbc_verticalStrut_2);
        
        JButton btnTravaux = new JButton("Travaux");
        GridBagConstraints gbc_btnTravaux = new GridBagConstraints();
        gbc_btnTravaux.insets = new Insets(0, 0, 5, 0);
        gbc_btnTravaux.gridheight = 10;
        gbc_btnTravaux.gridwidth = 3;
        gbc_btnTravaux.weighty = 1.0;
        gbc_btnTravaux.weightx = 1.0;
        gbc_btnTravaux.anchor = GridBagConstraints.NORTH;
        gbc_btnTravaux.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnTravaux.gridx = 0;
        gbc_btnTravaux.gridy = 3;
        panel_1.add(btnTravaux, gbc_btnTravaux);
        btnTravaux.addActionListener(gestionClicBienLouable);
        
        Component verticalStrut_3 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
        gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_3.gridx = 2;
        gbc_verticalStrut_3.gridy = 4;
        panel_1.add(verticalStrut_3, gbc_verticalStrut_3);
        
        JButton btnCharge = new JButton("Charges");
        GridBagConstraints gbc_btnCharge = new GridBagConstraints();
        gbc_btnCharge.insets = new Insets(0, 0, 5, 0);
        gbc_btnCharge.gridheight = 9;
        gbc_btnCharge.gridwidth = 3;
        gbc_btnCharge.weighty = 1.0;
        gbc_btnCharge.weightx = 1.0;
        gbc_btnCharge.anchor = GridBagConstraints.NORTH;
        gbc_btnCharge.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCharge.gridx = 0;
        gbc_btnCharge.gridy = 5;
        panel_1.add(btnCharge, gbc_btnCharge);
        btnCharge.addActionListener(gestionClicBienLouable);
        
        Component verticalStrut_4 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
        gbc_verticalStrut_4.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_4.gridx = 2;
        gbc_verticalStrut_4.gridy = 6;
        panel_1.add(verticalStrut_4, gbc_verticalStrut_4);
        
        Component verticalStrut_5 = Box.createVerticalStrut(20);
        GridBagConstraints gbc_verticalStrut_5 = new GridBagConstraints();
        gbc_verticalStrut_5.insets = new Insets(0, 0, 5, 0);
        gbc_verticalStrut_5.gridx = 2;
        gbc_verticalStrut_5.gridy = 7;
        panel_1.add(verticalStrut_5, gbc_verticalStrut_5);
        
        JButton btnContrat = new JButton("Contrat");
        GridBagConstraints gbc_btnContrat = new GridBagConstraints();
        gbc_btnContrat.gridwidth = 3;
        gbc_btnContrat.gridheight = 0;
        gbc_btnContrat.weighty = 1.0;
        gbc_btnContrat.weightx = 1.0;
        gbc_btnContrat.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnContrat.anchor = GridBagConstraints.NORTH;
        gbc_btnContrat.gridx = 0;
        gbc_btnContrat.gridy = 9;
        panel_1.add(btnContrat, gbc_btnContrat);
        
        Panel Title = new Panel();
        panel_2.add(Title, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Biens louables ");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        Title.add(lblTitre);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        Title.add(verticalStrut);
        btnContrat.addActionListener(gestionClicBienLouable);

	}
	
}
