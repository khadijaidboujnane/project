package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_educative";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";

    public static Connection obtenirConnexion() throws SQLException {
        return DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
    }
}
