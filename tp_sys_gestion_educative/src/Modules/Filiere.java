package Modules;
import java.util.ArrayList;
import java.util.List;
public class Filiere {
    private String intitule;
    private Enseignant responsable;
    private Departement departement;
    private List<Module> modules;
    private List<Etudiant> etudiants;
    private int id;

    public Filiere(String intitule, Enseignant responsable, Departement departement) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.departement = departement;
        this.modules = new ArrayList<>();
        this.etudiants = new ArrayList<>();
    }

    public void ajouterModule(Module module) {
        modules.add(module);
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    // Getters and setters


    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public int getId() {
        return id;
    }
}
