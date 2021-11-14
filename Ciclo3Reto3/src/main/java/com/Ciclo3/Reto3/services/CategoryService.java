/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.CategoryModel;
import com.Ciclo3.Reto3.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<CategoryModel> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public CategoryModel save(CategoryModel categoryModel) {

        if (categoryModel.getId() == null) {
            return categoryRepository.save(categoryModel);
        }

        return (categoryModel);
    }

    public CategoryModel update(CategoryModel categoryModel) {
        if (categoryModel.getId() != null) {
            Optional<CategoryModel> u = categoryRepository.getCategory(categoryModel.getId());
            if (!u.isEmpty()) {

                if (categoryModel.getDescription() != null) {
                    u.get().setDescription(categoryModel.getDescription());
                }

                if (categoryModel.getName() != null) {
                    u.get().setName(categoryModel.getName());
                }
                return categoryRepository.save(u.get());
            }
        }
        return categoryModel;
    }

    public boolean deleteCategory(int id) {
        Optional<CategoryModel> d = getCategory(id);
        if (!d.isEmpty()) {
            categoryRepository.delete(d.get());
            return true;
        }
        return false;
    }
}
