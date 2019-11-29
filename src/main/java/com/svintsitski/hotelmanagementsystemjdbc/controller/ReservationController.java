package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Reservation;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/protected/reservation")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl service;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ApartmentServiceImpl apartmentService;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addBron() {
        ModelAndView model = new ModelAndView();
        Reservation reservation = new Reservation();
        model.addObject("reservationForm", reservation);
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        model.setViewName("reservation_form");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("reservationForm") Reservation reservation) {
        reservation.setFinal_date(reservation.getFinal_date());
        reservation.setStart_date(reservation.getStart_date());
        if (reservation.getRoom() != null) {
            try {
                service.add(reservation);
                return new ModelAndView("redirect:/protected/reservation/list");
            } catch (Exception e) {
                return new ModelAndView("redirect:/protected/reservation/list");
                //перенаправление на страницу ошибки
            }
        } else {

            Date start_date = reservation.getStart_date();
            Date final_date = reservation.getFinal_date();
            List<Apartment> rooms = apartmentService.getAll();

            LocalDate localDate = start_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year = localDate.getYear();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            String day_s = (day < 10) ? "0" + day : "" + day;
            String month_s = (month < 10) ? "0" + month : "" + month;
            String date = year + "-" + month_s + "-" + day_s;

            LocalDate localDate2 = final_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year2 = localDate2.getYear();
            int month2 = localDate2.getMonthValue();
            int day2 = localDate2.getDayOfMonth();

            String day2_s = (day2 < 10) ? "0" + day2 : "" + day2;
            String month2_s = (month2 < 10) ? "0" + month2 : "" + month2;
            String date2 = year2 + "-" + month2_s + "-" + day2_s;

            System.out.println(date + " " + date2);
            List<Reservation> roomsN = service.free(date, date2);
            List<Apartment> freeRooms = new ArrayList<>();
            boolean b = true;
            for (Apartment a : rooms) {
                for (Reservation num : roomsN) {
                    if (num.getRoom().equals(a.getId())) {
                        b = false;
                    }
                }
                if (b) {
                    freeRooms.add(a);
                }
                b = true;
            }

            if (localDate.isAfter(localDate2)) {
                throw new IllegalArgumentException("Неверные даты");
            }

            ModelAndView model = new ModelAndView();
            model.addObject("reservationForm", reservation);
            model.addObject("rooms", freeRooms);
            model.addObject("date", date);
            model.addObject("date2", date2);
            List<Employee> employees = employeeService.getAll();
            model.addObject("employee_list", employees);
            model.setViewName("reservation_form");
            return model;

        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBron(@PathVariable("id") int id, @CookieValue(value = "role", required = false) Cookie role,
                                   @CookieValue(value = "login", required = false) Cookie login) {
        if (role.getValue().equals("ROLE_SUPERADMIN")) {
            service.delete(id);
        } else if (role.getValue().equals("ROLE_ADMIN")) {
            List<Reservation> reservations = service.getAll();
            for (Reservation reservation : reservations) {
                if (reservation.getId().equals(id)) {//поиск брони
                    List<Employee> employees = employeeService.getAll();
                    for (Employee employee : employees) {
                        if (employee.getEmployeeId().equals(reservation.getUser_id())) {//поиск пользователя
                            if (employee.getPassportId().equals(login.getValue())) {
                                service.delete(id);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return new ModelAndView("redirect:/protected/reservation/list");
    }
}
