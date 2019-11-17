package com.svintsitski.hotelmanagementsystemjdbc.dao;

import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;

import java.util.List;

public interface ZaseleniyeDao {
    List<Zaseleniye> getAll();

    Zaseleniye findById(int id);

    void add(Zaseleniye zaseleniye);

    void update(Zaseleniye zaseleniye);

    void delete(int id);
}
