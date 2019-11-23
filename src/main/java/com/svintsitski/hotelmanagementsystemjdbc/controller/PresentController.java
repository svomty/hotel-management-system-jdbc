package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.dao.ZaseleniyeDaoImpl;
import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ZaseleniyeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Controller
@RequestMapping("/confidential/zaseleniye")
public class PresentController {

    @Autowired
    private ZaseleniyeServiceImpl service;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ApartmentServiceImpl apartmentService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllZaseleniye() {
        ModelAndView model = new ModelAndView();
        List<Zaseleniye> list = service.getAll();
        model.addObject("zaseleniye_list", list);
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        model.setViewName("zaseleniye_list");
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editZaseleniye(@PathVariable int id) {
        try {
            ModelAndView model = new ModelAndView();
            Zaseleniye zaseleniye = service.findById(id);
            model.addObject("zaseleniyeForm", zaseleniye);

            List<Apartment> rooms = apartmentService.getAll();
            model.addObject("rooms", rooms);

            model.setViewName("zaseleniye_form");
            return model;
        } catch (Exception e) {
            return new ModelAndView("redirect:/confidential/zaseleniye/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addZaseleniye() {
        ModelAndView model = new ModelAndView();
        Zaseleniye zaseleniye = new Zaseleniye();
        model.addObject("zaseleniyeForm", zaseleniye);
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        model.setViewName("zaseleniye_form");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("zaseleniyeForm") Zaseleniye zaseleniye) {
        zaseleniye.setFinal_date(zaseleniye.getFinal_date());
        zaseleniye.setStart_date(zaseleniye.getStart_date());
        if (zaseleniye.getRoom() != null) {
            try {
                service.add(zaseleniye);
                return new ModelAndView("redirect:/confidential/zaseleniye/list");
            } catch (Exception e) {
                return new ModelAndView("redirect:/confidential/zaseleniye/list");
                //перенаправление на страницу ошибки
            }
        } else {

            Date start_date = zaseleniye.getStart_date();
            Date final_date = zaseleniye.getFinal_date();
            List<Apartment> rooms = apartmentService.getAll();

            LocalDate localDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            String day_s = (day<10)? "0"+day : ""+day;
            String month_s = (month<10)? "0"+month : ""+month;
            String date = year + "-" + month_s + "-" + day_s;

            LocalDate localDate2 = final_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year2 = localDate2.getYear();
            int month2 = localDate2.getMonthValue();
            int day2 = localDate2.getDayOfMonth();

            String day2_s = (day2<10)? "0"+day2 : ""+day2;
            String month2_s = (month2<10)? "0"+month2 : ""+month2;
            String date2 = year2 + "-" + month2_s + "-" + day2_s;

            System.out.println(date + " " + date2);
            List<Zaseleniye> roomsN = service.free(date, date2);
            List<Apartment> freeRooms = new ArrayList<>();
            boolean b = true;
            for (Apartment a : rooms){
                for (Zaseleniye num : roomsN){
                    if (num.getRoom().equals(a.getId())){
                        b = false;
                    }
                }
                if (b){
                    freeRooms.add(a);
                }
                b = true;
            }

            ModelAndView model = new ModelAndView();
            model.addObject("zaseleniyeForm", zaseleniye);
            model.addObject("rooms", freeRooms);
            model.addObject("date", date);
            model.addObject("date2", date2);
            model.setViewName("zaseleniye_form");
            return model;

        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("zaseleniyeForm") Zaseleniye zaseleniye) {
        service.update(zaseleniye);
        return new ModelAndView("redirect:/confidential/zaseleniye/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteZaseleniye(@PathVariable("id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/confidential/zaseleniye/list");
    }
}
