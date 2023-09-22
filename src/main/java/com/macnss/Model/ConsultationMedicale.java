package com.macnss.Model;

public class ConsultationMedicale {
    private int id;
    private String nom_CM;
    private float prix_consultation;

    public ConsultationMedicale() {
    }

    public ConsultationMedicale(int id, String nom_CM, float prix_consultation) {
        this.id = id;
        this.nom_CM = nom_CM;
        this.prix_consultation = prix_consultation;
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

    public float getPrix_consultation() {
        return prix_consultation;
    }

    public void setPrix_consultation(float prix_consultation) {
        this.prix_consultation = prix_consultation;
    }
    public static ConsultationMedicaleBuilder builder(){
        return new ConsultationMedicaleBuilder();
    }

    @Override
    public String toString() {
        return "ConsultationMedicale{" +
                "id=" + id +
                ", nom_CM='" + nom_CM + '\'' +
                ", prix_consultation=" + prix_consultation +
                '}';
    }
}
