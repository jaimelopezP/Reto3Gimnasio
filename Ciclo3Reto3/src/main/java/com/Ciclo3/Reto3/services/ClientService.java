/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.ClientModel;
import com.Ciclo3.Reto3.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
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

    public Optional<ClientModel> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public ClientModel save(ClientModel clientModel) {

        if (clientModel.getidClient() == null) {
            return clientRepository.save(clientModel);
        }

        return (clientModel);
    }

    public ClientModel update(ClientModel clientModel) {
        if (clientModel.getidClient() != null) {
            Optional<ClientModel> u = clientRepository.getClient(clientModel.getidClient());
            if (!u.isEmpty()) {

                if (clientModel.getName() != null) {
                    u.get().setName(clientModel.getName());
                }
                if (clientModel.getPassword() != null) {
                    u.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getAge() != null) {
                    u.get().setAge(clientModel.getAge());
                }
                if (clientModel.getEmail() != null) {
                    u.get().setEmail(clientModel.getEmail());
                }

                return clientRepository.save(u.get());
            }
        }
        return clientModel;
    }

    public boolean deleteClient(int id) {
        Optional<ClientModel> d = getClient(id);
        if (!d.isEmpty()) {
            clientRepository.delete(d.get());
            return true;
        }
        return false;

    }

}
