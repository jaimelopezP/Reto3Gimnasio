/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jaime López Patiño
 */
@Entity
@Table(name = "message")
public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "machineIde")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private MachineModel machine;

    public MachineModel getMachine() {
        return machine;
    }

    public void setMachine(MachineModel machine) {
        this.machine = machine;
    }

    @ManyToOne
    @JoinColumn(name = "clientIde")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private ClientModel client;

    public ClientModel getClient() {
        return client;
    }

    public void setCliente(ClientModel client) {
        this.client = client;
    }

    public MessageModel() {
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}