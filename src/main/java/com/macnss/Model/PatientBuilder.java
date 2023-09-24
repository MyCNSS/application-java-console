package com.macnss.Model;

public class PatientBuilder {
    private String matrecule;
    private String nom;
    private String prenom;
    private String email;

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

    public PatientBuilder email(String email) {
        this.email = email;
        return this;
    }

    public Patient build(){
        return new Patient(matrecule, nom, prenom, email);
    }
}
