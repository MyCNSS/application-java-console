package com.macnss.dao;

import com.macnss.Model.Admin;
import com.macnss.Model.Agent;

import java.util.List;

public interface AdminDao {
    boolean ajoutAgent(com.macnss.Model.Agent agent);
    boolean modiferAgent(com.macnss.Model.Agent agent);
    boolean supprissionAgent(String email);
    List<Agent> affichageAgent();
    Admin login(Admin admin);
}
