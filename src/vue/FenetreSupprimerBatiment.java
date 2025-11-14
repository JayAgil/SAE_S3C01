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
import javax.swing.JTable;
import javax.swing.JTextField;

public class FenetreSupprimerBatiment extends JInternalFrame
    implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

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
        setBounds(100, 100, 400, 451);
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
        panel.setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel panel_2 = new JPanel();
        panel.add(panel_2);
        
        JComboBox<String> cbBatiment = new JComboBox<String>();
        cbBatiment.setModel(new DefaultComboBoxModel(
            new String[] { "bat 1", "bat2", "bat3", "batman" }));
        cbBatiment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_2.add(cbBatiment);
        
        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(2, 1, 0, 0));
        
        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        
        JLabel lblTitre = new JLabel("Informations batiment");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_4.add(lblTitre);
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 2, 0, 0));
        
        JLabel lblAdresse = new JLabel("Adresse :");
        panel_3.add(lblAdresse);
        
        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        
        textField = new JTextField();
        panel_5.add(textField);
        textField.setColumns(10);
        
        JLabel lblDatedeConstruction = new JLabel("Date de construction :");
        panel_3.add(lblDatedeConstruction);
        
        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);
        
        textField_1 = new JTextField();
        panel_6.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNbBienLouable = new JLabel("Nombre de bien louable :");
        panel_3.add(lblNbBienLouable);
        
        JPanel panel_7 = new JPanel();
        panel_3.add(panel_7);
        
        textField_2 = new JTextField();
        panel_7.add(textField_2);
        textField_2.setColumns(10);

        JPanel panelCenterNorth = new JPanel();
        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);

        Component verticalStrut = Box.createVerticalStrut(20);
        verticalStrut.setPreferredSize(new Dimension(0, 10));
        panelCenterNorth.add(verticalStrut);

        JLabel lblVerification = new JLabel(
            "L'action de supprimer est définitive");
        lblVerification.setHorizontalAlignment(SwingConstants.CENTER);
        panelCenter.add(lblVerification, BorderLayout.SOUTH);

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
