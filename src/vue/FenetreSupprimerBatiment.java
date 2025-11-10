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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FenetreSupprimerBatiment extends JInternalFrame
    implements ActionListener {

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreSupprimerBatiment frame = new FenetreSupprimerBatiment();
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
    public FenetreSupprimerBatiment() {
        setBounds(100, 100, 309, 256);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        getContentPane().add(panel_10, BorderLayout.CENTER);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panel_10.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Suprimer un batiment");
        panelNorth.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JPanel panelSouth = new JPanel();
        panel_10.add(panelSouth, BorderLayout.SOUTH);

        JButton btnAnnuler = new JButton("Annuler");
        panelSouth.add(btnAnnuler);

        JButton btnSuprimer = new JButton("Suprimer");
        btnSuprimer.setBackground(new Color(220, 20, 60));
        btnSuprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
        panelSouth.add(btnSuprimer);
        btnSuprimer.addActionListener(this);
        btnAnnuler.addActionListener(this);

        JPanel panelCenter = new JPanel();
        panel_10.add(panelCenter);
        panelCenter.setLayout(new BorderLayout(0, 0));

        JPanel panelCenterCenter = new JPanel();
        panelCenter.add(panelCenterCenter);
        panelCenterCenter.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel(
            "Quel batiment voulez-vous supprimer ?");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panelCenterCenter.add(lblNewLabel_1, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panelCenterCenter.add(panel, BorderLayout.CENTER);

        JComboBox<String> cbBatiment = new JComboBox<String>();
        cbBatiment.setModel(new DefaultComboBoxModel(
            new String[] { "bat 1", "bat2", "bat3", "batman" }));
        cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(cbBatiment);

        JPanel panelCenterNorth = new JPanel();
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);

        Component verticalStrut = Box.createVerticalStrut(20);
        verticalStrut.setPreferredSize(new Dimension(0, 10));
        panelCenterNorth.add(verticalStrut);

        JLabel lblVerification = new JLabel(
            "L'action de supprimer est définitive");
        lblVerification.setHorizontalAlignment(SwingConstants.CENTER);
        panelCenter.add(lblVerification, BorderLayout.SOUTH);

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

        JLabel footerLabel = new JLabel(
            "Developpé par Koshua, Jay, Aneesa, Luca et Franck");
        footerPanel.add(footerLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Valider":
            this.dispose();
            break;
        case "Annuler":
            this.dispose();
            break;
        }
    }
}
