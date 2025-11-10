package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreDiagnostic extends JInternalFrame
    implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldDateValidite;
    private JTextField textFieldTypeDiagnostique;

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
        setBounds(100, 100, 539, 446);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelMenuBar = new JPanel();
        getContentPane().add(panelMenuBar, BorderLayout.NORTH);
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

        JPanel panelContent = new JPanel();
        getContentPane().add(panelContent, BorderLayout.CENTER);
        panelContent.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panelContent.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLigneRealisation = new JPanel();
        panelNorth.add(panelLigneRealisation);
        panelLigneRealisation.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLblDateRealisation = new JPanel();
        FlowLayout fl_panelLblDateRealisation = (FlowLayout) panelLblDateRealisation
            .getLayout();
        fl_panelLblDateRealisation.setAlignment(FlowLayout.RIGHT);
        panelLigneRealisation.add(panelLblDateRealisation);

        JLabel lblRealisation = new JLabel("Date Realisation : ");
        lblRealisation.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLblDateRealisation.add(lblRealisation);

        JPanel panelChoixDateRealisation = new JPanel();
        panelLigneRealisation.add(panelChoixDateRealisation);
        panelChoixDateRealisation
            .setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JComboBox comboBoxDateRealisation = new JComboBox();
        comboBoxDateRealisation.setModel(new DefaultComboBoxModel(
            new String[] { "Date1", "Date2", "9/11", "476 ap. J.-C." }));
        panelChoixDateRealisation.add(comboBoxDateRealisation);

        JPanel panelVide = new JPanel();
        panelNorth.add(panelVide);

        JPanel panelValidite = new JPanel();
        panelNorth.add(panelValidite);
        panelValidite.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLblDateValidite = new JPanel();
        FlowLayout fl_panelLblDateValidite = (FlowLayout) panelLblDateValidite
            .getLayout();
        fl_panelLblDateValidite.setAlignment(FlowLayout.RIGHT);
        panelValidite.add(panelLblDateValidite);

        JLabel lblDateValidite = new JLabel("Date de validite : ");
        lblDateValidite.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLblDateValidite.add(lblDateValidite);

        JPanel panelTxtDateValidite = new JPanel();
        panelTxtDateValidite.setLayout(null);
        panelValidite.add(panelTxtDateValidite);

        textFieldDateValidite = new JTextField();
        textFieldDateValidite.setColumns(10);
        textFieldDateValidite.setBounds(5, 5, 101, 19);
        panelTxtDateValidite.add(textFieldDateValidite);

        JPanel panelVide2 = new JPanel();
        panelNorth.add(panelVide2);

        JPanel panelType = new JPanel();
        panelNorth.add(panelType);
        panelType.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panelLblType = new JPanel();
        FlowLayout fl_panelLblType = (FlowLayout) panelLblType.getLayout();
        fl_panelLblType.setAlignment(FlowLayout.RIGHT);
        panelType.add(panelLblType);

        JLabel lblTypeDiagnostique = new JLabel("Type de diagnostique : ");
        lblTypeDiagnostique.setHorizontalAlignment(SwingConstants.RIGHT);
        panelLblType.add(lblTypeDiagnostique);

        JPanel panelTxtType = new JPanel();
        panelType.add(panelTxtType);
        panelTxtType.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        textFieldTypeDiagnostique = new JTextField();
        textFieldTypeDiagnostique.setColumns(10);
        panelTxtType.add(textFieldTypeDiagnostique);

        JPanel panelBtnObtenir = new JPanel();
        FlowLayout fl_panelBtnObtenir = (FlowLayout) panelBtnObtenir
            .getLayout();
        fl_panelBtnObtenir.setAlignment(FlowLayout.RIGHT);
        panelNorth.add(panelBtnObtenir);

        JButton btnObtenir = new JButton("Obtenir");
        panelBtnObtenir.add(btnObtenir);

        JPanel panelCenter = new JPanel();
        panelContent.add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panelSouth.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panelContent.add(panelSouth, BorderLayout.SOUTH);

        JButton btnRetour = new JButton("Retour");
        panelSouth.add(btnRetour);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
    }
}
