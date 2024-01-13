package Modules;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String intitule;
    private Enseignant responsable;
    private List<Filiere> filieres;
    private int id;

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.filieres = new ArrayList<>();
    }
//methode
    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
    }
//getter and setter
    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public int getId() {
        return id;
    }
}
