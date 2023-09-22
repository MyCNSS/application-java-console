package com.macnss.dao;

import com.macnss.Model.Agent;
import com.macnss.Model.Dossier;

public interface AgentDao {
    boolean ajoutDossier(Dossier dossier);
    float calculeDossier (int id_d, int id_c, int id_m, int id_cm, int id_tc);
    boolean modifierDssier(Dossier dossier);
    boolean supprisionDossier(int id_dossier);
    boolean comfirmationDossier(int id, String status);
    Agent login (Agent agent);
}
