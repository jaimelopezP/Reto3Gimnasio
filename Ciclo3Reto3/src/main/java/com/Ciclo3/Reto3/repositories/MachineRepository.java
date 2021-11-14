/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.MachineModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class MachineRepository {

    @Autowired
    private IMachineCrudRepository machineCrudRepository;

    public List<MachineModel> getAll() {
        return (List<MachineModel>) machineCrudRepository.findAll();
    }

    public Optional<MachineModel> getMachine(int id) {

        return machineCrudRepository.findById(id);

    }

    public MachineModel save(MachineModel machineModel) {
        return machineCrudRepository.save(machineModel);
    }

    public void delete(MachineModel machineModel) {

        machineCrudRepository.delete(machineModel);
    }

}
