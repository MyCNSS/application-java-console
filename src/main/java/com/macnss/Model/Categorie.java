package com.macnss.Model;

public class Categorie {
    private int id;
    private String nom_C;
    private float prix_reduction;

    public Categorie() {
    }

    public Categorie(int id, String nom_C, float prix_reduction) {
        this.id = id;
        this.nom_C = nom_C;
        this.prix_reduction = prix_reduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_C() {
        return nom_C;
    }

    public void setNom_C(String nom_C) {
        this.nom_C = nom_C;
    }

    public float getPrix_reduction() {
        return prix_reduction;
    }

    public void setPrix_reduction(float prix_reduction) {
        this.prix_reduction = prix_reduction;
    }
    public static CategorieBuilder builder(){
        return new CategorieBuilder();
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", nom_C='" + nom_C + '\'' +
                ", prix_reduction=" + prix_reduction +
                '}';
    }
}
