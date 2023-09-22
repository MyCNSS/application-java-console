package com.macnss.dao;

import com.macnss.Model.TypeConsultation;

import java.util.List;

public interface TypeConsultationDao {
    List<TypeConsultation> affichageTypeConsultations();
    TypeConsultation affichageTypeConsultationByID(int id);
}
