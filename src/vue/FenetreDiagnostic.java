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
import java.awt.Font;

public class FenetreDiagnostic extends JInternalFrame
    implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldDateValide;
    private JTextField textFieldType;

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
        setBounds(100, 100, 726, 442);
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
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblTitre = new JLabel("Diagnostic");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(lblTitre, BorderLayout.NORTH);
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.SOUTH);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this);
        panel_1.add(btnRetour);
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, BorderLayout.NORTH);
        panel_3.setLayout(new GridLayout(4, 0, 0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);
        panel_4.setLayout(new GridLayout(1, 2, 0, 0));
        
        JLabel lbldateRealisation = new JLabel("Date de realisation :");
        panel_4.add(lbldateRealisation);
        
        JPanel panel_8 = new JPanel();
        panel_4.add(panel_8);
        
        JComboBox comboBoxDateRealise = new JComboBox();
        panel_8.add(comboBoxDateRealise);
        
        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        panel_5.setLayout(new GridLayout(1, 2, 0, 0));
        
        JLabel lblDateValide = new JLabel("Date de validite :");
        panel_5.add(lblDateValide);
        
        JPanel panel_9 = new JPanel();
        panel_5.add(panel_9);
        
        textFieldDateValide = new JTextField();
        panel_9.add(textFieldDateValide);
        textFieldDateValide.setColumns(10);
        
        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);
        panel_6.setLayout(new GridLayout(1, 2, 0, 0));
        
        JLabel lblType = new JLabel("Type diagnostic :");
        panel_6.add(lblType);
        
        JPanel panel_10 = new JPanel();
        panel_6.add(panel_10);
        
        textFieldType = new JTextField();
        panel_10.add(textFieldType);
        textFieldType.setColumns(10);
        
        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7);
        
        JButton btnObtenir = new JButton("Obtenir");
        btnObtenir.addActionListener(this);
        panel_7.add(btnObtenir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
