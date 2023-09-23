package com.macnss.dao;

import com.macnss.Model.Agent;
import com.macnss.Model.Dossier;

public interface AgentDao {
    boolean ajoutDossier(Dossier dossier);
    boolean modifierDossier(Dossier dossier);
    boolean supprisionDossier(int id_dossier);
    boolean comfirmationDossier(int id, int status);
    Agent login (Agent agent);
}
