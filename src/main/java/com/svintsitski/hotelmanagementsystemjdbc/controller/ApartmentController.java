package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/confidential/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentServiceImpl apartmentService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllApartments() {
        ModelAndView model = new ModelAndView();
        List<Apartment> list = apartmentService.getAll();
        model.addObject("apartment_list", list);
        model.setViewName("apartment_list");
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editApartment(@PathVariable int id) {
        try {
            ModelAndView model = new ModelAndView();
            Apartment apartment = apartmentService.findById(id);
            model.addObject("apartmentForm", apartment);
            model.setViewName("apartment_form");
            return model;
        } catch (Exception e) {
            return new ModelAndView("redirect:/confidential/apartment/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addApartment() {
        ModelAndView model = new ModelAndView();
        Apartment apartment = new Apartment();
        model.addObject("apartmentForm", apartment);
        model.setViewName("apartment_form");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("apartmentForm") Apartment apartment) {
        try {
            apartmentService.add(apartment);
            return new ModelAndView("redirect:/confidential/apartment/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/confidential/apartment/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("apartmentForm") Apartment apartment) {
        apartmentService.update(apartment);
        return new ModelAndView("redirect:/confidential/apartment/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteApartment(@PathVariable("id") int id) {
        apartmentService.delete(id);
        return new ModelAndView("redirect:/confidential/apartment/list");
    }
}
