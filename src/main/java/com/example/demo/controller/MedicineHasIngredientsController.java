package com.example.demo.controller;

import com.example.demo.model.Ingredients;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineHasIngredients;
import com.example.demo.repository.MedicineHasIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineHasIngredientsController {
    @Autowired
    MedicineHasIngredientsRepository repository;

    @RequestMapping("/medicine/has_ingredients")
    public List<MedicineHasIngredients> showMedicineHasIngredients() throws SQLException {
        return (List<MedicineHasIngredients> )repository.findAll();
    }

    @RequestMapping("/medicine/has_ingredients/del")
    public void deleteMedicineHasIngredients(@RequestParam int id) throws SQLException{
         repository.deleteById(id);
    }

    @RequestMapping("/medicine/has_ingredients/add")
    public MedicineHasIngredients addMedicineHasIngredients(@RequestParam int id, int med_id,
                                                            int ingredients_id, int ingredientsAmount) throws SQLException{
        MedicineHasIngredients medicineHasIngredients = new MedicineHasIngredients(
                new Medicine(med_id, null, null,
                        null, null, null, null, null),
                new Ingredients(ingredients_id, null, null, null, null),
                ingredientsAmount
        );

        return repository.save(medicineHasIngredients);
    }

    @RequestMapping("/medicine/has_ingredients/upd")
    public MedicineHasIngredients updateMedicineHasIngredients(@RequestParam int id, int med_id,
                                                               int ingredients_id, int ingredientsAmount) throws SQLException{
        MedicineHasIngredients medicineHasIngredients = new MedicineHasIngredients(
                id,
                new Medicine(med_id, null, null,
                        null, null, null, null, null),
                new Ingredients(ingredients_id, null, null, null, null),
                ingredientsAmount
        );

        return repository.save(medicineHasIngredients);
    }
}
