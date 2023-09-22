package com.macnss.Model;

public class CategorieBuilder {
    private int id;
    private String nom_C;
    private float prix_reduction;

    public CategorieBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CategorieBuilder nom_C(String nom_C) {
        this.nom_C = nom_C;
        return this;
    }

    public CategorieBuilder prix_reduction(float prix_reduction) {
        this.prix_reduction = prix_reduction;
        return this;
    }
    public Categorie build(){
        return new Categorie(id, nom_C, prix_reduction);
    }
}
