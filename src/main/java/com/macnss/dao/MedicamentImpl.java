package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.Medicament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MedicamentImpl implements MedicamentDao{
    @Override
    public List<Medicament> affichageMedicaments() {
        Connection con = DBconnection.getConnection();

        List<Medicament> medicaments = new LinkedList<>();

        String query = "SELECT * FROM medicament";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Medicament medicament = new Medicament (resultSet.getInt("id"),
                        resultSet.getString("nom_m"),
                        resultSet.getFloat("prix_medicament"));
                medicaments.add(medicament);
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

        return medicaments;
    }

    @Override
    public Medicament affichageMedicamentsByIDCategorie(int id) {
        Connection con = DBconnection.getConnection();

        Medicament medicament = null;

        String query = "SELECT * FROM medicament WHERE id = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                medicament = new Medicament (resultSet.getInt("id"),
                        resultSet.getString("nom_m"),
                        resultSet.getFloat("prix_medicament"));
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

        return medicament;
    }
}
