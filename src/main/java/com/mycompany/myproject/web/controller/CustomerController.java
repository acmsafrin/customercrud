package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.persist.entity.Customer;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myproject.service.CustomerService;
import com.mycompany.myproject.service.dto.CustomerDto;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Scope("request")
public class CustomerController {

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageSource ms;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public @ResponseBody
    List<CustomerDto> getCustomers() {
        List<CustomerDto> list = customerService.findAll();
        return list;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public @ResponseBody
    CustomerDto getCustomer(@PathVariable Long id) {
        CustomerDto dto = customerService.findOne(id);
        return dto;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseBody
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = customerService.save(customerDto);
        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    @ResponseBody
    public Customer updateCustomer(CustomerDto customerDto) {
        Customer customer = customerService.save(customerDto);
        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCustomer(CustomerDto customerDto) {
        customerService.delete(customerDto);
        return "";
    }
}
