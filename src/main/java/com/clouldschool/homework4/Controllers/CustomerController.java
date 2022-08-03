package com.clouldschool.homework4.Controllers;

import com.clouldschool.homework4.Model.Customer;
import com.clouldschool.homework4.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Method to get all customers
    @GetMapping("/customers/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Method to get a customer by id
    @GetMapping("/customers/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable(value = "id") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    // Method to insert a new customer in table
    @PostMapping("/customers/new")
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.insertCustomer(customer);
    }

    // Method to update a pre-existent customer
    @PostMapping("/customers/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,
                               @PathVariable(value = "id") Integer customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

    // Method to delete a customer
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Integer customerId) {
        customerService.deleteById(customerId);
    }
}
