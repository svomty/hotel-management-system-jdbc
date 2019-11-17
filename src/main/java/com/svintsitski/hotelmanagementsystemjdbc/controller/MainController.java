package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView model = new ModelAndView();

        List<Employee> list = employeeService.getAll();
        model.addObject("employee_list", list);

        model.setViewName("main");
        return model;
    }
}
