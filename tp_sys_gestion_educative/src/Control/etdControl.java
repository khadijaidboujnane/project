package Control;

import Modules.Etudiant;
import Modules.Filiere;

import java.util.List;
import java.util.Scanner;

public class etdControl {
    public static Etudiant creerEtudiant(String nom, String prenom, String email, int apogee, Filiere filiere) {
        return new Etudiant(nom, prenom, email, apogee, filiere);
    }

    // Méthode pour ajouter un étudiant à la liste (par exemple, dans une classe gestionnaire)
    public static void ajouterEtudiant(List<Etudiant> etudiants, Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public static void supprimerEtudiantById(List<Etudiant> etudiants, int etudiantId) {
        etudiants.removeIf(etudiant -> etudiant.getId() == etudiantId);
    }

    public static Etudiant chercherEtudiantById(List<Etudiant> etudiants, int etudiantId) {
        return etudiants.stream()
                .filter(etudiant -> etudiant.getId() == etudiantId)
                .findFirst()
                .orElse(null);
    }

    public void moduleAction() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Actions pour les etudiants :");
            System.out.println("1. Ajouter un etudiant");
            System.out.println("2. supprimer un etudiants");
            System.out.println("3.chercher un etudiant by id ");

            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterEtudiant();
                    break;
                case 2:
                    supprimerEtudiantById();
                    break;
                case 3:
                    chercherEtudiantById();
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Votre choix est incorrect");
            }
        }
    }

    private void ajouterEtudiant() {
    }
    private void supprimerEtudiantById(){

    }
    private void chercherEtudiantById(){

    }

}
