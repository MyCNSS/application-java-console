package com.macnss.dao;

import com.macnss.Model.Agent;
import com.macnss.Model.Dossier;

public class AgentImpl implements AgentDao{
    @Override
    public boolean ajoutDossier(Dossier dossier) {
        return false;
    }

    @Override
    public boolean modifierDssier(Dossier dossier) {
        return false;
    }

    @Override
    public boolean supprisionDossier(int id_dossier) {
        return false;
    }

    @Override
    public boolean comfirmationDossier(int id, String status) {
        return false;
    }

    @Override
    public Agent login(Agent agent) {
        return null;
    }
}
