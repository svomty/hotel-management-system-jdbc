package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Review;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editBron(@PathVariable int id) {
        try {
            ModelAndView model = new ModelAndView();
            Review review = service.findById(id);
            model.addObject("reviewForm", review);
            model.setViewName("review_form");
            return model;
        } catch (Exception e) {
            return new ModelAndView("redirect:/reviews/list");
            //перенаправление на страницу ошибки
        }
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

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("reviewForm") Review review) {
        service.update(review);
        return new ModelAndView("redirect:/reviews/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/reviews/list");
    }
}
