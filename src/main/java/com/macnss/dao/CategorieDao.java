package com.macnss.dao;

import com.macnss.Model.Categorie;

import java.util.List;

public interface CategorieDao {
    List<Categorie> affichageCategories();
    Categorie affichageCategorieByID(int id);
}