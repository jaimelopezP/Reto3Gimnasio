/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ciclo3.Reto3.repositories;

import com.Ciclo3.Reto3.models.ReservationModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jaime López Patiño
 */
public interface IReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {

    @Query("SELECT c.client, COUNT(c.client) FROM ReservationModel AS c group by c.client order by COUNT(c.client)desc")
    public List<Object[]> countTotalReservationByClient();

    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<ReservationModel> findAllByStatus(String description);

}
