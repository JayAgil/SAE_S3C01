package vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import controleur.GestionFenetreAssurance;

public class FenetreAssurance extends FenetreBase {

    private static final long serialVersionUID = 1L;
    private GestionFenetreAssurance gestionClic;

    private JTextField textFieldNumAssurance;
    private JTextField txtFieldPrime;
    private JTextField txtFieldMontant;
    private JTextField txtFieldType;
    private JTextField textFieldAgence;
    private JTextField textFieldAdresseAgence;
    private JTextField textFieldTelAgence;
    private JPanel panelNombreBien;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FenetreAssurance frame = new FenetreAssurance();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FenetreAssurance() {
        setTitle("Assurance");
        setSize(600, 650);
        setResizable(false); 
        gestionClic = new GestionFenetreAssurance(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10));
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));
        setJMenuBar(menuBar);

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
        
        JPanel panelCenter = new JPanel(new GridBagLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        int row = 0;
        
        JLabel lblTitre = new JLabel("Assurance");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        GridBagConstraints gbc_lblTitre = new GridBagConstraints();
        gbc_lblTitre.gridwidth = 2;
        gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitre.gridx = 0;
        gbc_lblTitre.gridy = 0;
        panelCenter.add(lblTitre, gbc_lblTitre);

        panelNombreBien = new JPanel();
        panelNombreBien.setBorder(new TitledBorder(new EtchedBorder(), 
            "Biens louables assurés", TitledBorder.CENTER, TitledBorder.TOP));
        panelNombreBien.setPreferredSize(new Dimension(200, 80));
        JLabel lblNbBien = new JLabel("3", SwingConstants.CENTER);
        lblNbBien.setFont(new Font("Tahoma", Font.BOLD, 24));
        panelNombreBien.add(lblNbBien);

        GridBagConstraints gbcPanel = new GridBagConstraints();
        gbcPanel.insets = new Insets(10, 10, 10, 10);
        gbcPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcPanel.gridx = 0;
        gbcPanel.gridy = 1;
        gbcPanel.gridwidth = 2;
        panelCenter.add(panelNombreBien, gbcPanel);

        row++;

        GridBagConstraints gbcLabel1 = new GridBagConstraints();
        gbcLabel1.insets = new Insets(10, 10, 10, 10);
        gbcLabel1.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel1.gridx = 0;
        gbcLabel1.gridy = 2;
        gbcLabel1.anchor = GridBagConstraints.EAST;
        JLabel lblNumAssurance = new JLabel("Numéro d'assurance :");
        panelCenter.add(lblNumAssurance, gbcLabel1);

        textFieldNumAssurance = new JTextField(15); 
        GridBagConstraints gbcTextField1 = new GridBagConstraints();
        gbcTextField1.insets = new Insets(10, 10, 10, 10);
        gbcTextField1.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField1.gridx = 1;
        gbcTextField1.gridy = 2;
        gbcTextField1.anchor = GridBagConstraints.WEST;
        panelCenter.add(textFieldNumAssurance, gbcTextField1);
        row++;

        GridBagConstraints gbcLabel2 = new GridBagConstraints();
        gbcLabel2.insets = new Insets(10, 10, 10, 10);
        gbcLabel2.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel2.gridx = 0;
        gbcLabel2.gridy = 3;
        gbcLabel2.anchor = GridBagConstraints.EAST;
        JLabel lblPrime = new JLabel("Prime :");
        panelCenter.add(lblPrime, gbcLabel2);

        txtFieldPrime = new JTextField(15); 
        GridBagConstraints gbcTextField2 = new GridBagConstraints();
        gbcTextField2.insets = new Insets(10, 10, 10, 10);
        gbcTextField2.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField2.gridx = 1;
        gbcTextField2.gridy = 3;
        gbcTextField2.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtFieldPrime, gbcTextField2);
        row++;

        GridBagConstraints gbcLabel3 = new GridBagConstraints();
        gbcLabel3.insets = new Insets(10, 10, 10, 10);
        gbcLabel3.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel3.gridx = 0;
        gbcLabel3.gridy = 4;
        gbcLabel3.anchor = GridBagConstraints.EAST;
        JLabel lblMontant = new JLabel("Montant :");
        panelCenter.add(lblMontant, gbcLabel3);

        txtFieldMontant = new JTextField(15); 
        GridBagConstraints gbcTextField3 = new GridBagConstraints();
        gbcTextField3.insets = new Insets(10, 10, 10, 10);
        gbcTextField3.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField3.gridx = 1;
        gbcTextField3.gridy = 4;
        gbcTextField3.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtFieldMontant, gbcTextField3);
        row++;

        GridBagConstraints gbcLabel4 = new GridBagConstraints();
        gbcLabel4.insets = new Insets(10, 10, 10, 10);
        gbcLabel4.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel4.gridx = 0;
        gbcLabel4.gridy = 5;
        gbcLabel4.anchor = GridBagConstraints.EAST;
        JLabel lblType = new JLabel("Type assurance :");
        panelCenter.add(lblType, gbcLabel4);

        txtFieldType = new JTextField(15); 
        GridBagConstraints gbcTextField4 = new GridBagConstraints();
        gbcTextField4.insets = new Insets(10, 10, 10, 10);
        gbcTextField4.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField4.gridx = 1;
        gbcTextField4.gridy = 5;
        gbcTextField4.anchor = GridBagConstraints.WEST;
        panelCenter.add(txtFieldType, gbcTextField4);
        row++;

        GridBagConstraints gbcLabel5 = new GridBagConstraints();
        gbcLabel5.insets = new Insets(10, 10, 10, 10);
        gbcLabel5.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel5.gridx = 0;
        gbcLabel5.gridy = 6;
        gbcLabel5.anchor = GridBagConstraints.EAST;
        JLabel lblAgence = new JLabel("Agence :");
        panelCenter.add(lblAgence, gbcLabel5);

        textFieldAgence = new JTextField(15); 
        GridBagConstraints gbcTextField5 = new GridBagConstraints();
        gbcTextField5.insets = new Insets(10, 10, 10, 10);
        gbcTextField5.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField5.gridx = 1;
        gbcTextField5.gridy = 6;
        gbcTextField5.anchor = GridBagConstraints.WEST;
        panelCenter.add(textFieldAgence, gbcTextField5);
        row++;

        GridBagConstraints gbcLabel6 = new GridBagConstraints();
        gbcLabel6.insets = new Insets(10, 10, 10, 10);
        gbcLabel6.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel6.gridx = 0;
        gbcLabel6.gridy = 7;
        gbcLabel6.anchor = GridBagConstraints.EAST;
        JLabel lblAdresse = new JLabel("Adresse agence :");
        panelCenter.add(lblAdresse, gbcLabel6);

        textFieldAdresseAgence = new JTextField(15);
        GridBagConstraints gbcTextField6 = new GridBagConstraints();
        gbcTextField6.insets = new Insets(10, 10, 10, 10);
        gbcTextField6.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField6.gridx = 1;
        gbcTextField6.gridy = 7;
        gbcTextField6.anchor = GridBagConstraints.WEST;
        panelCenter.add(textFieldAdresseAgence, gbcTextField6);
        row++;

        GridBagConstraints gbcLabel7 = new GridBagConstraints();
        gbcLabel7.insets = new Insets(10, 10, 10, 10);
        gbcLabel7.fill = GridBagConstraints.HORIZONTAL;
        gbcLabel7.gridx = 0;
        gbcLabel7.gridy = 8;
        gbcLabel7.anchor = GridBagConstraints.EAST;
        JLabel lblTel = new JLabel("Téléphone agence :");
        panelCenter.add(lblTel, gbcLabel7);

        textFieldTelAgence = new JTextField(15); 
        GridBagConstraints gbcTextField7 = new GridBagConstraints();
        gbcTextField7.insets = new Insets(10, 10, 10, 10);
        gbcTextField7.fill = GridBagConstraints.HORIZONTAL;
        gbcTextField7.gridx = 1;
        gbcTextField7.gridy = 8;
        gbcTextField7.anchor = GridBagConstraints.WEST;
        panelCenter.add(textFieldTelAgence, gbcTextField7);
        row++;

        JPanel southPanel = new JPanel(new BorderLayout());
        
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnAjouter = new JButton("Ajouter assurance");
        btnAjouter.addActionListener(gestionClic);
        panelButtons.add(btnAjouter);

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(gestionClic);
        panelButtons.add(btnRetour);
        
        southPanel.add(panelButtons, BorderLayout.NORTH);

        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY)); 
        footerPanel.setBackground(new Color(214, 214, 214)); 
        footerPanel.setPreferredSize(new Dimension(584, 30));
        JLabel footerLabel = new JLabel("Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);
        southPanel.add(footerPanel, BorderLayout.SOUTH);
       
        contentPane.add(southPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}