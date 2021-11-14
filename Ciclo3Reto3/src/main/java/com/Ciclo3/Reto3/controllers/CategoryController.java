/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.controllers;

import com.Ciclo3.Reto3.models.CategoryModel;
import com.Ciclo3.Reto3.services.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaime López Patiño
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategory(@PathVariable("id") int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryModel> save(@RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelResponse = categoryService.save(categoryModel);
        ResponseEntity<CategoryModel> entity = new ResponseEntity(categoryModelResponse, HttpStatus.CREATED);
        return entity;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel update(@RequestBody CategoryModel categoryModel) {
        return categoryService.update(categoryModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCategory(@PathVariable("id") int id) {
        return categoryService.deleteCategory(id);
    }

}
