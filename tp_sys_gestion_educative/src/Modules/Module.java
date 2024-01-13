package Modules;

public class Module {
    private String intitule;
    private Filiere filiere;
    private Enseignant professeur;
    private long id;

    public Module(String intitule, Filiere filiere, Enseignant professeur,long id) {
        this.intitule = intitule;
        this.filiere = filiere;
        this.professeur = professeur;
        this.id=id;

    }

    // Getters and setters

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Enseignant professeur) {
        this.professeur = professeur;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
