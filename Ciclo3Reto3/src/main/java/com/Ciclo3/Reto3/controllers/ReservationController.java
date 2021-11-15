/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.controllers;

import com.Ciclo3.Reto3.models.CountClient;
import com.Ciclo3.Reto3.models.ReservationModel;
import com.Ciclo3.Reto3.models.StatusAmount;
import com.Ciclo3.Reto3.services.ReservationService;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable("id") int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    public ResponseEntity<ReservationModel> save(@RequestBody ReservationModel reservationModel) {
        ReservationModel reservationModelResponse = reservationService.save(reservationModel);
        ResponseEntity<ReservationModel> entity = new ResponseEntity(reservationModelResponse, HttpStatus.CREATED);
        return entity;
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatusStatus() {
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2) {
        return reservationService.getReservationPeriod(d1, d2);

    }

}
