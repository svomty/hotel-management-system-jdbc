package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value= {"/", "/list"}, method= RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView();
        List<Employee> list = employeeService.getAll();

        model.addObject("employee_list", list);
        model.setViewName("employee_list");
        return model;
    }

    @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Employee employee = employeeService.findById(id);
        System.out.print(employee.toString());
        model.addObject("employeeForm", employee);

        model.setViewName("employee_form");
        return model;
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addEmployee() {
        ModelAndView model = new ModelAndView();

        Employee employee = new Employee();
        model.addObject("employeeForm", employee);

        model.setViewName("employee_form");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("employeeForm") Employee employee) {
        if(employee.getEmployeeId() != null) {
            employeeService.update(employee);
        } else {
            employeeService.add(employee);
        }

        return new ModelAndView("redirect:/employee/list");
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);

        return new ModelAndView("redirect:/employee/list");
    }
}
