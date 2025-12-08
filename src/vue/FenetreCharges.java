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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;


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
	    GridBagLayout gbl_panel_8 = new GridBagLayout();
	    gbl_panel_8.columnWidths = new int[]{0};
	    gbl_panel_8.rowHeights = new int[]{0};
	    gbl_panel_8.columnWeights = new double[]{Double.MIN_VALUE};
	    gbl_panel_8.rowWeights = new double[]{Double.MIN_VALUE};
	    panel_8.setLayout(gbl_panel_8);
	    
	    JPanel panel_9 = new JPanel();
	    panel_1.add(panel_9);
	    
	    JPanel panel_7 = new JPanel();
	    panel_1.add(panel_7);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Trois Batiments Avec Les Plus Haut Charges", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.add(panel_2);
	    panel_2.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    JPanel panel_5 = new JPanel();
	    panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    panel_2.add(panel_5);
	    
	    JPanel panel_6 = new JPanel();
	    panel_2.add(panel_6);
	    
	    JPanel panel_4 = new JPanel();
	    panel_2.add(panel_4);
	    panel_4.setLayout(new GridLayout(3, 1, 0, 0));
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Charges Moyen Par Bien", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    panel.add(panel_3);

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
