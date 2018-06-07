package com.example.demo.controller;

import com.example.demo.model.GeneralTypeOfMedicine;
import com.example.demo.repository.GeneralTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralTypeOfMedicineController {
    @Autowired
    GeneralTypesRepository repository;

    @RequestMapping("/general_types")
    public List<GeneralTypeOfMedicine> showGeneralTypes() throws SQLException {
        return (List<GeneralTypeOfMedicine>)repository.findAll();
    }

    @RequestMapping("/general_types/del")
    public void deleteGeneralType(@RequestParam int id) throws SQLException{
         repository.deleteById(id);
    }

    @RequestMapping("/general_types/add")
    public GeneralTypeOfMedicine addGeneralType(@RequestParam int id, String generalType) throws SQLException{
        GeneralTypeOfMedicine generalTypeOfMedicine = new GeneralTypeOfMedicine(generalType);
        return repository.save(generalTypeOfMedicine);
    }

    @RequestMapping("/general_types/upd")
    public GeneralTypeOfMedicine updateGeneralType(@RequestParam int id, String generalType) throws SQLException{
        GeneralTypeOfMedicine generalTypeOfMedicine = new GeneralTypeOfMedicine(id, generalType);
        return repository.save(generalTypeOfMedicine);
    }


}
