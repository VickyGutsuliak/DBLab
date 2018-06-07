package com.example.demo.controller;

import com.example.demo.model.Buyer;
import com.example.demo.model.BuyersHasMedicines;
import com.example.demo.model.DatesOfOrderingAndReceiving;
import com.example.demo.model.Medicine;
import com.example.demo.repository.BuyerHasMedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuyerHasMedicinesController {
    @Autowired
    BuyerHasMedicinesRepository repository;

    @RequestMapping("/buyer_has_medicines")
    public List<BuyersHasMedicines> showBuyerHasMedicines() throws SQLException {
        return (List<BuyersHasMedicines>)repository.findAll();
    }

    @RequestMapping("/buyer_has_medicines/del")
    public void deleteBuyerHasMedicines(@RequestParam int id) throws SQLException {
        repository.deleteById(id);
    }

    @RequestMapping("/buyer_has_medicines/add")
    public BuyersHasMedicines addBuyerHasMedicines(@RequestParam int id, int buyer_id,
                                                   int medicine_id, int dates_id, String doctorPIB,
                                                   String diagnosis, int amount) throws SQLException {
        BuyersHasMedicines buyersHasMedicines = new BuyersHasMedicines(
                new Buyer(buyer_id, null, null),
                new Medicine(medicine_id, null, null, null,
                        null, null, null, null),
                new DatesOfOrderingAndReceiving(dates_id, null, null, null),
                doctorPIB,
                diagnosis,
                amount
        );
        return repository.save(buyersHasMedicines);
    }

    @RequestMapping("/buyer_has_medicines/upd")
    public BuyersHasMedicines updateBuyerHasMedicines(@RequestParam int id, int buyer_id,
                                                      int medicine_id, int dates_id, String doctorPIB,
                                                      String diagnosis, int amount) throws SQLException {
        BuyersHasMedicines buyersHasMedicines = new BuyersHasMedicines(
                id,
                new Buyer(buyer_id, null, null),
                new Medicine(medicine_id, null, null, null,
                        null, null, null, null),
                new DatesOfOrderingAndReceiving(dates_id, null, null, null),
                doctorPIB,
                diagnosis,
                amount
        );
        return repository.save(buyersHasMedicines);
    }
}
