package com.macnss.Model;

public class Dossier {
    private int id;
    private float prix_retour;
    private String status;

    public Dossier() {
    }

    public Dossier(int id, float prix_retour, String status) {
        this.id = id;
        this.prix_retour = prix_retour;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix_retour() {
        return prix_retour;
    }

    public void setPrix_retour(float prix_retour) {
        this.prix_retour = prix_retour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static AgentBuilder builder(){
        return new AgentBuilder();
    }

    @Override
    public String toString() {
        return "Dossier{" +
                "id=" + id +
                ", prix_retour=" + prix_retour +
                ", status='" + status + '\'' +
                '}';
    }
}
