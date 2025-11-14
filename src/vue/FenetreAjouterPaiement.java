package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterPaiement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class FenetreAjouterPaiement extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldMontant;
    private JTextField textFieldDate;
    private GestionFenetreAjouterPaiement gestionClic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() 
            {
                try {
                    FenetreAjouterPaiement frame = new FenetreAjouterPaiement();
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
    public FenetreAjouterPaiement() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
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
        panel.setLayout(null);
        
        textFieldMontant = new JTextField();
        textFieldMontant.setBounds(173, 50, 101, 19);
        panel.add(textFieldMontant);
        textFieldMontant.setColumns(10);
        
        JLabel lblMontant = new JLabel("Montant de paiement : ");
        lblMontant.setBounds(32, 50, 131, 13);
        panel.add(lblMontant);
        
        JLabel lblDate = new JLabel("Date de paiement : ");
        lblDate.setBounds(32, 73, 131, 13);
        panel.add(lblDate);
        textFieldDate = new JTextField();
        textFieldDate.setColumns(10);
        textFieldDate.setBounds(173, 73, 101, 19);
        panel.add(textFieldDate);
        
        JComboBox cbContratLocation = new JComboBox();
        cbContratLocation.setBounds(173, 99, 101, 21);
        panel.add(cbContratLocation);
        
        JLabel lblContrat = new JLabel("Choisir le contrat : ");
        lblContrat.setBounds(32, 100, 131, 13);
        panel.add(lblContrat);
        
        JLabel lblTitire = new JLabel("Ajouter Un Paiement");
        lblTitire.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTitire.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitire.setBounds(0, 10, 422, 27);
        panel.add(lblTitire);
        
        JButton btnAjout = new JButton("Ajouter");
        btnAjout.setBounds(32, 133, 85, 21);
        panel.add(btnAjout);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(127, 133, 85, 21);
        panel.add(btnRetour);
        
        gestionClic = new GestionFenetreAjouterPaiement(this);
        
        btnAjout.addActionListener(gestionClic);
        btnRetour.addActionListener(gestionClic);
    }
}