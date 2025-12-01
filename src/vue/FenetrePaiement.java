package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePaiement;

public class FenetrePaiement extends JFrame {

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
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	gestionClic = new GestionFenetrePaiement(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 800);
        setLocationRelativeTo(null);
        setTitle("Application Gestion");

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));
        setJMenuBar(menuBar);

        //header
        JMenu mnProfil = new JMenu("Profil");
        menuBar.add(mnProfil);

        JMenuItem mntmDeconnecter = new JMenuItem("Déconnecter");
        mntmDeconnecter.addActionListener(this.gestionClic);
        mnProfil.add(mntmDeconnecter);

        JMenu mnBatiment = new JMenu("Batiment");
        menuBar.add(mnBatiment);

        JMenuItem mntmAjouterBat = new JMenuItem("Ajouter bâtiment");
        mntmAjouterBat.addActionListener(this.gestionClic);
        mnBatiment.add(mntmAjouterBat);

        JMenuItem mntmAssurance = new JMenuItem("Assurance");
        mntmAssurance.addActionListener(this.gestionClic);
        mnBatiment.add(mntmAssurance);

        JMenuItem mntmCompteur = new JMenuItem("Compteurs bâtiment");
        mntmCompteur.addActionListener(this.gestionClic);
        mnBatiment.add(mntmCompteur);

        JMenuItem mntmCharge = new JMenuItem("Charges bâtiment");
        mntmCharge.addActionListener(this.gestionClic);
        mnBatiment.add(mntmCharge);

        JMenu mnBienLouable = new JMenu("Bien louable");
        menuBar.add(mnBienLouable);

        JMenuItem mntmContratLocation = new JMenuItem("Contrat location");
        mntmContratLocation.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmContratLocation);

        JMenuItem mntmCompteurBL = new JMenuItem("Compteurs bien louable");
        mntmCompteurBL.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmCompteurBL);

        JMenuItem mntmTravaux = new JMenuItem("Travaux");
        mntmTravaux.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmTravaux);

        JMenuItem mntmChargesBL = new JMenuItem("Charges bien louable");
        mntmChargesBL.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmChargesBL);

        JMenuItem mntmDiagnostic = new JMenuItem("Diagnostics");
        mntmDiagnostic.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmDiagnostic);

        JMenuItem mntmLocataire = new JMenuItem("Locataires");
        mntmLocataire.addActionListener(this.gestionClic);
        mnBienLouable.add(mntmLocataire);
        
        JMenu mnPaiement = new JMenu("Paiement");
        menuBar.add(mnPaiement);
        
        JMenuItem mntmHistorique = new JMenuItem("Historique de paiement");
        mntmHistorique.addActionListener(this.gestionClic);
        mnPaiement.add(mntmHistorique);
        
        JMenuItem mntmAjout = new JMenuItem("Ajouter paiement");
        mntmAjout.addActionListener(this.gestionClic);
        mnPaiement.add(mntmAjout);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

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
        ));

        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));
        footerPanel.setPreferredSize(new Dimension(584, 30));

        JLabel footerLabel = new JLabel("Développé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

        contentPane.add(footerPanel, BorderLayout.SOUTH);
        
        JPanel panel_3 = new JPanel();
        contentPane.add(panel_3, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Paiement");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_3.add(lblTitre);
        
    	btnAjouterPaiement.addActionListener(gestionClic);
        btnGenFac.addActionListener(gestionClic);
        btnRetour.addActionListener(gestionClic);
    }
    
    
}
