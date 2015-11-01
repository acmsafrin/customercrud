package com.mycompany.myproject.service;

import com.mycompany.myproject.persist.entity.Customer;
import org.springframework.stereotype.Service;

import com.mycompany.myproject.service.dto.CustomerDto;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Customer, CustomerDto, Long> implements CustomerService {


}
