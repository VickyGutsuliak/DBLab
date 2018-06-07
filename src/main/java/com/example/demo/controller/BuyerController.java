package com.example.demo.controller;

import com.example.demo.model.Buyer;
import com.example.demo.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuyerController {
    @Autowired
    BuyerRepository repository;

    @RequestMapping("/buyers")
    public List<Buyer> showBuyers() throws SQLException {
        return (List<Buyer>)repository.findAll();
    }

    @RequestMapping("/buyers/del")
    public void deleteBuyer(@RequestParam int id) throws SQLException{
        repository.deleteById(id);
    }

    @RequestMapping("/buyers/add")
    public Buyer addBuyer(@RequestParam int id, String PIB, int age) throws SQLException{
        Buyer buyer = new Buyer(PIB, age);
        return repository.save(buyer);
    }

    @RequestMapping("/buyers/upd")
    public Buyer updateBuyer(@RequestParam int id, String PIB, int age) throws SQLException{
        Buyer buyer = new Buyer(id, PIB, age);
        return repository.save(buyer);
    }
}
