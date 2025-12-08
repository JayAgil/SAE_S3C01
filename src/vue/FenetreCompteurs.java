package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import controleur.GestionFenetreCompteurs;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class FenetreCompteurs extends FenetreBase {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableCompteurs;
    private GestionFenetreCompteurs gestionClic;
    private String fenetreAvant;
	
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreCompteurs frame = new FenetreCompteurs("");
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
    public FenetreCompteurs(String fenetreAvant) {
    	super();
    	this.fenetreAvant = fenetreAvant;
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	this.gestionClic = new GestionFenetreCompteurs(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);

        //header
        this.setJMenuBar(createHeader());
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        this.gestionClic.initialize();
        
        //footer
        getContentPane().add(createFooter(), BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        
        new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
            },
            new String[] {
                "Type", "Date", "Index ancien", "Index nouveau", 
                "Consommation", "Partie Variable", "Partie Fixe", "Total"
            }
        ) {
            boolean[] columnEditables = new boolean[] {
                false, false, false, false, false, false, true, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };

     
        tableCompteurs = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Type", "Date", "Bien louable", "Index ancien", "Index nouveau", "Consommation", "Partie Variable", "Partie Fixe", "Total"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false, false, true, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });

        JScrollPane scrollPane = new JScrollPane(tableCompteurs);
        panel.add(scrollPane, BorderLayout.NORTH);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        
        JPanel panel_butons = new JPanel();
        panel.add(panel_butons, BorderLayout.SOUTH);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panel_butons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_butons.add(btnRetour);
        
        JButton btnAjouterCompteur = new JButton("Ajouter compteur");
        btnAjouterCompteur.addActionListener(this.gestionClic);
        panel_butons.add(btnAjouterCompteur);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[] {400, 400, 400};
        gbl_panel_2.rowHeights = new int[] {230, 200};
        gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0};
        gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
        panel_2.setLayout(gbl_panel_2);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Total Eau", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.insets = new Insets(0, 0, 5, 5);
        gbc_panel_4.fill = GridBagConstraints.BOTH;
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 0;
        panel_2.add(panel_4, gbc_panel_4);
        GridBagLayout gbl_panel_4 = new GridBagLayout();
        gbl_panel_4.columnWidths = new int[] {400};
        gbl_panel_4.rowHeights = new int[] {50, 180};
        gbl_panel_4.columnWeights = new double[]{1.0};
        gbl_panel_4.rowWeights = new double[]{0.0, 1.0};
        panel_4.setLayout(gbl_panel_4);
        
        JLabel lblNewLabel = new JLabel("");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel_4.add(lblNewLabel, gbc_lblNewLabel);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Total \u00C9electricit\u00E9", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel_4_1 = new GridBagConstraints();
        gbc_panel_4_1.insets = new Insets(0, 0, 5, 5);
        gbc_panel_4_1.fill = GridBagConstraints.BOTH;
        gbc_panel_4_1.gridx = 1;
        gbc_panel_4_1.gridy = 0;
        panel_2.add(panel_4_1, gbc_panel_4_1);
        GridBagLayout gbl_panel_4_1 = new GridBagLayout();
        gbl_panel_4_1.columnWidths = new int[] {400};
        gbl_panel_4_1.rowHeights = new int[] {50, 180};
        gbl_panel_4_1.columnWeights = new double[]{1.0};
        gbl_panel_4_1.rowWeights = new double[]{0.0, 1.0};
        panel_4_1.setLayout(gbl_panel_4_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 0;
        panel_4_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        JPanel panel_4_2 = new JPanel();
        panel_4_2.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Total Gaz", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GridBagConstraints gbc_panel_4_2 = new GridBagConstraints();
        gbc_panel_4_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_4_2.fill = GridBagConstraints.BOTH;
        gbc_panel_4_2.gridx = 2;
        gbc_panel_4_2.gridy = 0;
        panel_2.add(panel_4_2, gbc_panel_4_2);
        GridBagLayout gbl_panel_4_2 = new GridBagLayout();
        gbl_panel_4_2.columnWidths = new int[] {400};
        gbl_panel_4_2.rowHeights = new int[] {50, 180};
        gbl_panel_4_2.columnWeights = new double[]{1.0};
        gbl_panel_4_2.rowWeights = new double[]{0.0, 1.0};
        panel_4_2.setLayout(gbl_panel_4_2);
        
        JLabel lblNewLabel_2 = new JLabel("");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 0;
        panel_4_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        panel_1.add(verticalStrut);
        
        JLabel lblTitre = new JLabel("Compteurs");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_1.add(lblTitre);
        
        //icons
        ImageIcon eauIcon = new ImageIcon("img/water.png"); 
        Image imgEau = eauIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(imgEau));
        lblNewLabel.setHorizontalAlignment(JLabel.RIGHT); 
        
        JLabel lblNewLabel_5 = new JLabel("860");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 95));
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 1;
        panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

        ImageIcon elecIcon = new ImageIcon("img/electricity.png");
        Image imgElec = elecIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(imgElec));
        lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
        
        JLabel lblNewLabel_4 = new JLabel("900");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 95));
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 1;
        panel_4_1.add(lblNewLabel_4, gbc_lblNewLabel_4);


        ImageIcon gazIcon = new ImageIcon("img/gaz.png");
        Image imgGaz = gazIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(imgGaz));
        lblNewLabel_2.setHorizontalAlignment(JLabel.RIGHT);
        
        JLabel lblNewLabel_3 = new JLabel("123");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 95));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 1;
        panel_4_2.add(lblNewLabel_3, gbc_lblNewLabel_3);


    }
    public String getFenetreAvant() {
		return fenetreAvant;
	}

	@Override
    public void disableMenuItems(boolean actif) {
    	this.mnPaiement.setEnabled(actif);

    	if (this.fenetreAvant == "FenetrePrincipale"){
    			this.mnBienLouable.setEnabled(actif);
    			this.mntmAjouterBat.setEnabled(actif);
    			mntmCompteur.setEnabled(actif);
    	}
    	if (this.fenetreAvant == "FenetreBienLouable"){
			this.mntmCompteurBL.setEnabled(actif);
			this.mnBatiment.setEnabled(actif);	
	}
	}
    
    
}