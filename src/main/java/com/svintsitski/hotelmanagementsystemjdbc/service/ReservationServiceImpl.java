package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.dao.ReservationDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDaoImpl dao;

    @Override
    public List<Reservation> getAll() {
        return dao.getAll();
    }

    @Override
    public Reservation findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void add(Reservation reservation) {
        dao.add(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        dao.update(reservation);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
