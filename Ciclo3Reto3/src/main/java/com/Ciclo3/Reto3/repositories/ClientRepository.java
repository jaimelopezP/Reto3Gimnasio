/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.ClientModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class ClientRepository {

    @Autowired
    private IClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAll() {
        return (List) clientCrudRepository.findAll();
    }

    public ClientModel save(ClientModel clientModel) {
        return clientCrudRepository.save(clientModel);
    }

}
