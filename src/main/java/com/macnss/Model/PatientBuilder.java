package com.macnss.Model;

public class PatientBuilder {
    String matrecule;
    String nom;
    String prenom;

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

    public Patient build(){
        return new Patient(matrecule, nom, prenom);
    }
}
