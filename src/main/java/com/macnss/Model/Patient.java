package com.macnss.Model;

public class Patient {
    private String matrecule;
    private String nom;
    private String prenom;
    private String email;

    public Patient() {
    }

    public Patient(String matrecule, String nom, String prenom, String email) {
        this.matrecule = matrecule;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
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

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
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
                ", email='" + email + '\'' +
                '}';
    }
}
