package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.persist.entity.Customer;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myproject.service.CustomerService;
import com.mycompany.myproject.service.dto.CustomerDto;

@Controller
@Scope("request")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MessageSource ms;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public @ResponseBody
    List<CustomerDto> getCustomers() {
        logger.debug("get json user list");
        return customerService.findAll();
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
