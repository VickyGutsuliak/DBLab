package com.example.demo.controller;

import com.example.demo.model.TypeOfProduction;
import com.example.demo.repository.TypeOfProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfProductionController {
    @Autowired
    TypeOfProductionRepository repository;

    @RequestMapping("/type/production")
    public List<TypeOfProduction> showTypesOfProduction() throws SQLException {
        return (List<TypeOfProduction>)repository.findAll();
    }

    @RequestMapping("/type/production/del")
    public void deleteTypeOfProduction(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/type/production/add")
    public TypeOfProduction addTypeOfProduction(@RequestParam int id, String nameOfType) throws SQLException {
        TypeOfProduction typeOfProduction = new TypeOfProduction( nameOfType);

        return repository.save(typeOfProduction);
    }

    @RequestMapping("/type/production/upd")
    public TypeOfProduction updateTypeOfProduction(@RequestParam int id, String nameOfType) throws SQLException {
        TypeOfProduction typeOfProduction = new TypeOfProduction(id, nameOfType);

        return repository.save(typeOfProduction);
    }
}
