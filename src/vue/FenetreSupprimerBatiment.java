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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class FenetreSupprimerBatiment extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldAdresse;
    private JTextField textFieldDate;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FenetreSupprimerBatiment frame = new FenetreSupprimerBatiment();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FenetreSupprimerBatiment() {

        setBounds(100, 100, 400, 451);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_10 = new JPanel();
        panel_10.setLayout(new BorderLayout(0, 0));
        getContentPane().add(panel_10, BorderLayout.CENTER);

        JPanel panelNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        panel_10.add(panelNorth, BorderLayout.NORTH);

        JLabel lblTitre1 = new JLabel("Supprimer un bâtiment");
        lblTitre1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelNorth.add(lblTitre1);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        panelNorth.add(verticalStrut);

        JPanel panelSouth = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelSouth.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel_10.add(panelSouth, BorderLayout.SOUTH);

        JButton btnAnnuler = new JButton("Annuler");
        panelSouth.add(btnAnnuler);

        JButton btnSuprimer = new JButton("Supprimer");
        btnSuprimer.setBackground(Color.WHITE);
        btnSuprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panelSouth.add(btnSuprimer);

        btnSuprimer.addActionListener(this);
        btnAnnuler.addActionListener(this);

        JPanel panelCenter = new JPanel(new BorderLayout(0, 0));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panel_10.add(panelCenter, BorderLayout.CENTER);

        JLabel lblTitre2 = new JLabel("Quel bâtiment voulez-vous supprimer ?");
        lblTitre2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitre2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCenter.add(lblTitre2, BorderLayout.NORTH);

        JPanel panelCenterCenter = new JPanel(new GridLayout(2, 1, 0, 10));
        panelCenterCenter.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        panelCenter.add(panelCenterCenter, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCenterCenter.add(panel_2);

        JComboBox<String> cbBatiment = new JComboBox<>();
        cbBatiment.setModel(new DefaultComboBoxModel<>(new String[]{"bat 1", "bat2", "bat3", "batman"}));
        cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cbBatiment.setPreferredSize(new Dimension(150, 28));
        panel_2.add(cbBatiment);

        JPanel panel_1 = new JPanel(new GridLayout(2, 1, 0, 5));
        panelCenterCenter.add(panel_1);

        JPanel panel_4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JLabel lblTitre = new JLabel("Informations bâtiment");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_4.add(lblTitre);
        panel_1.add(panel_4);
        
        JPanel panel = new JPanel();
        panel_1.add(panel);
        panel.setLayout(new GridLayout(3, 2, 0, 0));
        
        JLabel lblAdresse = new JLabel("Adresse :");
        panel.add(lblAdresse);
        
        textFieldAdresse = new JTextField();
        panel.add(textFieldAdresse);
        textFieldAdresse.setColumns(10);
        
        JLabel lblDate = new JLabel("Date de construction :");
        panel.add(lblDate);
        
        textFieldDate = new JTextField();
        panel.add(textFieldDate);
        textFieldDate.setColumns(10);
        
        JLabel lblNbBien = new JLabel("Nombre de bien louable :");
        panel.add(lblNbBien);
        
        JSpinner spinnerNbBien = new JSpinner();
        panel.add(spinnerNbBien);

        
        JLabel lblVerification = new JLabel("L'action de supprimer est définitive !");
        lblVerification.setHorizontalAlignment(SwingConstants.CENTER);
        lblVerification.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panelCenter.add(lblVerification, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (((JButton) e.getSource()).getText()) {
        case "Annuler":
            this.dispose();
            break;
        case "Supprimer":
            this.dispose();
            break;
        }
    }
}
