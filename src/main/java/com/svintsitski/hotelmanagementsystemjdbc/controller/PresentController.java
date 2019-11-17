package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Apartment;
import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.model.Zaseleniye;
import com.svintsitski.hotelmanagementsystemjdbc.service.ApartmentServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import com.svintsitski.hotelmanagementsystemjdbc.service.ZaseleniyeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/confidential/zaseleniye")
public class PresentController {

    @Autowired
    private ZaseleniyeServiceImpl service;
    @Autowired
    private EmployeeServiceImpl employeeService;

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
        model.setViewName("zaseleniye_form");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("zaseleniyeForm") Zaseleniye zaseleniye) {
        try {
            service.add(zaseleniye);
            return new ModelAndView("redirect:/confidential/zaseleniye/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/confidential/zaseleniye/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("apartmentForm") Zaseleniye zaseleniye) {
        service.update(zaseleniye);
        return new ModelAndView("redirect:/confidential/zaseleniye/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteZaseleniye(@PathVariable("id") int id) {
        service.delete(id);
        return new ModelAndView("redirect:/confidential/zaseleniye/list");
    }
}
