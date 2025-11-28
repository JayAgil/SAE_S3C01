package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.GestionFenetreDiagnostic;

import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Panel;

public class FenetreDiagnostic extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldDateValide;
    private JTextField textFieldType;
    private GestionFenetreDiagnostic gestionClic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreDiagnostic frame = new FenetreDiagnostic();
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
    public FenetreDiagnostic() {
    	this.gestionClic = new GestionFenetreDiagnostic(this);
        setBounds(100, 100, 1200, 800);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelMenuBar = new JPanel();
        getContentPane().add(panelMenuBar, BorderLayout.NORTH);
        panelMenuBar.setLayout(new GridLayout(0, 1, 0, 0));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(214, 214, 214));
        panelMenuBar.add(menuBar);

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

        JMenuItem mntmSupprimerBat = new JMenuItem("Supprimer bâtiment");
        mntmSupprimerBat.addActionListener(this.gestionClic);
        mnBatiment.add(mntmSupprimerBat);

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

        JPanel panelFooter = new JPanel();
        getContentPane().add(panelFooter, BorderLayout.SOUTH);
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
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panel_1.add(btnRetour);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Diagnostics");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel_2.add(lblTitre);
        
        JPanel panel_3 = new JPanel();
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new GridLayout(4, 0, 0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_4.add(panel_5);
        panel_5.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_9 = new JPanel();
        panel_5.add(panel_9);
        
        JLabel lblDateRealise = new JLabel("Date de realisation :");
        panel_9.add(lblDateRealise);
        
        JComboBox comboBoxDateRealise = new JComboBox();
        panel_9.add(comboBoxDateRealise);
        
        Component horizontalStrut_3 = Box.createHorizontalStrut(445);
        panel_9.add(horizontalStrut_3);
        
        JPanel panel_6 = new JPanel();
        panel_4.add(panel_6);
        panel_6.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_10 = new JPanel();
        panel_6.add(panel_10);
        
        JLabel lblDateValide = new JLabel("Date de validite :");
        panel_10.add(lblDateValide);
        
        textFieldDateValide = new JTextField();
        panel_10.add(textFieldDateValide);
        textFieldDateValide.setColumns(10);
        
        Component horizontalStrut_2 = Box.createHorizontalStrut(407);
        panel_10.add(horizontalStrut_2);
        
        JPanel panel_7 = new JPanel();
        panel_4.add(panel_7);
        panel_7.setLayout(new GridLayout(0, 2, 0, 0));
        
        Panel panel_11 = new Panel();
        panel_7.add(panel_11);
        
        JLabel lblType = new JLabel("Type de diagnostic : ");
        panel_11.add(lblType);
        
        textFieldType = new JTextField();
        panel_11.add(textFieldType);
        textFieldType.setColumns(10);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(390);
        panel_11.add(horizontalStrut_1);
        
        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        panel_8.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_12 = new JPanel();
        panel_8.add(panel_12);
        
        JButton btnObtenir = new JButton("Obtenir");
        btnObtenir.addActionListener(this.gestionClic);
        panel_12.add(btnObtenir);
        
        Component horizontalStrut = Box.createHorizontalStrut(510);
        panel_12.add(horizontalStrut);

    }
}
