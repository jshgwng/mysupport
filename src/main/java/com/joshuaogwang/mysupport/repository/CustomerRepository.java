package com.joshuaogwang.mysupport.repository;

import com.joshuaogwang.mysupport.entity.Customer;
import com.joshuaogwang.mysupport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM TICKET WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    List<Ticket> getTicketsByCustomerId(Long customerId);
}
