package com.macnss.Model;

public class Patient {
    private String matrecule;
    private String nom;
    private String prenom;
    private int id_d;

    public Patient() {
    }

    public Patient(String matrecule, String nom, String prenom, int id_d) {
        this.matrecule = matrecule;
        this.nom = nom;
        this.prenom = prenom;
        this.id_d = id_d;
    }

    public String getMatrecule() {
        return matrecule;
    }

    public void setMatrecule(String matrecule) {
        this.matrecule = matrecule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public static PatientBuilder builder(){
        return new PatientBuilder();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "matrecule='" + matrecule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id_d='" + id_d + '\'' +
                '}';
    }
}
