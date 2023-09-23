package com.macnss;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.*;
import com.macnss.dao.*;
import com.macnss.helpers.*;

import java.sql.Connection;
import java.util.prefs.Preferences;

public class Main {
    public static void main(String[] args) {
        AgentDao agentDao = new AgentImpl();
        agentDao.affichageDossier().forEach(System.out::println);
    }
}