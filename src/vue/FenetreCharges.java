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
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


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

	    // Header
	    this.setJMenuBar(createHeader());

	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 1200, 800);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new BorderLayout(0, 0));
	    setContentPane(contentPane);

	    // Main panel with BorderLayout
	    JPanel mainPanel = new JPanel(new BorderLayout(0, 0));
	    contentPane.add(mainPanel, BorderLayout.CENTER);

	    // Top panel (e.g., title or summary)
	    JPanel topPanel = new JPanel();
	    JLabel lblTitre = new JLabel("Charges");
	    lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
	    topPanel.add(lblTitre);
	    mainPanel.add(topPanel, BorderLayout.NORTH);

	    // Center panel to hold the table and scroll pane
	    JPanel tablePanel = new JPanel();
	    mainPanel.add(tablePanel, BorderLayout.CENTER);
	    tablePanel.setLayout(new GridLayout(2, 1, 0, 0));

	    // Scroll pane and table
	    JScrollPane scrollPane = new JScrollPane();
	    tablePanel.add(scrollPane);

	    table = new JTable();
	    scrollPane.setViewportView(table);
	    table.setModel(new DefaultTableModel(
	            new Object[16][6], // your placeholder data
	            new String[] { "Types charges", "Montant Total", "Pourcentage", "Quotite", "Montant", "Mois" }
	    ) {
	        Class[] columnTypes = new Class[] { String.class, Float.class, Float.class, String.class, Object.class, Object.class };
	        public Class getColumnClass(int columnIndex) {
	            return columnTypes[columnIndex];
	        }
	    });
	    table.getColumnModel().getColumn(0).setPreferredWidth(92);
	    table.setEnabled(false);
	    
	    JPanel panel = new JPanel();
	    tablePanel.add(panel);
	    panel.setLayout(new GridLayout(1, 3, 0, 0));
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Type Charges", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.add(panel_1);
	    panel_1.setLayout(new GridLayout(3, 0, 0, 0));
	    
	    JPanel panel_8 = new JPanel();
	    panel_1.add(panel_8);
	    panel_8.setLayout(new BorderLayout(0, 0));
	    
	    JLabel imageEntretien = new JLabel("Entretien : ");
	    panel_8.add(imageEntretien, BorderLayout.NORTH);
	    
	    JPanel panel_9 = new JPanel();
	    panel_1.add(panel_9);
	    panel_9.setLayout(new BorderLayout(0, 0));
	    
	    JLabel imageNettoyage = new JLabel("Nettoyage : ");
	    panel_9.add(imageNettoyage, BorderLayout.NORTH);
	    
	    JPanel panel_7 = new JPanel();
	    panel_1.add(panel_7);
	    panel_7.setLayout(new BorderLayout(0, 0));
	    
	    JLabel imageAscenceur = new JLabel("Ascenceur : ");
	    panel_7.add(imageAscenceur, BorderLayout.NORTH);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Trois Batiments Avec Les Plus Haut Charges", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.add(panel_2);
	    panel_2.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel_2.add(panel_5);
	    panel_5.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel_1 = new JLabel("  Première : ");
	    panel_5.add(lblNewLabel_1, BorderLayout.NORTH);
	    
	    JLabel lblNewLabel_4_3 = new JLabel("Bien 2");
	    lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_5.add(lblNewLabel_4_3, BorderLayout.CENTER);
	    
	    JPanel panel_6 = new JPanel();
	    panel_6.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel_2.add(panel_6);
	    panel_6.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel_2 = new JLabel("Seconde: ");
	    panel_6.add(lblNewLabel_2, BorderLayout.NORTH);
	    
	    JLabel lblNewLabel_4_4 = new JLabel("Bien 8");
	    lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_6.add(lblNewLabel_4_4, BorderLayout.CENTER);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    panel_2.add(panel_4);
	    panel_4.setLayout(new BorderLayout(0, 0));
	    
	    JLabel lblNewLabel_3 = new JLabel("Troisième: ");
	    panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
	    
	    JLabel lblNewLabel_4_5 = new JLabel("Bien 4");
	    lblNewLabel_4_5.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.CENTER);
	    panel_4.add(lblNewLabel_4_5, BorderLayout.CENTER);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Charges Moyen Par Bien", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.add(panel_3);
	    
	    JLabel lblNewLabel = new JLabel("\r\n238");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 99));
	    panel_3.add(lblNewLabel);

	    // Bottom panel for buttons
	    JPanel buttonPanel = new JPanel();
	    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

	    JButton btnAjouter = new JButton("Ajouter charge");
	    btnAjouter.addActionListener(this.gestionClic);
	    buttonPanel.add(btnAjouter);

	    JButton btnAnnuler = new JButton("Annuler");
	    btnAnnuler.addActionListener(this.gestionClic);
	    buttonPanel.add(btnAnnuler);

	    JButton btnRetour = new JButton("Retour");
	    btnRetour.addActionListener(this.gestionClic);
	    buttonPanel.add(btnRetour);

	    this.gestionClic.initialize();

	    // Footer panel (if needed)
	    JPanel footerPanel = new JPanel(new BorderLayout());
	    contentPane.add(footerPanel, BorderLayout.SOUTH);
	    footerPanel.add(createFooter(), BorderLayout.NORTH);
	    
        ImageIcon entretienIcon = new ImageIcon("img/entretien.png");
        Image imgentretien = entretienIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        imageEntretien.setIcon(new ImageIcon(imgentretien));
        imageEntretien.setHorizontalAlignment(JLabel.LEFT);
        
        JLabel lblNewLabel_4 = new JLabel("200");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        panel_8.add(lblNewLabel_4, BorderLayout.CENTER);
        
        ImageIcon nettoyageIcom = new ImageIcon("img/nettoyage.png");
        Image imgNettoyage = nettoyageIcom.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        imageNettoyage.setIcon(new ImageIcon(imgNettoyage));
        imageNettoyage.setHorizontalAlignment(JLabel.LEFT);
        
        JLabel lblNewLabel_4_1 = new JLabel("300");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_9.add(lblNewLabel_4_1, BorderLayout.CENTER);
        
        ImageIcon lifticon = new ImageIcon("img/lift.png");
        Image imglift = lifticon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        imageAscenceur.setIcon(new ImageIcon(imglift));
        imageAscenceur.setHorizontalAlignment(JLabel.LEFT);
        
        JLabel lblNewLabel_4_2 = new JLabel("250");
        lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
        panel_7.add(lblNewLabel_4_2, BorderLayout.CENTER);
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
