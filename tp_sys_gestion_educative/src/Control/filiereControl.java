package Control;

import Modules.Departement;
import Modules.Enseignant;
import Modules.Filiere;

import java.util.List;
import java.util.Scanner;


public class filiereControl {

    public static Filiere creerFiliere(String intitule, Enseignant responsable, Departement departement) {
        return new Filiere(intitule, responsable, departement);
    }

    // Méthode pour ajouter une filière à la liste
    public static void ajouterFiliere(List<Filiere> filieres, Filiere filiere) {
        filieres.add(filiere);
    }

    public static void supprimerFiliereById(List<Filiere> filieres, int filiereId) {
        filieres.removeIf(filiere -> filiere.getId() == filiereId);
    }

    public static Filiere chercherFiliereById(List<Filiere> filieres, int filiereId) {
        return filieres.stream()
                .filter(filiere -> filiere.getId() == filiereId)
                .findFirst()
                .orElse(null);
    }

    public void moduleAction() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Actions pour les filière   :");
            System.out.println("1. Ajouter une filière ");
            System.out.println("2. supprimer une filière ");
            System.out.println("3.chercher une filière  by id ");

            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterFiliere();
                    break;
                case 2:
                    supprimerFiliereById();
                    break;
                case 3:
                    chercherFiliereById();
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Votre choix est incorrect");
            }
        }

    }

    private void supprimerFiliereById() {
    }

    private void ajouterFiliere() {
    }

    private void chercherFiliereById(){
    }
}


