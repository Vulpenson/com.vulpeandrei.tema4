package com.clouldschool.homework4.Repository;

import com.clouldschool.homework4.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
