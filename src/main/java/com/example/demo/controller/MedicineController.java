package com.example.demo.controller;

import com.example.demo.model.Medicine;
import com.example.demo.model.TypeOfMedicine;
import com.example.demo.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineController {
    @Autowired
    MedicineRepository repository;

    @RequestMapping("/medicine")
    public List<Medicine> showMedicine() throws SQLException {
        return (List<Medicine>)repository.findAll();
    }

    @RequestMapping("/medicine/del")
    public void deleteMedicine(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/medicine/add")
    public Medicine addMedicine(@RequestParam int id, String nameOfMedicine, int type_id,
                                int criticalRate, int amount, double price,
                                Date manufactureDate, int expirationTerm) throws SQLException {
        Medicine medicine = new Medicine(
            nameOfMedicine,
            new TypeOfMedicine(type_id, null, null, null),
            criticalRate,
            amount,
            price,
            manufactureDate,
            expirationTerm
        );

        return repository.save(medicine);
    }

    @RequestMapping("/medicine/upd")
    public Medicine updateMedicine(@RequestParam int id, String nameOfMedicine, int type_id,
                                   int criticalRate, int amount, double price,
                                   Date manufactureDate, int expirationTerm) throws SQLException {
        Medicine medicine = new Medicine(
            id,
            nameOfMedicine,
            new TypeOfMedicine(type_id, null, null, null),
            criticalRate,
            amount,
            price,
            manufactureDate,
            expirationTerm
        );

        return repository.save(medicine);
    }


}
