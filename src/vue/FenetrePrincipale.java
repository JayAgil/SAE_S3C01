package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.JTextField;

public class FenetrePrincipale extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public JTable getTableBienLouable() {

        return table; 

    }

    private GestionFenetrePrincipale gestionClic;
    private JTable table;

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
        this.gestionClic = new GestionFenetrePrincipale(this);
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

        JPanel panelRevenu = new JPanel();
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

        JPanel panelNbLoyePasPaye = new JPanel();
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

        JPanel panelRevenu_1 = new JPanel();
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

        JPanel panelNbLoyePasPaye_1 = new JPanel();
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
        btnAssurance.addActionListener(this.gestionClic);
        btnCompteurs.addActionListener(this.gestionClic);
        btnCharges.addActionListener(this.gestionClic);

        JPanel panelCenter = new JPanel();
        panelContent.add(panelCenter);
        panelCenter.setLayout(new BorderLayout(0, 0));

        JPanel panelCenterCenter = new JPanel();
        panelCenter.add(panelCenterCenter);
        panelCenterCenter.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panelCenterCenter.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        //getTable().addMouseListener(this);
        getTable().setModel(new DefaultTableModel(
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
        scrollPane.setViewportView(getTable());

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

        JButton btnSupprimerBatiment = new JButton("Supprimer");
        btnSupprimerBatiment.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnSupprimerBatiment.addActionListener(this.gestionClic);
        panelCenterNorth.add(btnSupprimerBatiment);

        JPanel panelMenuBar = new JPanel();
        contentPane.add(panelMenuBar, BorderLayout.NORTH);
        panelMenuBar.setLayout(new GridLayout(0, 1, 0, 0));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));
        panelMenuBar.add(menuBar);

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

        JPanel panelFooter = new JPanel();
        contentPane.add(panelFooter, BorderLayout.SOUTH);
        panelFooter.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(584, 30));
        footerPanel.setBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));
        panelFooter.add(footerPanel);
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

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

    public void actionPerformed(ActionEvent arg) {
        gestionClic.actionPerformed(arg);
    }

    public void mouseClicked(MouseEvent arg) {
        gestionClic.mouseClicked(arg);
    }

    /*@Override
    public void mouseEntered(MouseEvent arg) {}
    @Override
    public void mouseExited(MouseEvent arg) {}
    @Override
    public void mousePressed(MouseEvent arg) {}
    @Override
    public void mouseReleased(MouseEvent arg) {}
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}*/

    public JTable getTable() {
        return table;
    }
}
