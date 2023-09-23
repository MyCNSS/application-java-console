package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.TypeConsultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TypeConsultationImpl implements TypeConsultationDao{
    @Override
    public List<TypeConsultation> affichageTypeConsultations() {
        Connection con = DBconnection.getConnection();

        List<TypeConsultation> typeConsultations = new LinkedList<>();

        String query = "SELECT * FROM typeconsultation";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                TypeConsultation typeConsultation = new TypeConsultation (resultSet.getInt("id"),
                        resultSet.getString("nom_CM"),
                        resultSet.getFloat("prix_reduction"));
                typeConsultations.add(typeConsultation);
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

        return typeConsultations;
    }

    @Override
    public TypeConsultation affichageTypeConsultationByID(int id) {
        Connection con = DBconnection.getConnection();

        TypeConsultation typeConsultation = null;

        String query = "SELECT * FROM typeconsultation WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                typeConsultation = new TypeConsultation (resultSet.getInt("id"),
                        resultSet.getString("nom_CM"),
                        resultSet.getFloat("prix_reduction"));
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

        return typeConsultation;
    }
}
