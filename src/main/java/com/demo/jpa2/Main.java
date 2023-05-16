package com.demo.jpa2;

import com.demo.jpa2.config.SpringConfig;
import com.demo.jpa2.entity.Customer;
import com.demo.jpa2.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    // static CustomerRepository customerRepository =(CustomerRepository) context.getBean("customerRepository");

    //test dung service
    static CustomerService customerService = context.getBean(CustomerService.class);

    public static void main(String[] args) {
//        add();
//        getAll();
//        findById(5);
//        findByName("test");
//        findByPhoneOrEmail(null, "Test2@gmail.com");
        getAllFrom20to30();
    }

    private static void add() {
        Customer customer = new Customer();
        customer.setName("Test4");
        customer.setBirthdate(LocalDate.parse("1998-10-15"));
        customer.setSex('M');
        customer.setEmail("Test4@gmail.com");
        customer.setPhone("1234567890");
        customer.setAddress("Da Nang");
        Customer result = customerService.addCustomer(customer);
        if (result != null) {
            System.out.println("Da luu thanh cong, customer id =" + result.getId());
        }
    }

    private static void getAll() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        System.out.println("All customers:");
        for (Customer c : allCustomers) {
            System.out.println(c.getId() + " - " + c.toString());
        }
    }

    private static void findById(int id) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            Customer Customer = optionalCustomer.get();
            System.out.println("Customer by id " + id + ": " + Customer.toString());
        } else {
            System.out.println("No customer by id " + id);
        }
    }

    private static void findByName(String customerName) {
        List<Customer> customersByName = customerService.getCustomersByName(customerName);
        System.out.println("Customers by name " + customerName + ":");
        for (Customer c : customersByName) {
            System.out.println(c.getId() + " - " + c.toString());
        }
    }

    private static void findByPhoneOrEmail(String customerPhone, String customerEmail) {
        List<Customer> customersByPhoneOrEmail = customerService.getCustomersByPhoneOrEmail(customerPhone, customerEmail);
        System.out.println("Customers by phone " + customerPhone + " or email " + customerEmail + ":");
        for (Customer c : customersByPhoneOrEmail) {
            System.out.println(c.getId() + " - " + c.toString());
        }
    }

    private static void getAllFrom20to30() {
        List<Customer> Customers20to30 = customerService.getAllFrom20to30();
        System.out.println("Customers 20 to 30:");
        for (Customer c : Customers20to30) {
            System.out.println(c.getId() + " - " + c.toString());
        }
    }

}