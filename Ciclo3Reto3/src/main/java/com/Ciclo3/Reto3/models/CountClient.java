/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.models;

/**
 *
 * @author Jaime López Patiño
 */
public class CountClient {
    
    private Long total;
    private ClientModel clientModel;

        public CountClient(Long total, ClientModel clientModel) {
        this.total = total;
        this.clientModel = clientModel;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    
}
