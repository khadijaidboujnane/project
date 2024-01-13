package Service;

import Modules.Departement;
import Modules.Enseignant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeptService {
    public static void ajouterDepartement(Departement departement) {
        try (Connection connexion = ConexionBD.obtenirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO departements (intitule, responsable_nom, responsable_prenom) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, departement.getIntitule());
            preparedStatement.setString(2, departement.getResponsable().getNom());
            preparedStatement.setString(3, departement.getResponsable().getPrenom());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Departement> obtenirTousLesDépartements() {
        List<Departement> départements = new ArrayList<>();

        try (Connection connexion = ConexionBD.obtenirConnexion();
             Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM departements")) {

            while (resultSet.next()) {
                String intitulé = resultSet.getString("intitule");
                String responsableNom = resultSet.getString("responsable_nom");
                String responsablePrénom = resultSet.getString("responsable_prenom");

                // Créer un département et l'ajouter à la liste
                Departement département = new Departement(intitulé, new Enseignant(responsableNom, responsablePrénom, "", "", null));
                départements.add(département);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return départements;
    }



}
        

