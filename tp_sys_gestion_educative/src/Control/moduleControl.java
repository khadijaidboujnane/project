package Control;

import Modules.Enseignant;
import Modules.Filiere;
import Modules.Module;


import java.util.List;
import java.util.Scanner;

public class moduleControl {
    public static Module creerModule(String intitule, Filiere filiere, Enseignant professeur) {
        return new Module(intitule, filiere, professeur);
    }

    // Méthode pour ajouter un module à la liste
    public static void ajouterModule(List<Module> modules, Module module) {
        modules.add(module);
    }
    public static void supprimerModuleById(List<Module> modules, int moduleId) {
        modules.removeIf(module -> module.getId() == moduleId);
    }
    public static Module chercherModuleById(List<Module> modules, int moduleId) {
        return modules.stream()
                .filter(module -> module.getId() == moduleId)
                .findFirst()
                .orElse(null);
    }
    public void moduleAction() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while (!exit) {
            System.out.println("Actions pour les modules :");
            System.out.println("1. Ajouter un module");
            System.out.println("2. supprimerModuleById");
            System.out.println("3.chercherModuleById");

            System.out.println("4. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterModule();
                    break;
                case 2:
                    supprimerModuleById();
                    break;
                case 3:
                    chercherModuleById();
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Votre choix est incorrect");
            }
        }
}

    private void ajouterModule() {
    }
    private void supprimerModuleById() {
    }
    private void  chercherModuleById(){
    }
}
