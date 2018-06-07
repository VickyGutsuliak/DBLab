package com.example.demo.controller;

import com.example.demo.model.Ingredients;
import com.example.demo.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IngredientsController {
    @Autowired
    IngredientsRepository repository;

    @RequestMapping("/ingredients")
    public List<Ingredients> showIngredients() throws SQLException {
        return (List<Ingredients>)repository.findAll();
    }

    @RequestMapping("/ingredients/del")
    public void deleteIngredients(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/ingredients/add")
    public Ingredients addIngredients(@RequestParam int id, String name, int criticalRate,
                                      int amount, double price) throws SQLException {
        Ingredients ingredients = new Ingredients( name, criticalRate, amount, price);
        return repository.save(ingredients);
    }

    @RequestMapping("/ingredients/upd")
    public Ingredients updateIngredients(@RequestParam int id, String name, int criticalRate,
                                         int amount, double price) throws SQLException {
        Ingredients ingredients = new Ingredients(id, name, criticalRate, amount, price);
        return repository.save(ingredients);
    }


}
