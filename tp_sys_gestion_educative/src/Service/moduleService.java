package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modules.Module ;

public class moduleService {
    public static void ajouterModule(Module module) throws SQLException {
        try (Connection connexion = ConexionBD.obtenirConnexion();
             PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO modules (nom, description, responsable, enseignant_id) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, module.getIntitule());
            preparedStatement.setString(2, module.getProfesseur());
            preparedStatement.setString(3, module.getFiliere().getIntitule());


            preparedStatement.executeUpdate();
        }
    }

    public static List<Module> obtenirTousLesModules() {
        List<Module> modules = new ArrayList<>();

        try (Connection connexion = ConexionBD.obtenirConnexion();
             Statement statement = connexion.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM modules")) {

            while (resultSet.next()) {
                String intitule = resultSet.getString("intitule");
                String filiere = resultSet.getString("filiere");
                String proffesseur = resultSet.getString("professseur");


                Module module = new Module(intitule, filiere , proffesseur,);
                modules.add(module);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modules;
    }


}
