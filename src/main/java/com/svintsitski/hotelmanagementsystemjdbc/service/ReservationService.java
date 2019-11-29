package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();

    Reservation findById(int id);

    void add(Reservation reservation);

    void delete(int id);

    List<Reservation> free(String startDate, String finalDate);
}
