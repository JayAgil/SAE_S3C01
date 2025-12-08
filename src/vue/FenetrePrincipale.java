package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePrincipale;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class FenetrePrincipale extends FenetreBase {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionFenetrePrincipale gestionClic;
    private JTable table;
    private JPanel panelRevenu;
    private JPanel panelNbLoyePasPaye;
    private JPanel panelRevenu_1;
    private JPanel panelNbLoyePasPaye_1;
    private JButton btnImporter;
    
	public JMenu getMnBienLouable() {
		return mnBienLouable;
	}

	private JMenu mnBienLouable;
	private JMenu mnPaiement;
	private JMenuItem mntmAssurance;
	private JMenuItem mntmCompteur;
	private JMenuItem mntmCharge;
    
    public JPanel getPanelRevenu() {
    	return this.panelRevenu;
    }
    
    public JPanel getPanelNbLoyerPasPaye() {
    	return this.panelNbLoyePasPaye;
    }
    
    public JPanel getPanelRevenu_1() {
    	return this.panelRevenu_1;
    }
    
    public JPanel getPanelNbLoyePasPaye_1() {
    	return this.panelNbLoyePasPaye_1;
    }
    public JTable getTableBienLouable() {
        return table; 
    }
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetrePrincipale frame = new FenetrePrincipale();
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
	public FenetrePrincipale() {
		super();
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
        gestionClic = new GestionFenetrePrincipale(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelContent = new JPanel();
        contentPane.add(panelContent, BorderLayout.CENTER);
        panelContent.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panelContent.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new BorderLayout(0, 0));

        JPanel panelNorthCenter = new JPanel();
        panelNorth.add(panelNorthCenter);
        panelNorthCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        Component horizontalStrut = Box.createHorizontalStrut(10);
        panelNorthCenter.add(horizontalStrut);

        panelRevenu = new JPanel();
        panelRevenu.addMouseListener(this.gestionClic);
        FlowLayout fl_panelRevenu = (FlowLayout) panelRevenu.getLayout();
        fl_panelRevenu.setHgap(15);
        panelRevenu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Location Cumul\u00E9e", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelRevenu.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelNorthCenter.add(panelRevenu);

        JLabel lblRevenu = new JLabel("180.000");
        lblRevenu.setBackground(Color.WHITE);
        lblRevenu.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRevenu.add(lblRevenu);

        Component horizontalStrut_1 = Box.createHorizontalStrut(40);
        panelNorthCenter.add(horizontalStrut_1);

        Component horizontalStrut_2 = Box.createHorizontalStrut(40);
        panelNorthCenter.add(horizontalStrut_2);

        panelNbLoyePasPaye = new JPanel();
        panelNbLoyePasPaye.addMouseListener(this.gestionClic);
        FlowLayout fl_panelNbLoyePasPaye = (FlowLayout) panelNbLoyePasPaye.getLayout();
        fl_panelNbLoyePasPaye.setHgap(15);
        panelNbLoyePasPaye.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Taux d'occupation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelNorthCenter.add(panelNbLoyePasPaye);

        JLabel lblPasPaye = new JLabel("      0      ");
        lblPasPaye.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelNbLoyePasPaye.add(lblPasPaye);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        panelNorthCenter.add(horizontalStrut_3);


        Component verticalStrut = Box.createVerticalStrut(20);
        verticalStrut.setPreferredSize(new Dimension(0, 10));

        Component verticalStrut1 = Box.createVerticalStrut(10);
        panelNorth.add(verticalStrut, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panelNorth.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        Component verticalStrut_1 = Box.createVerticalStrut(50);
        panel.add(verticalStrut_1, BorderLayout.NORTH);

        JPanel panelNorthCenter_1 = new JPanel();
        panel.add(panelNorthCenter_1, BorderLayout.CENTER);
        panelNorthCenter_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        Component horizontalStrut_6 = Box.createHorizontalStrut(10);
        panelNorthCenter_1.add(horizontalStrut_6);

        panelRevenu_1 = new JPanel();
        panelRevenu_1.addMouseListener(this.gestionClic);
        FlowLayout fl_panelRevenu_1 = (FlowLayout) panelRevenu_1.getLayout();
        fl_panelRevenu_1.setHgap(15);
        panelRevenu_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Montant total impay\u00E9s", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelRevenu_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelNorthCenter_1.add(panelRevenu_1);

        JLabel lblRevenu_1 = new JLabel("180.000\r\n");
        lblRevenu_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelRevenu_1.add(lblRevenu_1);

        Component horizontalStrut_1_1 = Box.createHorizontalStrut(40);
        panelNorthCenter_1.add(horizontalStrut_1_1);

        Component horizontalStrut_2_1 = Box.createHorizontalStrut(40);
        panelNorthCenter_1.add(horizontalStrut_2_1);

        panelNbLoyePasPaye_1 = new JPanel();
        panelNbLoyePasPaye_1.addMouseListener(this.gestionClic);
        FlowLayout fl_panelNbLoyePasPaye_1 = (FlowLayout) panelNbLoyePasPaye_1.getLayout();
        fl_panelNbLoyePasPaye_1.setHgap(15);
        panelNbLoyePasPaye_1.setBorder(new TitledBorder(null, "Contrats expirant ce mois", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelNorthCenter_1.add(panelNbLoyePasPaye_1);

        JLabel lblPasPaye_1 = new JLabel("      8      ");
        lblPasPaye_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelNbLoyePasPaye_1.add(lblPasPaye_1);

        Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
        panelNorthCenter_1.add(horizontalStrut_3_1);


        Component verticalStrut_2 = Box.createVerticalStrut(50);
        verticalStrut_2.setPreferredSize(new Dimension(0, 10));

		Component verticalStrut_3 = Box.createVerticalStrut(10);
        verticalStrut_2.setPreferredSize(new Dimension(0, 15));
        panel.add(verticalStrut_2, BorderLayout.SOUTH);

        JPanel panelSouth = new JPanel();
        panelContent.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.setLayout(new BorderLayout(0, 0));

        JPanel panelSouthWest = new JPanel();
        panelSouth.add(panelSouthWest, BorderLayout.WEST);

        JButton btnQuitter = new JButton("Quitter");
        panelSouthWest.add(btnQuitter);
        btnQuitter.addActionListener(this.gestionClic);

        JPanel panelSouthEast = new JPanel();
        panelSouth.add(panelSouthEast, BorderLayout.EAST);

        JButton btnCharges = new JButton("Charges");
        panelSouthEast.add(btnCharges);

        JButton btnCompteurs = new JButton("Compteurs");
        panelSouthEast.add(btnCompteurs);

        JButton btnAssurance = new JButton("Assurance");
        panelSouthEast.add(btnAssurance);
        
        btnImporter = new JButton("Importer Un Fichier CSV");
        panelSouthEast.add(btnImporter);
        
        btnAssurance.addActionListener(this.gestionClic);
        btnCompteurs.addActionListener(this.gestionClic);
        btnCharges.addActionListener(this.gestionClic);
        btnImporter.addActionListener(this.gestionClic);

        JPanel panelCenter = new JPanel();
        panelContent.add(panelCenter);
        panelCenter.setLayout(new BorderLayout(0, 0));

        JPanel panelCenterCenter = new JPanel();
        panelCenter.add(panelCenterCenter);
        panelCenterCenter.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panelCenterCenter.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.addMouseListener(this.gestionClic);
        //getTable().addMouseListener(this);
        getTableBienLouable().setModel(new DefaultTableModel(
            new Object[][] { { null, null, null, null },
                { null, null, null, null }, { null, null, null, null },
                { null, null, null, null }, { null, null, null, null },
                { null, null, null, null }, { null, null, null, null },
                { null, null, null, null }, { null, null, null, null },
                { null, null, null, null }, },
            new String[] { "Contrat Location", "Date", "Bien Louable",
                "Locataire Référent" }) {
            Class[] columnTypes = new Class[] { String.class, String.class,
                String.class, String.class };

            @Override
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            boolean[] columnEditables = new boolean[] { false, false, false,
                false };

            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        scrollPane.setViewportView(getTableBienLouable());

        JPanel panelCenterNorth = new JPanel();
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);
        panelCenterNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JComboBox<String> cbBatiment = new JComboBox<String>();
        cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbBatiment.addActionListener(this.gestionClic);
        cbBatiment.setModel(new DefaultComboBoxModel(new String[] { "Bat1",
            "Bat2", "Bat3", "TestLoooong", "BackRoom" }));
        panelCenterNorth.add(cbBatiment);

        JButton btnAjouterBatiment = new JButton("Ajouter");
        btnAjouterBatiment.addActionListener(this.gestionClic);
        btnAjouterBatiment.setFont(new Font("Tahoma", Font.BOLD, 10));
        panelCenterNorth.add(btnAjouterBatiment);

        JPanel panelMenuBar = new JPanel();
        contentPane.add(panelMenuBar, BorderLayout.NORTH);
        panelMenuBar.setLayout(new GridLayout(0, 1, 0, 0));

      

      //header
       this.setJMenuBar(createHeader());
        
        gestionClic.initialize();

        JPanel panelFooter = new JPanel();
        contentPane.add(panelFooter, BorderLayout.SOUTH);
        panelFooter.setLayout(new GridLayout(1,0, 0, 0));

        
        panelFooter.add(createFooter());
   

        Component horizontalStrut_4 = Box.createHorizontalStrut(10);
        horizontalStrut_4.setPreferredSize(new Dimension(10, 0));
        contentPane.add(horizontalStrut_4, BorderLayout.WEST);

        Component horizontalStrut_5 = Box.createHorizontalStrut(20);
        horizontalStrut_5.setPreferredSize(new Dimension(10, 0));
        contentPane.add(horizontalStrut_5, BorderLayout.EAST);

        this.setPreferredSize(new Dimension(1200, 800));
        this.setMinimumSize(new Dimension(1200, 800));
        this.setMaximumSize(new Dimension(1200, 800));
        this.setSize(new Dimension(1200, 800));
        this.pack();
        this.setLocationRelativeTo(null);
 
    }

    @Override
    public void disableMenuItems(boolean actif) {
    	mnBienLouable.setEnabled(actif);
    	mnPaiement.setEnabled(actif);
    	this.mntmAssurance.setEnabled(actif);
    	this.mntmCharge.setEnabled(actif);
    	this.mntmCompteur.setEnabled(actif);
    }

}
