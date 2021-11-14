/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.ReservationModel;
import com.Ciclo3.Reto3.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jaime López Patiño
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAll() {
        return reservationRepository.getAll();
    }
    
    public Optional<ReservationModel> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public ReservationModel save(ReservationModel reservationModel) {

        if (reservationModel.getIdReservation() == null) {
            return reservationRepository.save(reservationModel);
        }

        return (reservationModel);
    }

}
