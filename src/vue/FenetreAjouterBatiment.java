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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreAjouterBatiment extends JInternalFrame
    implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldAdresse;
    private JTextField textFieldDate;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreAjouterBatiment frame = new FenetreAjouterBatiment();
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
    public FenetreAjouterBatiment() {
        setBounds(100, 100, 309, 256);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        getContentPane().add(panel_10, BorderLayout.CENTER);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panel_10.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Ajout d'un batiment");
        panelNorth.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        JPanel panelSouth = new JPanel();
        panel_10.add(panelSouth, BorderLayout.SOUTH);

        JButton btnValider = new JButton("Valider");
        panelSouth.add(btnValider);

        JButton btnAnnuler = new JButton("Annuler");
        panelSouth.add(btnAnnuler);
        
        JButton btnRetour = new JButton("Retour");
        panelSouth.add(btnRetour);
        btnAnnuler.addActionListener(this);
        btnValider.addActionListener(this);

        JPanel panelCenter = new JPanel();
        panel_10.add(panelCenter);
        panelCenter.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_1 = new JPanel();
        panelCenter.add(panel_1);
        panel_1.setLayout(new GridLayout(3, 1, 0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel_2.add(panel_8);

        JLabel lblAdresse = new JLabel("Adresse : ");
        panel_8.add(lblAdresse);
        lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panel_9 = new JPanel();
        panel_2.add(panel_9);
        panel_9.setLayout(null);

        textFieldAdresse = new JTextField();
        textFieldAdresse.setBounds(5, 5, 101, 19);
        panel_9.add(textFieldAdresse);
        textFieldAdresse.setColumns(10);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_6);

        JLabel lblDateConstruction = new JLabel("Date de construction : ");
        panel_6.add(lblDateConstruction);
        lblDateConstruction.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7);
        panel_7.setLayout(null);

        textFieldDate = new JTextField();
        textFieldDate.setBounds(5, 5, 101, 19);
        panel_7.add(textFieldDate);
        textFieldDate.setColumns(10);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        panel_4.add(panel_5);

        JLabel lblNbBienLouable = new JLabel("Nombre de bien louable : ");
        panel_5.add(lblNbBienLouable);
        lblNbBienLouable.setHorizontalAlignment(SwingConstants.RIGHT);

        JPanel panel = new JPanel();
        panel_4.add(panel);
        panel.setLayout(null);

        JSpinner spinnerNbBienLouable = new JSpinner();
        spinnerNbBienLouable.setBounds(5, 5, 100, 20);
        panel.add(spinnerNbBienLouable);

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
