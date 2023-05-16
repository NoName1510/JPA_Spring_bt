package com.demo.jpa2.repository;

import com.demo.jpa2.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface  CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByName(String name);
    List<Customer> findByPhoneOrEmail(String phone, String email);
    List<Customer> findBySexAndBirthdateBetween(char sex, LocalDate start, LocalDate end);
}
