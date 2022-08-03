package com.clouldschool.homework4.Repository;

import com.clouldschool.homework4.Model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Integer> {
    List<Orders> findAll();
}
