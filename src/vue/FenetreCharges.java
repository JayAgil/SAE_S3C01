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


public class FenetreCharges extends FenetreBase {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GestionFenetreCharges gestionClic;
	private String fenetreAvant;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreCharges frame = new FenetreCharges("");
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
	public FenetreCharges(String FenetreAvant) {
		super();
    	this.fenetreAvant = FenetreAvant;
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.gestionClic = new GestionFenetreCharges(this);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(214, 214, 214));
		setJMenuBar(menuBar);
		
		//header
       this.setJMenuBar(createHeader());

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
        this.gestionClic.initialize();
        
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
        
        
        contentPane_1.add(createFooter(), BorderLayout.NORTH);
        
      
	}
	
	@Override
    public void disableMenuItems(boolean actif) {
		this.mnPaiement.setEnabled(actif);

    	if (this.fenetreAvant == "FenetrePrincipale"){
    			this.mnBienLouable.setEnabled(actif);
    			this.mnPaiement.setEnabled(actif);
    			this.mntmAjouterBat.setEnabled(actif);
    			mntmCharge.setEnabled(actif);
    	}
    	if (this.fenetreAvant == "FenetreBienLouable"){
			this.mntmChargesBL.setEnabled(actif);
			this.mnBatiment.setEnabled(actif);	
	}
    	
    }
	public String getFenetreAvant() {
		return fenetreAvant;
	}

	
}
