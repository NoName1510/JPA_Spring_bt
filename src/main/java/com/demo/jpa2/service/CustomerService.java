package com.demo.jpa2.service;

import com.demo.jpa2.entity.Customer;
import com.demo.jpa2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> getCustomersByPhoneOrEmail(String phone, String email) {
        return customerRepository.findByPhoneOrEmail(phone, email);
    }

    public List<Customer> getAllFrom20to30() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusYears(30);
        LocalDate endDate = now.minusYears(20);
        return customerRepository.findBySexAndBirthdateBetween('M', startDate, endDate);
    }
}
