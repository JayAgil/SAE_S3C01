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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreCompteurs extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableCompteurs;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FenetreCompteurs frame = new FenetreCompteurs();
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
    public FenetreCompteurs() {
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

        
        new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
            },
            new String[] {
                "Type", "Date", "Index ancien", "Index nouveau", 
                "Consommation", "Partie Variable", "Partie Fixe", "Total"
            }
        ) {
            boolean[] columnEditables = new boolean[] {
                false, false, false, false, false, false, true, false
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };

     
        tableCompteurs = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Type", "Date", "Bien louable", "Index ancien", "Index nouveau", "Consommation", "Partie Variable", "Partie Fixe", "Total"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false, false, true, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });

        JScrollPane scrollPane = new JScrollPane(tableCompteurs);
        panel.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(700, 300));
        
        JPanel panel_butons = new JPanel();
        panel.add(panel_butons, BorderLayout.SOUTH);
        panel_butons.setLayout(new GridLayout(0, 2, 0, 0));
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this);
        panel_butons.add(btnRetour);
        
        JButton btnAjouterCompteur = new JButton("Ajouter compteur");
        btnAjouterCompteur.addActionListener(this);
        panel_butons.add(btnAjouterCompteur);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        panel_1.add(verticalStrut);
        
        JLabel lblTitre = new JLabel("Compteurs");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_1.add(lblTitre);

    }
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Retour" :
			break;
		case "Ajouter compteur" :
			break;
		}
	}
}