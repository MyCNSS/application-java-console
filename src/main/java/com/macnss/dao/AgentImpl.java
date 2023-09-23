package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.Agent;
import com.macnss.Model.Dossier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgentImpl implements AgentDao{
    @Override
    public boolean ajoutDossier(Dossier dossier) {
        Connection con = DBconnection.getConnection();
        String query2 = "INSERT INTO `dossier`(`prix_retour`, `status`, `matrecule`, `id_A`, `id_medicament`, `id_consultation_medicale`) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement2 = con.prepareStatement(query2);){
            preparedStatement2.setFloat(1,dossier.getPrix_retour());
            preparedStatement2.setString(2,"En attente");
            preparedStatement2.setString(3,dossier.getMatrecule());
            preparedStatement2.setInt(4,dossier.getId_a());
            preparedStatement2.setInt(5,dossier.getId_m());
            preparedStatement2.setInt(6,dossier.getId_cm());

            preparedStatement2.executeUpdate();

            return true;
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public boolean modifierDossier(Dossier dossier) {
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
