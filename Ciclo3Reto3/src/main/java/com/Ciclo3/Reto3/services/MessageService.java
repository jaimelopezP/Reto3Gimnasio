/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.MessageModel;
import com.Ciclo3.Reto3.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAll() {
        return messageRepository.getAll();
    }

    public Optional<MessageModel> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public MessageModel save(MessageModel messageModel) {

        if (messageModel.getIdMessage() == null) {
            return messageRepository.save(messageModel);
        }

        return (messageModel);
    }

    public MessageModel update(MessageModel messageModel) {
        if (messageModel.getIdMessage() != null) {
            Optional<MessageModel> u = messageRepository.getMessage(messageModel.getIdMessage());
            if (!u.isEmpty()) {

                if (messageModel.getMessageText() != null) {
                    u.get().setMessageText(messageModel.getMessageText());
                }

                return messageRepository.save(u.get());
            }
        }
        return messageModel;
    }

    public boolean deleteMessage(int id) {
        Optional<MessageModel> d = getMessage(id);
        if (!d.isEmpty()) {
            messageRepository.delete(d.get());
            return true;
        }
        return false;

    }
}
