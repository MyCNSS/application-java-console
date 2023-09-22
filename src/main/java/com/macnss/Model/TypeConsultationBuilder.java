package com.macnss.Model;

public class TypeConsultationBuilder {
    private int id;
    private String nom_CM;
    private float prix_reduction;

    public TypeConsultationBuilder id(int id) {
        this.id = id;
        return this;
    }

    public TypeConsultationBuilder nom_CM(String nom_CM) {
        this.nom_CM = nom_CM;
        return this;
    }

    public TypeConsultationBuilder prix_reduction(float prix_reduction) {
        this.prix_reduction = prix_reduction;
        return this;
    }
    public TypeConsultation build(){
        return new TypeConsultation(id, nom_CM, prix_reduction);
    }
}
