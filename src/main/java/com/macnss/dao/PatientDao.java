package com.macnss.dao;

import com.macnss.Model.Dossier;
import com.macnss.Model.Patient;

import java.util.List;

public interface PatientDao {
    List<Dossier> voirHistorique(String matrecule, int id_d);
    Patient login(String matrecule);
}
