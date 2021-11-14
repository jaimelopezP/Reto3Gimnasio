/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.MachineModel;
import com.Ciclo3.Reto3.repositories.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<MachineModel> getAll() {
        return machineRepository.getAll();
    }

    public Optional<MachineModel> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public MachineModel save(MachineModel machineModel) {

        if (machineModel.getId() == null) {
            return machineRepository.save(machineModel);
        }

        return (machineModel);
    }

    public MachineModel update(MachineModel machineModel) {
        if (machineModel.getId() != null) {
            Optional<MachineModel> u = machineRepository.getMachine(machineModel.getId());
            if (!u.isEmpty()) {

                if (machineModel.getBrand() != null) {
                    u.get().setBrand(machineModel.getBrand());
                }

                if (machineModel.getName() != null) {
                    u.get().setName(machineModel.getName());
                }
                if (machineModel.getYear() != null) {
                    u.get().setYear(machineModel.getYear());
                }
                if (machineModel.getDescription() != null) {
                    u.get().setDescription(machineModel.getDescription());
                }

                return machineRepository.save(u.get());
            }
        }
        return machineModel;
    }

    public boolean deleteMachine(int id) {
        Optional<MachineModel> d = getMachine(id);
        if (!d.isEmpty()) {
            machineRepository.delete(d.get());
            return true;
        }
        return false;

    }

}
