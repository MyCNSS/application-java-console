package com.macnss.Model;

public class Agent {
    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int id_d;


    public Agent() {
    }

    public Agent(int id, String email, String password, String nom, String prenom, int id_d) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.id_d = id_d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public static AgentBuilder builder(){
        return new AgentBuilder();
    }


    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id_d='" + id_d + '\'' +
                '}';
    }
}
