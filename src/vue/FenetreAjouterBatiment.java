package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.GestionFenetreAjouterBatiment;

import java.awt.Component;
import javax.swing.Box;

public class FenetreAjouterBatiment extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldAdresse;
    private JTextField textFieldDate;
    private GestionFenetreAjouterBatiment gestionClic;

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
                    frame.setResizable(false);
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
    	setResizable(false);
    	this.gestionClic = new GestionFenetreAjouterBatiment(this); 
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        getContentPane().add(panel_10, BorderLayout.CENTER);
        panel_10.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        panel_10.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblTitre = new JLabel("Ajout d'un bâtiment");
        panelNorth.add(lblTitre);
        lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        Component verticalStrut = Box.createVerticalStrut(100);
        panelNorth.add(verticalStrut);

        JPanel panelSouth = new JPanel();
        panel_10.add(panelSouth, BorderLayout.SOUTH);

        JButton btnAjouter = new JButton("Ajouter");
        panelSouth.add(btnAjouter);

        JButton btnAnnuler = new JButton("Annuler");
        panelSouth.add(btnAnnuler);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this.gestionClic);
        panelSouth.add(btnRetour);
        
        Component verticalStrut_1 = Box.createVerticalStrut(100);
        panelSouth.add(verticalStrut_1);
        btnAnnuler.addActionListener(this.gestionClic);
        btnAjouter.addActionListener(this.gestionClic);

        JPanel panelCenter = new JPanel();
        panel_10.add(panelCenter);
        panelCenter.setLayout(new GridLayout(1, 2, 0, 0));

        JPanel panel_1 = new JPanel();
        panelCenter.add(panel_1);
        panel_1.setLayout(new GridLayout(2, 1, 0, 0));

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

    }
    
    public List<JTextField> getAllTextFields() {
        List<JTextField> fields = new ArrayList<>();
        fields.add(textFieldAdresse);
        fields.add(textFieldDate);
        return fields;
    }

    
}
