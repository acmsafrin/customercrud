package com.mycompany.myproject.persist.repo;

import com.mycompany.myproject.persist.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
