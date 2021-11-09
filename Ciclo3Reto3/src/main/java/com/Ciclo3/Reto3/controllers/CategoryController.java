/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.controllers;

import com.Ciclo3.Reto3.models.CategoryModel;
import com.Ciclo3.Reto3.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaime López Patiño
 */
@RestController
@RequestMapping("/api/Category")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryModel> save(@RequestBody CategoryModel categoryModel) {
        CategoryModel categoryModelResponse = categoryService.save(categoryModel);
        ResponseEntity<CategoryModel> entity = new ResponseEntity(categoryModelResponse, HttpStatus.CREATED);
        return entity;
    }

}
