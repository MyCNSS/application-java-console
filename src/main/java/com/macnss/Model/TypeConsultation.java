package com.macnss.Model;

public class TypeConsultation {
    private int id;
    private String nom_CM;
    private float prix_reduction;

    public TypeConsultation() {
    }

    public TypeConsultation(int id, String nom_CM, float prix_reduction) {
        this.id = id;
        this.nom_CM = nom_CM;
        this.prix_reduction = prix_reduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_CM() {
        return nom_CM;
    }

    public void setNom_CM(String nom_CM) {
        this.nom_CM = nom_CM;
    }

    public float getPrix_reduction() {
        return prix_reduction;
    }

    public void setPrix_reduction(float prix_reduction) {
        this.prix_reduction = prix_reduction;
    }

    public static TypeConsultationBuilder builder(){
        return new TypeConsultationBuilder();
    }

    @Override
    public String toString() {
        return "TypeConsultation{" +
                "id=" + id +
                ", nom_CM='" + nom_CM + '\'' +
                ", prix_reduction=" + prix_reduction +
                '}';
    }
}
