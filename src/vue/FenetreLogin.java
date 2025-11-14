package vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FenetreLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblMessage;

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            try {
                FenetreLogin frame = new FenetreLogin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FenetreLogin() {
        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 350);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelTitre = new JPanel();
        panelTitre.setBounds(10, 10, 446, 60);
        panelTitre.setBackground(Color.WHITE);
        panelTitre.setLayout(new GridLayout(2, 1));
        contentPane.add(panelTitre);

        JLabel titre1 = new JLabel("Bienvenue !");
        titre1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titre1.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitre.add(titre1);

        JLabel titre2 = new JLabel(
            "Veuillez vous connecter pour accéder à votre espace personnel.");
        titre2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        titre2.setHorizontalAlignment(SwingConstants.CENTER);
        panelTitre.add(titre2);

        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(10, 70, 446, 233);
        panelLogin.setBackground(Color.WHITE);
        contentPane.add(panelLogin);
        panelLogin.setLayout(null);

        JLabel lblUsername = new JLabel("Nom d'utilisateur :");
        lblUsername.setBounds(133, 22, 116, 20);
        lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelLogin.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(133, 52, 195, 22);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setColumns(10);
        txtUsername
            .setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
        panelLogin.add(txtUsername);

        JLabel lblPassword = new JLabel("Mot de passe :");
        lblPassword.setBounds(133, 84, 94, 20);
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelLogin.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(133, 114, 195, 22);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword
            .setBorder(new LineBorder(new Color(200, 200, 200), 1, true));
        panelLogin.add(txtPassword);

        lblMessage = new JLabel("");
        lblMessage.setBounds(10, 191, 446, 20);
        panelLogin.add(lblMessage);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblMessage.setForeground(Color.RED);
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnLogin = new JButton("Se connecter");
        btnLogin.setBounds(133, 177, 196, 34);
        panelLogin.add(btnLogin);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(new LineBorder(new Color(180, 180, 180), 1, true));
        btnLogin.setBackground(new Color(235, 235, 235));

        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(245, 245, 245));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(235, 235, 235));
            }
        });

        btnLogin.addActionListener(e->methodLogin());
    }

    private void methodLogin() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String usernameOri = "admin";
        String mDPOri = "1234";

        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("Veuillez remplir tous les champs.");
            lblMessage.setForeground(Color.RED);
        } else if (username.equals(usernameOri) && password.equals(mDPOri)) {
            lblMessage.setForeground(new Color(0, 128, 0));
            lblMessage.setText("Connexion réussie !");
            JOptionPane.showMessageDialog(this,
                "Bienvenue, " + username + " !");
        } else {
            lblMessage.setForeground(Color.RED);
            lblMessage.setText("Identifiant ou mot de passe incorrect.");
        }
    }
}