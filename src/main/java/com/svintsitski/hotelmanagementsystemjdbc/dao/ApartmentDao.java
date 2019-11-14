package com.svintsitski.hotelmanagementsystemjdbc.dao;


import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;

import java.util.List;

public interface ApartmentDao {
    List<Apartment> getAll();
    Apartment findById(int id);
    void add(Apartment apartment);
    void update(Apartment apartment);
    void delete(int id);
}
