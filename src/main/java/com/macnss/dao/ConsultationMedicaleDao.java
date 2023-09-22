package com.macnss.dao;

import com.macnss.Model.ConsultationMedicale;

import java.util.List;

public interface ConsultationMedicaleDao {
    List<ConsultationMedicale> affichageConsultationMedicales();
    List<ConsultationMedicale> affichageConsultationMedicalesByIDTypeConsultations(int id);
}
