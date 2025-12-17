package TestModele;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import modele.UtOracleDataSource;

public class TestConnection {

    public static void main(String[] arg0) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Code utilisateur ? ");
        String nom = input.nextLine();
        System.out.println("Mot de passe ? ");
        String mdp = input.nextLine();
        input.close();
        try {
            System.out.println("Vous êtes : " + nom);
            UtOracleDataSource.CreerAcces(nom, mdp);
            Connection cn = UtOracleDataSource.getConnectionBD();
            System.out.println("Connexion établie...");
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Connexion impossible");
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        UtOracleDataSource.Deconnecter();
        System.out.println("Déconnection");
    }
}
