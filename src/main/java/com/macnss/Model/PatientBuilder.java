package com.macnss.Model;

public class PatientBuilder {
    private String matrecule;
    private String nom;
    private String prenom;
    private int id_d;

    public PatientBuilder matrecule(String matrecule) {
        this.matrecule = matrecule;
        return this;
    }

    public PatientBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public PatientBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public PatientBuilder id_d(int id_d) {
        this.id_d = id_d;
        return this;
    }

    public Patient build(){
        return new Patient(matrecule, nom, prenom, id_d);
    }
}
