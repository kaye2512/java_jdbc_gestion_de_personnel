package org.gestionPersonnel.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    static final String DB_URL = "jdbc:mysql://localhost:3306/gestionpersonel";
    static final String USER = "root";
    static final String PASS = "";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void close(Connection connexion) throws SQLException{
        connexion.close();
    }
}
