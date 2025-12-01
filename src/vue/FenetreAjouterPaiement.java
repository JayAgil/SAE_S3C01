package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionFenetreAjouterPaiement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import javax.swing.Box;

public class FenetreAjouterPaiement extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionFenetreAjouterPaiement gestionClic;
    private JTextField textFieldDate;
    private JTextField textFieldMontant;
    private JTextField textFieldIdPaiement;

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
    	setResizable(false);
    	this.gestionClic = new GestionFenetreAjouterPaiement(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);
        
        JLabel lblTitre = new JLabel("Ajouter paiement");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(lblTitre);
        
        Component verticalStrut = Box.createVerticalStrut(60);
        panel.add(verticalStrut);
        
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.SOUTH);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(this.gestionClic);
        panel_2.add(btnAjouter);
        
        JButton btnVider = new JButton("Vider");
        btnVider.addActionListener(this.gestionClic);
        
        Component verticalStrut_1 = Box.createVerticalStrut(60);
        panel_2.add(verticalStrut_1);
        panel_2.add(btnVider);
        panel_2.add(btnRetour);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(null);
        
        JLabel lblMontant = new JLabel("Montant paiement :");
        lblMontant.setBounds(74, 174, 108, 13);
        panel_3.add(lblMontant);
        
        textFieldMontant = new JTextField();
        textFieldMontant.setBounds(234, 170, 96, 19);
        panel_3.add(textFieldMontant);
        textFieldMontant.setColumns(10);
        
        JLabel lblContratLocation = new JLabel("Contrat location :");
        lblContratLocation.setBounds(74, 120, 96, 13);
        panel_3.add(lblContratLocation);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(234, 116, 96, 21);
        panel_3.add(comboBox);
        
        textFieldDate = new JTextField();
        textFieldDate.setBounds(234, 220, 96, 19);
        panel_3.add(textFieldDate);
        textFieldDate.setColumns(10);
        
        JLabel lblDatePaiement = new JLabel("Date paiement :");
        lblDatePaiement.setBounds(75, 224, 108, 13);
        panel_3.add(lblDatePaiement);
        
        textFieldIdPaiement = new JTextField();
        textFieldIdPaiement.setBounds(234, 68, 96, 19);
        panel_3.add(textFieldIdPaiement);
        textFieldIdPaiement.setColumns(10);
        
        JLabel lblIdPaiement = new JLabel("ID Paiement :");
        lblIdPaiement.setBounds(74, 72, 96, 13);
        panel_3.add(lblIdPaiement);
        
     
    }
    
    public List<JTextField> getPaiementTextFields() {
        List<JTextField> fields = new ArrayList<>();
        fields.add(textFieldDate);
        fields.add(textFieldMontant);
        fields.add(textFieldIdPaiement);
        return fields;
    }
}