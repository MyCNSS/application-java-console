package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.Admin;
import com.macnss.Model.Dossier;
import com.macnss.Model.Patient;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PatientImpl implements PatientDao{
    @Override
    public List<Dossier> voirHistorique(String matrecule, int id_d) {
        Connection con = DBconnection.getConnection();

        List<Dossier> dossiers = new LinkedList<>();

        if (id_d == 0){
            String query = "SELECT * FROM dossier WHERE matrecule = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement((query))){
                preparedStatement.setString(1,matrecule);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    Dossier dossier = new Dossier (resultSet.getInt("id"),
                            resultSet.getFloat("prix_retour"),
                            resultSet.getString("status"),
                            resultSet.getInt("id_medicament"),
                            resultSet.getInt("id_consultation_medicale"),
                            resultSet.getInt("id_A"),
                            resultSet.getString("matrecule"));
                    dossiers.add(dossier);
                }

            } catch (SQLException se){
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
            }
        }else {
            String query = "SELECT * FROM dossier WHERE matrecule = ? AND id = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement((query))){
                preparedStatement.setString(1,matrecule);
                preparedStatement.setInt(2,id_d);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    Dossier dossier = new Dossier (resultSet.getInt("id"),
                            resultSet.getFloat("prix_retour"),
                            resultSet.getString("status"),
                            resultSet.getInt("id_medicament"),
                            resultSet.getInt("id_consultation_medicale"),
                            resultSet.getInt("id_A"),
                            resultSet.getString("matrecule"));
                    dossiers.add(dossier);
                }

            } catch (SQLException se){
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException se){
                    se.printStackTrace();
                }
            }
        }

        return dossiers;
    }

    @Override
    public Patient login(String matrecule) {
        Patient patient;
        Connection con = DBconnection.getConnection();


        String query = "SELECT * FROM `patient` WHERE `matrecule`=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query);){
            preparedStatement.setString(1,matrecule);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                    patient = new Patient(resultSet.getString("matrecule"),
                            resultSet.getString("nom_P"),
                            resultSet.getString("prenom_P"),
                            resultSet.getString("email"));
                    return patient;
            }else {
                patient = Patient.builder()
                        .matrecule("null")
                        .email("null")
                        .nom("null")
                        .prenom("null")
                        .build();
                return patient;
            }
        } catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        patient = Patient.builder()
                .matrecule("null")
                .email("null")
                .nom("null")
                .prenom("null")
                .build();
        return patient;
    }
}
