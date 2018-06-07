package com.example.demo.controller;

import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderStatusController {
    @Autowired
    OrderStatusRepository repository;

    @RequestMapping("/order_status")
    public List<OrderStatus> showOrderStatus() throws SQLException {
        return (List<OrderStatus>)repository.findAll();
    }

    @RequestMapping("/order_status/del")
    public void deleteOrderStatus(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/order_status/add")
    public OrderStatus addOrderStatus(@RequestParam int id, String nameOfStatus) throws SQLException {
        OrderStatus orderStatus = new OrderStatus( nameOfStatus);

        return repository.save(orderStatus);
    }

    @RequestMapping("/order_status/upd")
    public OrderStatus updateOrderStatus(@RequestParam int id, String nameOfStatus) throws SQLException {
        OrderStatus orderStatus = new OrderStatus(id, nameOfStatus);

        return repository.save(orderStatus);
    }


}
