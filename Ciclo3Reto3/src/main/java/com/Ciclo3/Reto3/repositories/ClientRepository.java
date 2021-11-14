/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.ClientModel;
import java.util.List;
import java.util.Optional;
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
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public ClientModel save(ClientModel clientModel) {
        return clientCrudRepository.save(clientModel);
    }

    public void delete(ClientModel clientModel) {
        clientCrudRepository.delete(clientModel);
    }

}
