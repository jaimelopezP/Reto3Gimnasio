/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.MachineModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jaime López Patiño
 */
public interface IMachineCrudRepository extends CrudRepository<MachineModel, Integer> {
    
}
