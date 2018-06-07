package com.example.demo.controller;

import com.example.demo.model.DatesOfOrderingAndReceiving;
import com.example.demo.model.OrderStatus;
import com.example.demo.repository.DatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DatesOfOrderingAndReceivingController {
    @Autowired
    DatesRepository repository;

    @RequestMapping("/dates")
    public List<DatesOfOrderingAndReceiving> showDates() throws SQLException {
        return (List<DatesOfOrderingAndReceiving>)repository.findAll();
    }

    @RequestMapping("/dates/del")
    public void deleteDate(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/dates/add")
    public DatesOfOrderingAndReceiving addDate(@RequestParam int id, Date dateOfOrdering,
                                               Date dateOfReceiving, int orderStatus_id) throws SQLException {
        DatesOfOrderingAndReceiving date = new DatesOfOrderingAndReceiving(
                dateOfOrdering,
                dateOfReceiving,
                new OrderStatus(orderStatus_id, null)
        );
        return repository.save(date);
    }

    @RequestMapping("/dates/upd")
    public DatesOfOrderingAndReceiving updateDate(@RequestParam int id, Date dateOfOrdering,
                                                  Date dateOfReceiving, int orderStatus_id) throws SQLException {
        DatesOfOrderingAndReceiving date = new DatesOfOrderingAndReceiving(
                id,
                dateOfOrdering,
                dateOfReceiving,
                new OrderStatus(orderStatus_id, null)
        );
        return repository.save(date);
    }


}
