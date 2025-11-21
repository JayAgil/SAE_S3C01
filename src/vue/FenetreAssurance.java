package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAssurance;
import java.awt.Component;
import javax.swing.Box;

public class FenetreAssurance extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionFenetreAssurance gestionClic;
    private JTextField textFieldNumAssurance;
    private JTextField textFieldTypeAssurance;
    private JTextField textFieldTxtMontant;
    private JTextField textFieldBatAssure;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
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

    /**
     * Create the frame.
     */
    public FenetreAssurance() {
        this.gestionClic = new GestionFenetreAssurance(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panelNorth.add(panel_1);
        
        Component verticalStrut_1 = Box.createVerticalStrut(50);
        panel_1.add(verticalStrut_1);
        
        JLabel lblTitre = new JLabel("Assurance");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_1.add(lblTitre);
        
        JPanel panel_2 = new JPanel();
        panelNorth.add(panel_2);
        
        JComboBox comboBox = new JComboBox();
        panel_2.add(comboBox);
        
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
                "Assurance1", "Assurance2", "Assurance3", "THE_ASSURANCE" }));

        JPanel panelCenter = new JPanel();
        panel.add(panelCenter);
        panelCenter.setLayout(new GridLayout(4, 1, 0, 0));

        JPanel panelL1 = new JPanel();
        panelCenter.add(panelL1);
        panelL1.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelNumassurance = new JPanel();
        FlowLayout fl_panelNumassurance = (FlowLayout) panelNumassurance
            .getLayout();
        fl_panelNumassurance.setAlignment(FlowLayout.RIGHT);
        panelL1.add(panelNumassurance);

        JLabel labelNumAssurance = new JLabel("Numéro de l'assurance :");
        panelNumassurance.add(labelNumAssurance);
        labelNumAssurance.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panelTxtNumAssurance = new JPanel();
        panelL1.add(panelTxtNumAssurance);
        panelTxtNumAssurance.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        textFieldNumAssurance = new JTextField();
        textFieldNumAssurance.setHorizontalAlignment(SwingConstants.LEFT);
        panelTxtNumAssurance.add(textFieldNumAssurance);
        textFieldNumAssurance.setColumns(10);

        JPanel panelL2 = new JPanel();
        panelCenter.add(panelL2);
        panelL2.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelTypeAssurance = new JPanel();
        FlowLayout fl_panelTypeAssurance = (FlowLayout) panelTypeAssurance
            .getLayout();
        fl_panelTypeAssurance.setAlignment(FlowLayout.RIGHT);
        panelL2.add(panelTypeAssurance);

        JLabel labelType = new JLabel("Type de l'assurance :");
        panelTypeAssurance.add(labelType);
        labelType.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panelTxtTypeAssurance = new JPanel();
        FlowLayout fl_panelTxtTypeAssurance = (FlowLayout) panelTxtTypeAssurance
            .getLayout();
        fl_panelTxtTypeAssurance.setAlignment(FlowLayout.LEFT);
        panelL2.add(panelTxtTypeAssurance);

        textFieldTypeAssurance = new JTextField();
        panelTxtTypeAssurance.add(textFieldTypeAssurance);
        textFieldTypeAssurance.setColumns(10);

        JPanel panelL3 = new JPanel();
        panelCenter.add(panelL3);
        panelL3.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelMontant = new JPanel();
        FlowLayout fl_panelMontant = (FlowLayout) panelMontant.getLayout();
        fl_panelMontant.setAlignment(FlowLayout.RIGHT);
        panelL3.add(panelMontant);

        JLabel labelMontant = new JLabel("Montant : ");
        panelMontant.add(labelMontant);
        labelMontant.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panelTxtMontant = new JPanel();
        FlowLayout fl_panelTxtMontant = (FlowLayout) panelTxtMontant
            .getLayout();
        fl_panelTxtMontant.setAlignment(FlowLayout.LEFT);
        panelL3.add(panelTxtMontant);

        textFieldTxtMontant = new JTextField();
        panelTxtMontant.add(textFieldTxtMontant);
        textFieldTxtMontant.setColumns(10);

        JPanel panelL4 = new JPanel();
        panelCenter.add(panelL4);
        panelL4.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelBatAssure = new JPanel();
        FlowLayout fl_panelBatAssure = (FlowLayout) panelBatAssure.getLayout();
        fl_panelBatAssure.setAlignment(FlowLayout.RIGHT);
        panelL4.add(panelBatAssure);

        JLabel labelBatAssure = new JLabel("Batiments assurés :");
        panelBatAssure.add(labelBatAssure);
        labelBatAssure.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panelTxtBatAssure = new JPanel();
        FlowLayout fl_panelTxtBatAssure = (FlowLayout) panelTxtBatAssure
            .getLayout();
        fl_panelTxtBatAssure.setAlignment(FlowLayout.LEFT);
        panelL4.add(panelTxtBatAssure);

        textFieldBatAssure = new JTextField();
        panelTxtBatAssure.add(textFieldBatAssure);
        textFieldBatAssure.setColumns(10);

        JPanel panelSouth = new JPanel();
        panel.add(panelSouth, BorderLayout.SOUTH);

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panelSouth.add(btnRetour);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        panelSouth.add(verticalStrut);

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

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);
    }

   
}
