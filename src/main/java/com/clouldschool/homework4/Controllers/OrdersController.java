package com.clouldschool.homework4.Controllers;

import com.clouldschool.homework4.Model.Orders;
import com.clouldschool.homework4.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    // Method to get all orders
    @GetMapping("/orders/all")
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    // Method to get an order by id
    @GetMapping("/orders/{id}")
    @ResponseBody
    public Orders getOrdersById(@PathVariable(value = "id") Integer ordersId) {
        return ordersService.getOrderById(ordersId);
    }

    // Method to insert a new order in table
    @PostMapping("/orders/new")
    public void insertOrder(@RequestBody Orders orders) {
        ordersService.insertOrder(orders);
    }

    // Method to update a pre-existent order
    @PostMapping("/orders/{id}")
    public Orders updateOrder(@PathVariable Integer id,
                              @RequestBody Orders orders) {
        return ordersService.updateOrders(orders, id);
    }

    // Method to delete an order
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteById(id);
    }
}
