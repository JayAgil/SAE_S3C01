package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.UtOracleDataSource;
import vue.FenetreLogin;
import vue.FenetrePrincipale;

public class GestionConnexion implements ActionListener{
	
	private FenetreLogin fenLogin;
	
	public GestionConnexion (FenetreLogin fenLogin) {
		this.fenLogin = fenLogin;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        JButton res = (JButton) e.getSource();
        switch (res.getText()) {
        case ("Se connecter"):
            String username = fenLogin.getTxtUsername().getText();
            String password = new String(
                fenLogin.getTxtPassword().getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                fenLogin.getLblMessage()
                    .setText("Veuillez remplir tous les champs.");
                fenLogin.getLblMessage().setForeground(Color.RED);
            } else {
                try {
                    UtOracleDataSource.CreerAcces(username, password);
                    fenLogin.getLblMessage()
                        .setForeground(new Color(0, 128, 0));
                    fenLogin.getLblMessage().setText("Connexion réussie !");
                    JOptionPane.showMessageDialog(fenLogin,
                        "Bienvenue, M. Millan !");
                    FenetrePrincipale fp = new FenetrePrincipale();
                    fp.setVisible(true);
                    fenLogin.dispose();
                } catch (SQLException ex) {
                    fenLogin.getLblMessage().setForeground(Color.RED);
                    fenLogin.getLblMessage()
                        .setText("Identifiant ou mot de passe incorrect.");
                }
            }
        }
	}
}
