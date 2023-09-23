package com.macnss.dao;

import com.macnss.DBconnection.DBconnection;
import com.macnss.Model.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CategorieImpl implements CategorieDao{
    @Override
    public List<Categorie> affichageCategories() {
        Connection con = DBconnection.getConnection();

        List<Categorie> categories = new LinkedList<>();

        String query = "SELECT * FROM categorie";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Categorie categorie = new Categorie (resultSet.getInt("id"),
                        resultSet.getString("nom_C"),
                        resultSet.getFloat("prix_reduction"));
                categories.add(categorie);
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

        return categories;
    }

    @Override
    public Categorie affichageCategorieByID(int id) {
        Connection con = DBconnection.getConnection();

        Categorie categorie = null;

        String query = "SELECT * FROM categorie WHERE id =?";
        try (PreparedStatement preparedStatement = con.prepareStatement((query))){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                categorie = new Categorie (resultSet.getInt("id"),
                        resultSet.getString("nom_C"),
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

        return categorie;
    }
}
