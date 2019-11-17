package com.svintsitski.hotelmanagementsystemjdbc.controller;

import com.svintsitski.hotelmanagementsystemjdbc.model.Employee;
import com.svintsitski.hotelmanagementsystemjdbc.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/confidential/employee")
public class EmployeeController {

    @Autowired
    public InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView getAllEmployees() {
        ModelAndView model = new ModelAndView();
        List<Employee> list = employeeService.getAll();

        model.addObject("employee_list", list);
        model.setViewName("employee_list");
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView editEmployee(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Employee employee = employeeService.findById(id);
        model.addObject("employeeForm", employee);

        model.setViewName("employee_form");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addEmployee() {
        ModelAndView model = new ModelAndView();

        Employee employee = new Employee();
        model.addObject("employeeForm", employee);

        model.setViewName("employee_form");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("employeeForm") Employee employee) {
        try {
            if (employee.getEmployeeId() != null) {
                employeeService.update(employee);
            } else {
                employeeService.add(employee);
            }

            User.UserBuilder users = User.withDefaultPasswordEncoder();
            inMemoryUserDetailsManager.createUser(users.username(employee.getPassportId())
                    .password(employee.getPassword()).roles("USER", "ADMIN").build());

            return new ModelAndView("redirect:/confidential/employee/list");
        } catch (Exception e) {
            return new ModelAndView("redirect:/confidential/employee/list");
            //перенаправление на страницу ошибки
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        inMemoryUserDetailsManager.deleteUser(employee.getPassportId());
        employeeService.delete(id);

        return new ModelAndView("redirect:/confidential/employee/list");
    }
}
