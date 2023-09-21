package com.macnss.Model;

public class DossierBuilder {
    private int id;
    private float prix_retour;
    private String status;

    public DossierBuilder id(int id) {
        this.id = id;
        return this;
    }

    public DossierBuilder prix_retour(float prix_retour) {
        this.prix_retour = prix_retour;
        return this;
    }

    public DossierBuilder status(String status) {
        this.status = status;
        return this;
    }

    public Dossier build(){
        return new Dossier(id, prix_retour, status);
    }
}