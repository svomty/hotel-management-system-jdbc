package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.dao.ApartmentDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentDaoImpl apartmentDao;

    @Override
    public List<Apartment> getAll() {
        return apartmentDao.getAll();
    }

    @Override
    public Apartment findById(int id) {
        return apartmentDao.findById(id);
    }

    @Override
    public void add(Apartment apartment) {
        apartmentDao.add(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        apartmentDao.update(apartment);
    }

    @Override
    public void delete(int id) {
        apartmentDao.delete(id);
    }
}
