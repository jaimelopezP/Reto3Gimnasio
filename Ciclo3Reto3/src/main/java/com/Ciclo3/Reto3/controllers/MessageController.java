/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.controllers;

import com.Ciclo3.Reto3.models.MessageModel;
import com.Ciclo3.Reto3.services.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jaime López Patiño
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> getAll() {
        return messageService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity<MessageModel> save(@RequestBody MessageModel messageModel) {
        MessageModel messageModelResponse = messageService.save(messageModel);
        ResponseEntity<MessageModel> entity = new ResponseEntity(messageModelResponse, HttpStatus.CREATED);
        return entity;
    }

    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable("id") int id) {
        return messageService.getMessage(id);
    }

}
