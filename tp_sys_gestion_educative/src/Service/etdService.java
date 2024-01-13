package Service;

import Modules.Etudiant;
import Modules.Filiere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class etdService {
    public static void ajouterEtudiant(Etudiant etudiant) {
        try (Connection connexion = ConexionBD.obtenirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO etudiants (nom, prenom, email, dapogee, filiere) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getEmail());
            preparedStatement.setInt(4, etudiant.getApogee());
            preparedStatement.setInt(4, etudiant.getFiliere().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Etudiant> obtenirtousEtudiants() {
        List<Etudiant> etudiants = new ArrayList<>();

        try (Connection connexion = ConexionBD.obtenirConnexion();
             Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiants")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                int apogee = resultSet.getInt("apogee");
                int filiere = resultSet.getInt("filiere");

                Etudiant etudiant = new Etudiant(nom, prenom, email, apogee,filiere);
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }



}
