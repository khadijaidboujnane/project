package Service;

import Modules.Departement;
import Modules.Enseignant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnsgService {
    public static void ajouterEnseignant(Enseignant enseignant) throws SQLException {
        try (Connection connexion = ConexionBD.obtenirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO enseignants (nom, prenom, email, matiere) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, enseignant.getNom());
            preparedStatement.setString(2, enseignant.getPrenom());
            preparedStatement.setString(3, enseignant.getEmail());
            preparedStatement.setString(3, enseignant.getGrade());



            preparedStatement.executeUpdate();
        }
    }

    public static List<Enseignant> obtenirTousLesEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();

        try (Connection connexion = ConexionBD.obtenirConnexion();
             Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM enseignants")) {

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String grade = resultSet.getString("grade");
                Departement departement = resultSet.getStatement("departement");

                Enseignant enseignant = new Enseignant(nom, prenom, email, grade, departement);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enseignants;
    }



}
