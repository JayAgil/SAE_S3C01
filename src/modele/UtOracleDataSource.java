package modele;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class UtOracleDataSource extends OracleDataSource {

	private static UtOracleDataSource bd = null;
	private static Connection connection = null;

	/**
	 * Constructeur privé pour créer la source de données Oracle. Définit l'URL, le
	 * login et le mot de passe pour la connexion.
	 *
	 * @param login utilisateur de la base
	 * @param mdp   mot de passe de l'utilisateur
	 * @throws SQLException si une erreur de connexion survient
	 */
	private UtOracleDataSource(String login, String mdp) throws SQLException {
		this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr" + ":1521:etupre");
		this.setUser(login);
		this.setPassword(mdp);
	}

	/**
	 * Crée l'accès à la base de données en initialisant la source de données et en
	 * récupérant la connexion unique.
	 *
	 * @param login utilisateur de la base
	 * @param mdp   mot de passe de l'utilisateur
	 * @throws SQLException si la connexion échoue
	 */
	public static void CreerAcces(String login, String mdp) throws SQLException {
		bd = new UtOracleDataSource(login, mdp);
		connection = bd.getConnection();
	}

	/**
	 * Retourne la connexion unique à la base de données.
	 *
	 * @return connexion Oracle
	 */
	public static Connection getConnectionBD() {
		return connection;
	}

	/**
	 * Ferme la connexion à la base de données et réinitialise la variable de
	 * connexion.
	 *
	 * @throws SQLException si la fermeture échoue
	 */
	public static void Deconnecter() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
