package com.clouldschool.homework4.Service;

import com.clouldschool.homework4.Model.Orders;
import com.clouldschool.homework4.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrderRepository orderRepository;

    List<Orders> list = new ArrayList<>();

    public List<Orders> getAllOrders() {
        List<Orders> aux = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Orders getOrderById(Integer id) {
        Orders aux = new Orders();
        if (orderRepository.findById(id).isPresent()) {
            aux = orderRepository.findById(id).get();
        }
        return aux;
    }

    public void insertOrder(Orders orders) {
        orderRepository.save(orders);
    }

    public Orders updateOrders(Orders orders, Integer ordersId) {
        Orders tmp = orderRepository.findById(ordersId).get();
        tmp.setComments(orders.getComments());
        tmp.setStatus(orders.getStatus());
        return orderRepository.save(tmp);
    }

    public void deleteById(Integer ordersId) {
        orderRepository.deleteById(ordersId);
    }
}
