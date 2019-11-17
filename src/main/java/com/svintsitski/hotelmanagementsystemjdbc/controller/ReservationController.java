package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/protected/reservation")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl service;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllBron() {
        ModelAndView model = new ModelAndView();
        List<Reservation> list = service.getAll();
        model.addObject("reservation_list", list);
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        model.setViewName("reservation_list");
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editBron(@PathVariable int id) {
        try {
            ModelAndView model = new ModelAndView();
            Reservation reservation = service.findById(id);
            model.addObject("reservationForm", reservation);
            model.setViewName("reservation_form");
            return model;
        } catch (Exception e) {
            return new ModelAndView("redirect:/protected/reservation/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addBron() {
        ModelAndView model = new ModelAndView();
        Reservation reservation = new Reservation();
        model.addObject("reservationForm", reservation);
        model.setViewName("reservation_form");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("reservationForm") Reservation reservation) {
        try {
            service.add(reservation);
            return new ModelAndView("redirect:/protected/reservation/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/protected/reservation/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("reservationForm") Reservation reservation) {
        service.update(reservation);
        return new ModelAndView("redirect:/protected/reservation/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBron(@PathVariable("id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/protected/reservation/list");
    }
}
