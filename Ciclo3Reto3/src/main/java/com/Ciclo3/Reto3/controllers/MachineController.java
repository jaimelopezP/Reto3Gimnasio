/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.controllers;

import com.Ciclo3.Reto3.models.MachineModel;
import com.Ciclo3.Reto3.services.MachineService;
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
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<MachineModel> getAll() {
        return machineService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MachineModel> getMachine(@PathVariable("id") int id) {
        return machineService.getMachine(id);
    }

    @PostMapping("/save")
    public ResponseEntity<MachineModel> save(@RequestBody MachineModel machineModel) {
        MachineModel machineModelResponse = machineService.save(machineModel);
        ResponseEntity<MachineModel> entity = new ResponseEntity(machineModelResponse, HttpStatus.CREATED);
        return entity;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MachineModel update(@RequestBody MachineModel machineModel) {
        return machineService.update(machineModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteMachine(@PathVariable("id") int id) {
        return machineService.deleteMachine(id);

    }

}
