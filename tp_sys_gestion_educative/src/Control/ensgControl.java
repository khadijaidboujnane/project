package Control;

import Modules.Departement;
import Modules.Enseignant;

import java.util.List;
import java.util.Scanner;

public class ensgControl {
    public static Enseignant creerEnseignant(String nom, String prenom, String email, String grade, Departement departement) {
        return new Enseignant(nom, prenom, email, grade, departement);
    }

    // Méthode pour ajouter un enseignant à la liste (par exemple, dans une classe gestionnaire)
    public static void ajouterEnseignant(List<Enseignant> enseignants, Enseignant enseignant) {
        enseignants.add(enseignant);
    }
    public static void supprimerEnseignantById(List<Enseignant> enseignants, int enseignantId) {
        enseignants.removeIf(enseignant -> enseignant.getId() == enseignantId);
    }
    public static Enseignant chercherEnseignantById(List<Enseignant> enseignants, int enseignantId) {
        return enseignants.stream()
                .filter(enseignant -> enseignant.getId() == enseignantId)
                .findFirst()
                .orElse(null);
    }
    public void moduleAction() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Actions pour les enseignants  :");
            System.out.println("1. Ajouter un enseignant");
            System.out.println("2. supprimer un enseignat");
            System.out.println("3.chercher un enseignat by id ");

            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterEnseignant();
                    break;
                case 2:
                    supprimerEnseignantById();
                    break;
                case 3:
                    chercherEnseignantById();
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Votre choix est incorrect");
            }
        }

}

    private void ajouterEnseignant() {
    }
    private void supprimerEnseignantById(){
    }
    private void chercherEnseignantById(){

    }
}
