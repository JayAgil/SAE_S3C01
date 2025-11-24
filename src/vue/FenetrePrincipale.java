package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controleur.GestionFenetrePrincipale;

public class FenetrePrincipale extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private GestionFenetrePrincipale gestionClic;
    private JTable table;

    // ----- CONSTANTS -----
    private static final Dimension WINDOW_SIZE = new Dimension(1200, 800);
    private static final int TOP_SPACER_LARGE = 60;
    private static final int TOP_SPACER_SMALL = 40;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetrePrincipale frame = new FenetrePrincipale();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FenetrePrincipale() {

        this.gestionClic = new GestionFenetrePrincipale(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // ============================
        // MENU BAR (TOP)
        // ============================
        setJMenuBar(buildMenuBar());

        // ============================
        // NORTH PANEL (STATS + BUTTONS)
        // ============================
        contentPane.add(buildTopPanel(), BorderLayout.NORTH);

        // ============================
        // CENTER (TABLE + FILTERS)
        // ============================
        contentPane.add(buildCenterPanel(), BorderLayout.CENTER);

        // ============================
        // FOOTER
        // ============================
        contentPane.add(buildFooterPanel(), BorderLayout.SOUTH);

        // Window sizing
        setPreferredSize(WINDOW_SIZE);
        setSize(WINDOW_SIZE);
        setMinimumSize(WINDOW_SIZE);
        setMaximumSize(WINDOW_SIZE);

        this.setLocationRelativeTo(null);
    }

    // ============================================================
    // TOP SECTION (STATS + SPACING + BUTTONS)
    // ============================================================
    private JPanel buildTopPanel() {
        JPanel panelNorth = new JPanel(new GridBagLayout());

        // ------------------------------
        // ROW 1: Stats
        // ------------------------------
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.CENTER;

        JPanel statsRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        JLabel lblRevenu = new JLabel("180.000");
        lblRevenu.setFont(new Font("Tahoma", Font.BOLD, 30));

        JLabel lblPasPaye = new JLabel("8");
        lblPasPaye.setFont(new Font("Tahoma", Font.BOLD, 30));

        statsRow.add(lblRevenu);
        statsRow.add(lblPasPaye);

        panelNorth.add(statsRow, gbc1);

        // ------------------------------
        // SPACER 1
        // ------------------------------
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;

        panelNorth.add(createSpacer(TOP_SPACER_LARGE), gbc2);

        // ------------------------------
        // ROW 2: Buttons
        // ------------------------------
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.anchor = GridBagConstraints.CENTER;

        JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton btnCharges = new JButton("Charges");
        JButton btnCompteurs = new JButton("Compteurs");
        JButton btnAssurance = new JButton("Assurance");

        btnCharges.addActionListener(gestionClic);
        btnCompteurs.addActionListener(gestionClic);
        btnAssurance.addActionListener(gestionClic);

        secondRow.add(btnCharges);
        secondRow.add(btnCompteurs);
        secondRow.add(btnAssurance);

        panelNorth.add(secondRow, gbc3);

        // ------------------------------
        // SPACER 2
        // ------------------------------
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 3;

        panelNorth.add(createSpacer(TOP_SPACER_SMALL), gbc4);

        return panelNorth;
    }


    private JPanel createSpacer(int height) {
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(1, height));
        return spacer;
    }

    // ============================================================
    // CENTER TABLE AREA
    // ============================================================
    private JPanel buildCenterPanel() {
        JPanel panelCenter = new JPanel(new BorderLayout());

        // Top controls
        JPanel panelCenterNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);

        JComboBox<String> cbBatiment = new JComboBox<>();
        cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbBatiment.addActionListener(gestionClic);
        cbBatiment.setModel(new DefaultComboBoxModel<>(new String[]{
            "Bat1", "Bat2", "Bat3", "TestLoooong", "BackRoom"
        }));
        panelCenterNorth.add(cbBatiment);

        JButton btnAjouterBatiment = new JButton("Ajouter");
        btnAjouterBatiment.addActionListener(gestionClic);
        panelCenterNorth.add(btnAjouterBatiment);

        JButton btnSupprimerBatiment = new JButton("Supprimer");
        btnSupprimerBatiment.addActionListener(gestionClic);
        panelCenterNorth.add(btnSupprimerBatiment);

        // Table
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null},
                {null, null, null, null}, {null, null, null, null},
            },
            new String[]{"Contrat Location", "Date", "Bien Louable", "Locataire Référent"}
        ));

        panelCenter.add(new JScrollPane(table), BorderLayout.CENTER);

        return panelCenter;
    }

    // ============================================================
    // MENU BAR
    // ============================================================
    private JMenuBar buildMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));

        // Profil
        JMenu mnProfil = new JMenu("Profil");
        mnProfil.add(new JMenuItem("Déconnecter"));
        menuBar.add(mnProfil);

        // Batiment
        JMenu mnBatiment = new JMenu("Batiment");
        mnBatiment.add(new JMenuItem("Ajouter bâtiment"));
        mnBatiment.add(new JMenuItem("Supprimer bâtiment"));
        mnBatiment.add(new JMenuItem("Assurance"));
        mnBatiment.add(new JMenuItem("Compteurs"));
        mnBatiment.add(new JMenuItem("Charges"));
        menuBar.add(mnBatiment);

        // Bien louable
        JMenu mnBienLouable = new JMenu("Bien louable");
        mnBienLouable.add(new JMenuItem("Contrat location"));
        mnBienLouable.add(new JMenuItem("Compteurs"));
        mnBienLouable.add(new JMenuItem("Travaux"));
        mnBienLouable.add(new JMenuItem("Charges"));
        mnBienLouable.add(new JMenuItem("Diagnostics"));
        mnBienLouable.add(new JMenuItem("Locataires"));
        menuBar.add(mnBienLouable);

        // Paiement
        JMenu mnPaiement = new JMenu("Paiement");
        mnPaiement.add(new JMenuItem("Historique De Paiements"));
        mnPaiement.add(new JMenuItem("Ajouter Paiement"));
        menuBar.add(mnPaiement);

        return menuBar;
    }

    // ============================================================
    // FOOTER
    // ============================================================
    private JPanel buildFooterPanel() {

        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(584, 30));
        footerPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        footerPanel.setBackground(new Color(214, 214, 214));

        footerPanel.add(new JLabel("Développé par Koshua, Jay, Aneesa, Luca et Franck"));

        return footerPanel;
    }

    // ============================================================
    // CONTROLLER ACCESS
    // ============================================================
    public void actionPerformed(ActionEvent arg) {
        gestionClic.actionPerformed(arg);
    }

    public void mouseClicked(MouseEvent arg) {
        gestionClic.mouseClicked(arg);
    }

    public JTable getTable() {
        return table;
    }
}
