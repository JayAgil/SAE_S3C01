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
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAjouterPaiement extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private GestionFenetreAjouterPaiement gestionClic;
    private JTextField textFieldDate;
    private JTextField textFieldMontant;

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
        setBounds(100, 100, 400, 451);
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
        btnRetour.addActionListener(this);
        
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(this);
        panel_2.add(btnAjouter);
        
        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this);
        panel_2.add(btnAnnuler);
        panel_2.add(btnRetour);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new GridLayout(6, 2, 0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);
        
        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        
        JLabel lblDatePaiement = new JLabel("Date paiement :");
        panel_5.add(lblDatePaiement);
        
        textFieldDate = new JTextField();
        panel_5.add(textFieldDate);
        textFieldDate.setColumns(10);
        
        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);
        
        JLabel lblMontant = new JLabel("Montant paiement :");
        panel_6.add(lblMontant);
        
        textFieldMontant = new JTextField();
        panel_6.add(textFieldMontant);
        textFieldMontant.setColumns(10);
        
        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7);
        
        JLabel lblContratLocation = new JLabel("Contrat location :");
        panel_7.add(lblContratLocation);
        
        JComboBox comboBox = new JComboBox();
        panel_7.add(comboBox);
        
        JPanel panel_8 = new JPanel();
        panel_3.add(panel_8);
        
        JPanel panel_9 = new JPanel();
        panel_3.add(panel_9);
        
     
    }
	public void actionPerformed(ActionEvent e) {
	}
}