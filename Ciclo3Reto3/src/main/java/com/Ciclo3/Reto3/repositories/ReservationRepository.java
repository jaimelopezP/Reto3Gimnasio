/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import ch.qos.logback.core.net.server.Client;
import com.Ciclo3.Reto3.models.ClientModel;
import com.Ciclo3.Reto3.models.ReservationModel;
import com.Ciclo3.Reto3.models.CountClient;
import java.util.ArrayList;
import java.util.Date;
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

    public void delete(ReservationModel reservationModel) {
        reservationCrudRepository.delete(reservationModel);
    }

    public List<ReservationModel> getReservationsByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);

    }

    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);

    }

    public List<CountClient> getTopClients() {

        List<CountClient> res = new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (ClientModel) report.get(i)[0]));

        }

        return res;
    }

}
