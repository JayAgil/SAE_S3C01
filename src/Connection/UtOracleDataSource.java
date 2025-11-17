package Connection;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class UtOracleDataSource extends OracleDataSource {

    private static UtOracleDataSource bd = null;
    private static Connection connection;

    private UtOracleDataSource(String login, String mdp) throws SQLException {
        this.setURL("jdbc:oracle:thin:@telline.univ-tlse3.fr" + ":1521:etupre");
        this.setUser(login);
        this.setPassword(mdp);
    }

    public static void CreerAcces(String login, String mdp)
        throws SQLException {
        bd = new UtOracleDataSource(login, mdp);
        connection = bd.getConnection();
    }

    public static Connection getConnexionBD() throws SQLException {
        return connection;
    }

    public static void Deconnecter() throws SQLException {
        connection.close();
        connection = null;
    }

}
