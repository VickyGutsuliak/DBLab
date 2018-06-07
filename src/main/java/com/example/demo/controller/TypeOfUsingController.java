package com.example.demo.controller;

import com.example.demo.model.TypeOfUsing;
import com.example.demo.repository.TypeOfUsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfUsingController {
    @Autowired
    TypeOfUsingRepository repository;

    @RequestMapping("/type/using")
    public List<TypeOfUsing> showTypesOfUsing() throws SQLException {
        return (List<TypeOfUsing>)repository.findAll();
    }

    @RequestMapping("/type/using/del")
    public void deleteTypeOfUsing(@RequestParam int id) throws SQLException {
        repository.deleteById(id);
    }

    @RequestMapping("/type/using/add")
    public TypeOfUsing addTypeOfUsing(@RequestParam int id, String nameOfType) throws SQLException {
        TypeOfUsing typeOfUsing = new TypeOfUsing( nameOfType);

        return repository.save(typeOfUsing);
    }

    @RequestMapping("/type/using/upd")
    public TypeOfUsing updateTypeOfUsing(@RequestParam int id, String nameOfType) throws SQLException {
        TypeOfUsing typeOfUsing = new TypeOfUsing(id, nameOfType);

        return repository.save(typeOfUsing);
    }


}
