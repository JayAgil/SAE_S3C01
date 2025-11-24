package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FenetreAjouterCharge extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JTextField txtTypeCharge;
    private JTextField txtMontant;
    private JTextField txtDate;
    private JTextField txtCommentaire;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = new JFrame();
                frame.setBounds(100, 100, 600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JDesktopPane desktopPane = new JDesktopPane();
                frame.setContentPane(desktopPane);

                FenetreAjouterCharge internalFrame = new FenetreAjouterCharge();
                internalFrame.setVisible(true);
                desktopPane.add(internalFrame);

                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FenetreAjouterCharge() {
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setBounds(50, 50, 600, 400);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelHeader = new JPanel();
        JLabel lblTitre = new JLabel("Ajouter charge");
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 15));
        panelHeader.add(lblTitre);

        Component verticalStrut = Box.createVerticalStrut(50);
        panelHeader.add(verticalStrut);

        getContentPane().add(panelHeader, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridBagLayout());
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        Insets pad = new Insets(10, 10, 10, 10);

        // Row 1
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = pad;
        c1.anchor = GridBagConstraints.LINE_END;
        c1.gridx = 0;
        c1.gridy = 0;
        panelCenter.add(new JLabel("Type charge :"), c1);

        GridBagConstraints c2 = new GridBagConstraints();
        c2.insets = pad;
        c2.anchor = GridBagConstraints.LINE_START;
        c2.gridx = 1;
        c2.gridy = 0;
        txtTypeCharge = new JTextField(15);
        panelCenter.add(txtTypeCharge, c2);

        // Row 2
        GridBagConstraints c3 = new GridBagConstraints();
        c3.insets = pad;
        c3.anchor = GridBagConstraints.LINE_END;
        c3.gridx = 0;
        c3.gridy = 1;
        panelCenter.add(new JLabel("Montant :"), c3);

        GridBagConstraints c4 = new GridBagConstraints();
        c4.insets = pad;
        c4.anchor = GridBagConstraints.LINE_START;
        c4.gridx = 1;
        c4.gridy = 1;
        txtMontant = new JTextField(15);
        panelCenter.add(txtMontant, c4);

        // Row 3
        GridBagConstraints c5 = new GridBagConstraints();
        c5.insets = pad;
        c5.anchor = GridBagConstraints.LINE_END;
        c5.gridx = 0;
        c5.gridy = 2;
        panelCenter.add(new JLabel("Date :"), c5);

        GridBagConstraints c6 = new GridBagConstraints();
        c6.insets = pad;
        c6.anchor = GridBagConstraints.LINE_START;
        c6.gridx = 1;
        c6.gridy = 2;
        txtDate = new JTextField(15);
        panelCenter.add(txtDate, c6);

        // Row 4
        GridBagConstraints c7 = new GridBagConstraints();
        c7.insets = pad;
        c7.anchor = GridBagConstraints.LINE_END;
        c7.gridx = 0;
        c7.gridy = 3;
        panelCenter.add(new JLabel("Commentaire :"), c7);

        GridBagConstraints c8 = new GridBagConstraints();
        c8.insets = pad;
        c8.anchor = GridBagConstraints.LINE_START;
        c8.gridx = 1;
        c8.gridy = 3;
        txtCommentaire = new JTextField(15);
        panelCenter.add(txtCommentaire, c8);

        JPanel panelFooter = new JPanel();

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(this);

        JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.addActionListener(this);

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.addActionListener(this);

        panelFooter.add(btnRetour);
        panelFooter.add(btnAnnuler);
        panelFooter.add(btnAjouter);

        getContentPane().add(panelFooter, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
