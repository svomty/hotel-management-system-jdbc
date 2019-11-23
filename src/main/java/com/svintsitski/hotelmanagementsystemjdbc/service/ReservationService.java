package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();

    Reservation findById(int id);

    void add(Reservation reservation);

    void update(Reservation reservation);

    void delete(int id);

    List<Reservation> free(String startDate, String finalDate);
}
