/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.services;

import com.Ciclo3.Reto3.models.CountClient;
import com.Ciclo3.Reto3.models.ReservationModel;
import com.Ciclo3.Reto3.models.StatusAmount;
import com.Ciclo3.Reto3.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     *
     * @return
     */
    public List<ReservationModel> getAll() {
        return reservationRepository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<ReservationModel> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    /**
     *
     * @param reservationModel
     * @return
     */
    public ReservationModel save(ReservationModel reservationModel) {

        if (reservationModel.getIdReservation() == null) {
            return reservationRepository.save(reservationModel);
        }

        return reservationModel;
    }

    /**
     *
     * @param reservationModel
     * @return
     */
    public ReservationModel update(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> u = reservationRepository.getReservation(reservationModel.getIdReservation());
            if (!u.isEmpty()) {

                if (reservationModel.getStartDate() != null) {
                    u.get().setStartDate(reservationModel.getStartDate());
                }

                if (reservationModel.getDevolutionDate() != null) {
                    u.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null) {
                    u.get().setStatus(reservationModel.getStatus());
                }
                if (reservationModel.getScore() != null) {
                    u.get().setScore(reservationModel.getScore());
                }

                return reservationRepository.save(u.get());
            }
        }
        return reservationModel;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteReservation(int id) {
        Optional<ReservationModel> d = getReservation(id);
        if (!d.isEmpty()) {
            reservationRepository.delete(d.get());
            return true;
        }
        return false;

    }

    /**
     *
     * @return
     */
    public List<CountClient> getTopClients() {

        return reservationRepository.getTopClients();

    }

    /**
     *
     * @return
     */
    public StatusAmount getStatusReport() {
        List<ReservationModel> completed = reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationsByStatus("cancelled");

        StatusAmount descAmt = new StatusAmount(completed.size(), cancelled.size());
        return descAmt;
    }

    /**
     *
     * @param d1
     * @param d2
     * @return
     */
    public List<ReservationModel> getReservationPeriod(String d1, String d2) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);

        } else {
            return new ArrayList<>();

        }
    }
}
