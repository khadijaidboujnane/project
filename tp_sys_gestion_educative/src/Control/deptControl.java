package Control;

import Modules.Departement;
import Modules.Enseignant;

import java.util.List;
import java.util.Scanner;

public class deptControl {
    public static Departement creerDepartement(String intitule, Enseignant responsable) {
        return new Departement(intitule, responsable);
    }

    // Méthode pour ajouter un département
    public static void ajouterDepartement(List<Departement> departements, Departement departement) {
        departements.add(departement);
    }

    public static void supprimerDepartementById(List<Departement> departements, int departementId) {
        departements.removeIf(dept -> dept.getId() == departementId);
    }

    public static Departement chercherDepartementById(List<Departement> departements, int departementId) {
        return departements.stream()
                .filter(dept -> dept.getId() == departementId)
                .findFirst()
                .orElse(null);

    }



    public void moduleAction() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Actions pour les departement    :");
            System.out.println("1. Ajouter une departement");
            System.out.println("2. supprimer une departenment ");
            System.out.println("3.chercher une departement  by id ");

            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterDepartement();
                    break;
                case 2:
                    supprimerDepartementById();
                    break;
                case 3:
                    chercherDepartementById();
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Votre choix est incorrect");
            }
        }
    }

    private void ajouterDepartement() {
    }

    private void supprimerDepartementById() {
    }

    private void chercherDepartementById() {
    }
}
