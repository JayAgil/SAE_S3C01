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
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetreLocataire;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreLocataire extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textField;
    private JTextField textFieldTel;
    private JTextField textFieldEmail;
    private JTextField textFieldDateNaissance;
    private JTextField textFieldLieuNaissance;
    private JTextField textFieldSalaire;
    private JTextField textFieldProfession;
    private JTextField textFieldSituationFamiliale;
    private GestionFenetreLocataire gestionClic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreLocataire frame = new FenetreLocataire();
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
    public FenetreLocataire() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 726, 442);

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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
                                                                            
                                                                                               
        footerPanel.setBackground(new Color(214, 214, 214));
        footerPanel.setPreferredSize(new Dimension(584, 30));

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblTitre = new JLabel("Information Locataire");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitre, BorderLayout.NORTH);
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(2, 0, 0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));
        
        JLabel lblPhoto = new JLabel("Photo");
        panel_2.add(lblPhoto);
        
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(new GridLayout(11, 2, 10, 5)); 
        panel_2.add(panel_3);

        JLabel lblNom = new JLabel("Nom :");
        panel_3.add(lblNom);
        textFieldNom = new JTextField();
        panel_3.add(textFieldNom);

        JLabel lblPrenom = new JLabel("Prénom :");
        panel_3.add(lblPrenom);
        textFieldPrenom = new JTextField();
        panel_3.add(textFieldPrenom);

        JLabel lblAdresse = new JLabel("Adresse :");
        panel_3.add(lblAdresse);
        textField = new JTextField();
        panel_3.add(textField);

        JLabel lblTel = new JLabel("Tél :");
        panel_3.add(lblTel);
        textFieldTel = new JTextField();
        panel_3.add(textFieldTel);

        JLabel lblEmail = new JLabel("Email :");
        panel_3.add(lblEmail);
        textFieldEmail = new JTextField();
        panel_3.add(textFieldEmail);

        JLabel lblDate = new JLabel("Date de naissance :");
        panel_3.add(lblDate);
        textFieldDateNaissance = new JTextField();
        panel_3.add(textFieldDateNaissance);

        JLabel lblLieu = new JLabel("Lieu de naissance :");
        panel_3.add(lblLieu);
        textFieldLieuNaissance = new JTextField();
        panel_3.add(textFieldLieuNaissance);

        JLabel lblSalaire = new JLabel("Salaire :");
        panel_3.add(lblSalaire);
        textFieldSalaire = new JTextField();
        panel_3.add(textFieldSalaire);

        JLabel lblProfession = new JLabel("Profession :");
        panel_3.add(lblProfession);
        textFieldProfession = new JTextField();
        panel_3.add(textFieldProfession);

        JLabel lblSituation = new JLabel("Situation familiale :");
        panel_3.add(lblSituation);
        textFieldSituationFamiliale = new JTextField();
        panel_3.add(textFieldSituationFamiliale);
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this);
        panel_4.add(btnAnnuler);
        
        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        
        JButton btnAjouterLocataire = new JButton("Ajouter locataire");
        btnAjouterLocataire.addActionListener(this);
        panel_5.add(btnAjouterLocataire);

        
        JScrollPane scrollPane = new JScrollPane();
      
        panel_1.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String[] {"Prénom", "Nom", "Date Debut", "Date Fin"}
        ) {
            boolean[] columnEditables = {false, false, false, true};
            @Override
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        scrollPane.setViewportView(table);
        int rowCount = table.getRowCount();
        int rowHeight = table.getRowHeight();
        int maxVisibleRows = 5; 
        int tableHeight = Math.min(rowCount, maxVisibleRows) * rowHeight;
        scrollPane.setPreferredSize(new Dimension(500, tableHeight + table.getTableHeader().getPreferredSize().height));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(true);  
        scrollPane.setBorder(BorderFactory.createTitledBorder("Historique des Contrats"));


    }
	public void actionPerformed(ActionEvent e) {
	}
}