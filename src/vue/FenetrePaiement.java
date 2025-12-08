package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;

public class FenetrePaiement extends FenetreBase{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private GestionFenetrePaiement gestionClic;
	

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetrePaiement frame = new FenetrePaiement();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FenetrePaiement() {
    	super();
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	gestionClic = new GestionFenetrePaiement(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setLocationRelativeTo(null);
        setTitle("Application Gestion");

        
        //header
        this.setJMenuBar(createHeader());

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.gestionClic.initialize();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BorderLayout());

        contentPane.add(mainPanel, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        mainPanel.add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2, 2, 0, 5));
        
        JPanel panel_4 = new JPanel();
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_4.add(panel_1);
        
        JLabel lblDatePaiement = new JLabel("Date paiement :");
        panel_1.add(lblDatePaiement);
        
        JLabel lblValDate = new JLabel("ValDate");
        panel_1.add(lblValDate);
        
        Component horizontalStrut = Box.createHorizontalStrut(600);
        panel_1.add(horizontalStrut);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);
        
        JLabel lblMontant = new JLabel("Montant paiement :");
        panel_5.add(lblMontant);
        
        JLabel lblValPaiement = new JLabel("euro");
        panel_5.add(lblValPaiement);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(600);
        panel_5.add(horizontalStrut_1);
        
        JPanel panelButtons = new JPanel();
        mainPanel.add(panelButtons, BorderLayout.SOUTH);
        
        JButton btnAjouterPaiement = new JButton("Ajouter paiement");
        btnAjouterPaiement.addActionListener(this.gestionClic);
        panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelButtons.add(btnAjouterPaiement);
        
        JButton btnGenFac = new JButton("Générer facture");
        btnGenFac.addActionListener(this.gestionClic);
        panelButtons.add(btnGenFac);
        
        JButton btnRetour = new JButton("Retour");
        panelButtons.add(btnRetour);
        
        JScrollPane scrollPane = new JScrollPane();
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.addMouseListener(this.gestionClic);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Nom Locataire", "Date de Paiement", "Montant de Paiement", "Solde", "Contrat Location"
        	}
        ) {
        	Class[] columnTypes = new Class[] {
        		String.class, String.class, Float.class, String.class, String.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });

       

        contentPane.add(createFooter(), BorderLayout.SOUTH);
        
        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Paiement");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_3.add(lblTitre);
        
        btnRetour.addActionListener(gestionClic);
    }
    
    public void disableMenuItems(boolean actif) {
    	this.mnBatiment.setEnabled(actif);
    	this.mntmChargesBL.setEnabled(actif);
    	this.mntmCompteurBL.setEnabled(actif);
    	this.mntmContratLocation.setEnabled(actif);
    	this.mntmDiagnostic.setEnabled(actif);
    	this.mntmHistorique.setEnabled(actif);
    	this.mntmTravaux.setEnabled(actif);

    }

	public JTable getTable() {
		return table;
	}
    
}
