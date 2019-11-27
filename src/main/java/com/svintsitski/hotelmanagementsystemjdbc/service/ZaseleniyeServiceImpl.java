package com.svintsitski.hotelmanagementsystemjdbc.service;

import com.svintsitski.hotelmanagementsystemjdbc.dao.ZaseleniyeDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZaseleniyeServiceImpl implements ZaseleniyeService {

    @Autowired
    private ZaseleniyeDaoImpl zaseleniyeDao;

    @Override
    public List<Zaseleniye> getAll() {
        return zaseleniyeDao.getAll();
    }

    @Override
    public Zaseleniye findById(int id) {
        return zaseleniyeDao.findById(id);
    }

    @Override
    public void add(Zaseleniye zaseleniye) {
        zaseleniyeDao.add(zaseleniye);
    }

    @Override
    public void update(Zaseleniye zaseleniye) {
        zaseleniyeDao.update(zaseleniye);
    }

    @Override
    public void delete(int id) {
        zaseleniyeDao.delete(id);
    }

    @Override
    public List<Zaseleniye> free(String startDate, String finalDate) {
        return zaseleniyeDao.getFreeApart(startDate, finalDate);
    }
}
