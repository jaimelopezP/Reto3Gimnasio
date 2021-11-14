/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.MessageModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class MessageRepository {

    @Autowired
    private IMessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAll() {
        return (List<MessageModel>) messageCrudRepository.findAll();
    }

    public Optional<MessageModel> getMessage(int id) {

        return messageCrudRepository.findById(id);
    }

    public MessageModel save(MessageModel messageModel) {
        return messageCrudRepository.save(messageModel);
    }

    public void delete(MessageModel messageModel) {
        messageCrudRepository.delete(messageModel);
    }
}
