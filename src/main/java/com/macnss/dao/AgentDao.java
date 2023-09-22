package com.macnss.dao;

import com.macnss.Model.Agent;
import com.macnss.Model.Dossier;

public interface AgentDao {
    boolean ajoutDossier(Dossier dossier);
    boolean modifierDssier(Dossier dossier);
    boolean supprisionDossier(int id_dossier);
    boolean comfirmationDossier(int id, String status);
    Agent login (Agent agent);
}
