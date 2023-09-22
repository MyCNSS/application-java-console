package com.macnss.dao;

import com.macnss.Model.Admin;
import com.macnss.Model.Agent;

import java.util.List;

public class AdminImpl implements AdminDao{
    @Override
    public boolean ajoutAgent(Agent agent) {
        return false;
    }

    @Override
    public boolean modiferAgent(Agent agent) {
        return false;
    }

    @Override
    public boolean supprissionAgent(String email) {
        return false;
    }

    @Override
    public List<Agent> affichageAgent() {
        return null;
    }

    @Override
    public Admin login(Admin admin) {
        return admin;
    }
}
