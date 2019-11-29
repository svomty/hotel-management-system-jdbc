package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Review;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl service;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllBron() {
        ModelAndView model = new ModelAndView();
        List<Review> list = service.getAll();
        model.addObject("reviews", list);
        List<Employee> employees = employeeService.getAll();
        model.addObject("employee_list", employees);
        Review review = new Review();
        model.addObject("reviewForm", review);
        model.setViewName("reviews");
        return model;
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("reviewForm") Review review) {
        try {
            service.add(review);
            return new ModelAndView("redirect:/reviews/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/reviews/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("reviewForm") Review review) {
        try {
            service.add(review);
            return new ModelAndView("redirect:/reviews/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/reviews/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id, @CookieValue(value = "role", required = false) Cookie role,
                               @CookieValue(value = "login", required = false) Cookie login) {
        if (role.getValue().equals("ROLE_SUPERADMIN")) {
            service.delete(id);
        } else if (role.getValue().equals("ROLE_ADMIN")) {
            List<Review> reviews = service.getAll();
            for (Review review : reviews) {
                if (review.getId().equals(id)) {//поиск отзыва
                    List<Employee> employees = employeeService.getAll();
                    for (Employee employee : employees) {
                        if (employee.getEmployeeId().equals(review.getUser_id())) {//поиск пользователя
                            if (employee.getPassportId().equals(login.getValue())) {
                                service.delete(id);
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Недостаточно прав");
        }
        return new ModelAndView("redirect:/reviews/list");
    }
}
