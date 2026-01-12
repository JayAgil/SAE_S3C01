package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modele.UtOracleDataSource;
import vue.FenetreLogin;
import vue.FenetrePrincipale;

public class GestionConnexion implements ActionListener {

	private FenetreLogin fenLogin;

	public GestionConnexion(FenetreLogin fenLogin) {
		this.fenLogin = fenLogin;
	}

	/**
	 * Méthode exécutée lorsqu'un bouton est cliqué. Ici, gère le bouton "Se
	 * connecter".
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton res = (JButton) e.getSource(); // Récupère le bouton cliqué

		switch (res.getText()) {
		case ("Se connecter"):
			// Récupération des informations saisies par l'utilisateur
			String username = fenLogin.getTxtUsername().getText();
			String password = new String(fenLogin.getTxtPassword().getPassword());

			// Vérifie que tous les champs sont remplis
			if (username.isEmpty() || password.isEmpty()) {
				fenLogin.getLblMessage().setText("Veuillez remplir tous les champs.");
				fenLogin.getLblMessage().setForeground(Color.RED);
			} else {
				try {
					// Tente de créer l'accès à la base Oracle avec les identifiants
					UtOracleDataSource.CreerAcces(username, password);

					// Message de succès
					fenLogin.getLblMessage().setForeground(new Color(0, 128, 0));
					fenLogin.getLblMessage().setText("Connexion réussie !");

					// Récupère la connexion et exécute des procédures stockées
					Connection cn = UtOracleDataSource.getConnectionBD();
					CallableStatement cs = cn.prepareCall("{call MSF5131A.VerifierDateLancement()}");
					CallableStatement cs2 = cn.prepareCall("{call MSF5131A.VerifierDateAnniversaire()}");
					cs.execute();
					cs2.execute();

					// Message de bienvenue et ouverture de la fenêtre principale
					JOptionPane.showMessageDialog(fenLogin, "Bienvenue, M. Millan !");
					FenetrePrincipale fp = new FenetrePrincipale();
					fp.setVisible(true);

					// Ferme la fenêtre de login
					fenLogin.dispose();
				} catch (SQLException ex) {
					// Gestion des erreurs de connexion
					fenLogin.getLblMessage().setForeground(Color.RED);
					fenLogin.getLblMessage().setText("Identifiant ou mot de passe incorrect.");
				}
			}
			break;
		}
	}
}
