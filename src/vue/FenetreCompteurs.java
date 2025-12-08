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
import java.awt.FlowLayout;

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
        panel.add(scrollPane, BorderLayout.CENTER);
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
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        panel_1.add(verticalStrut);
        
        JLabel lblTitre = new JLabel("Compteurs");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_1.add(lblTitre);

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