package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;

import java.util.List;

public interface ReservationDao {
    List<Reservation> getAll();

    Reservation findById(int id);

    void add(Reservation reservation);

    void delete(int id);
}
