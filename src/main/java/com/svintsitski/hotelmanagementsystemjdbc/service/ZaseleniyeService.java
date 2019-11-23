package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;

import java.util.List;

public interface ZaseleniyeService {
    List<Zaseleniye> getAll();

    Zaseleniye findById(int id);

    void add(Zaseleniye zaseleniye);

    void update(Zaseleniye zaseleniye);

    void delete(int id);

    List<Zaseleniye> free(String startDate, String finalDate);
}
