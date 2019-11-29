package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ReservationServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ZaseleniyeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ApartmentServiceImpl apartmentService;
    @Autowired
    private ReservationServiceImpl reservationService;
    @Autowired
    private ZaseleniyeServiceImpl zaseleniyeService;


    @RequestMapping(value = {"/reports/employee"}, method = RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView();
        List<Employee> list = employeeService.getAll();
        Date date = new Date();
        model.addObject("date", date.toString());
        model.addObject("employee_list", list);
        model.setViewName("employee_report");
        return model;
    }

    @RequestMapping(value = {"/reports/apartment"}, method = RequestMethod.GET)
    public ModelAndView getAllApartments() {
        ModelAndView model = new ModelAndView();
        Date date = new Date();
        List<Apartment> list = apartmentService.getAll();
        model.addObject("apartment_list", list);
        model.addObject("date", date.toString());
        model.setViewName("apartment_report");
        return model;
    }


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView();

        List<Employee> list = employeeService.getAll();
        model.addObject("employee_list", list);

        model.setViewName("main");
        return model;
    }

    @RequestMapping(value = {"/reports/reservation"}, method = RequestMethod.GET)
    public ModelAndView getAllBron() {
        ModelAndView model = new ModelAndView();
        List<Reservation> list = reservationService.getAll();
        model.addObject("reservation_list", list);
        Date date = new Date();
        model.addObject("date", date.toString());
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        List<Apartment> apartments = apartmentService.getAll();
        model.addObject("apartments_list", apartments);
        model.setViewName("reservation_report");
        return model;
    }

    @RequestMapping(value = {"/reports/zaseleniye"}, method = RequestMethod.GET)
    public ModelAndView getAllZaseleniye() {
        ModelAndView model = new ModelAndView();
        List<Zaseleniye> list = zaseleniyeService.getAll();
        model.addObject("zaseleniye_list", list);
        Date date = new Date();
        model.addObject("date", date.toString());
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        List<Apartment> apartments = apartmentService.getAll();
        model.addObject("apartments_list", apartments);
        model.setViewName("zaseleniye_report");
        return model;
    }
}
