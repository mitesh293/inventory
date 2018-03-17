package com.mit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mit.model.Customer;
import com.mit.serviceImpl.CustomerServiceImpl;

 
@Controller
public class CustomerController {
 
    private static final Logger logger = Logger
            .getLogger(CustomerController.class);
 
    public CustomerController() {
        System.out.println("CustomerController()");
    }
 
    @Autowired
    private CustomerServiceImpl CustomerService;
 
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView listCustomer(ModelAndView model) throws IOException {
        List<Customer> listCustomer = CustomerService.getAllCustomers();
        System.out.println(listCustomer.size());
        model.addObject("listCustomer", listCustomer);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Customer Customer = new Customer();
        model.addObject("Customer", Customer);
        model.setViewName("CustomerForm");
        return model;
    }
   
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute Customer Customer) {
        if (Customer.getId() == 0) { // if Customer id is 0 then creating the
            // Customer other updating the Customer
            CustomerService.addCustomer(Customer);
        } else {
            CustomerService.updateCustomer(Customer);
        }
        return new ModelAndView("redirect:/home");
    }
 
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(HttpServletRequest request) {
        int CustomerId = Integer.parseInt(request.getParameter("id"));
        CustomerService.deleteCustomer(CustomerId);
        return new ModelAndView("redirect:/home");
    }
 
    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int CustomerId = Integer.parseInt(request.getParameter("id"));
        Customer Customer = CustomerService.getCustomer(CustomerId);
        ModelAndView model = new ModelAndView("CustomerForm");
        model.addObject("Customer", Customer);
 
        return model;
    }
 
}