package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private ApartmentServiceImpl apartmentService;

    @RequestMapping(value = {"/apartment_report"}, method = RequestMethod.GET)
    public ModelAndView getAllApartments() {
        ModelAndView model = new ModelAndView();
        Date date = new Date();
        System.out.println(date.toString());
        List<Apartment> list = apartmentService.getAll();
        model.addObject("apartment_list", list);
        model.addObject("date", date.toString());
        model.setViewName("apartment_report");

        // Вывод текущей даты и времени с использованием toString()
        System.out.println(date.toString());
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
}
