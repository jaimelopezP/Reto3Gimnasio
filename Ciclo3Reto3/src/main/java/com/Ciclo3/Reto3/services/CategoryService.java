/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.CategoryModel;
import com.Ciclo3.Reto3.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
        public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }

    public CategoryModel save(CategoryModel categoryModel) {

        if (categoryModel.getId() == null) {
            return categoryRepository.save(categoryModel);
        }

        return (categoryModel);
    }
        
}
