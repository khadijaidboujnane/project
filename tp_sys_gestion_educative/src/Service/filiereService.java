package Service;

import Control.deptControl;
import Modules.Departement;
import Modules.Enseignant;
import Modules.Filiere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class filiereService {
    public static void ajouterFiliere(Filiere filiere) {
        try (Connection connexion = ConexionBD.obtenirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO filieres (intitule, responsable, departement) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, filiere.getIntitule());
            preparedStatement.setString(2, filiere.getResponsable().getNom());
            preparedStatement.setInt(4, filiere.getDepartement().getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Filiere> obtenirToutesLesFilieres() {
        List<Filiere> filieres = new ArrayList<>();

        try (Connection connexion = ConexionBD.obtenirConnexion();
             Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM filieres")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String intitule = resultSet.getString("intitule");
                String responsable= resultSet.getString("responsable_nom");

                int departementId = resultSet.getInt("departement_id");

                Enseignant responsable;
                responsable = new Enseignant(responsable, , "", "", null);
                Departement departement = deptControl.chercherDepartementById(departementId);

                Filiere filiere = new Filiere(id, intitule, responsable, departement);
                filieres.add(filiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return filieres;
    }


}
