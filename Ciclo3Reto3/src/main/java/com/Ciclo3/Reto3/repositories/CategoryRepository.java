/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.CategoryModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class CategoryRepository {

    @Autowired
    private ICategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAll() {
        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel save(CategoryModel categoryModel) {
        return categoryCrudRepository.save(categoryModel);
    }

    public void delete(CategoryModel categoryModel) {
        categoryCrudRepository.delete(categoryModel);
    }
}
