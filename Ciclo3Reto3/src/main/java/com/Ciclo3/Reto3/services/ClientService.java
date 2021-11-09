/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.ClientModel;
import com.Ciclo3.Reto3.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAll() {
        return clientRepository.getAll();
    }

    public ClientModel save(ClientModel clientModel) {

        if (clientModel.getId() == null) {
            return clientRepository.save(clientModel);
        }

        return (clientModel);
    }

}
