package com.joshuaogwang.mysupport.service;

import com.joshuaogwang.mysupport.entity.Customer;
import com.joshuaogwang.mysupport.entity.Ticket;
import com.joshuaogwang.mysupport.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
@Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow();
    }
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(Long id, Customer customer){
        Customer customer1 = customerRepository.findById(id).orElseThrow();
        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        return customerRepository.save(customer1);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
    public List<Ticket> getTicketsByCustomerId(Long customerId){
        return customerRepository.getTicketsByCustomerId(customerId);
    }
}
