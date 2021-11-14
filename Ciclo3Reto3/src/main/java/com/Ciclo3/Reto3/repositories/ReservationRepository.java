/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.ReservationModel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jaime López Patiño
 */
@Repository
public class ReservationRepository {

    @Autowired
    private IReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel save(ReservationModel reservationModel) {
        return reservationCrudRepository.save(reservationModel);
    }

}
