package com.example.demo.controller;

import com.example.demo.model.GeneralTypeOfMedicine;
import com.example.demo.model.TypeOfMedicine;
import com.example.demo.model.TypeOfProduction;
import com.example.demo.repository.TypeOfMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfMedicineController {
    @Autowired
    TypeOfMedicineRepository repository;

    @RequestMapping("/type/medicine")
    public List<TypeOfMedicine> showTypeOfMedicine() throws SQLException {
        return (List<TypeOfMedicine>)repository.findAll();
    }

    @RequestMapping("/type/medicine/del")
    public void deleteTypeOfMedicine(@RequestParam int id) throws SQLException {
         repository.deleteById(id);
    }

    @RequestMapping("/type/medicine/add")
    public TypeOfMedicine addTypeOfMedicine(@RequestParam int id, String nameOfType,
                                            int gen_type_id, int production_id) throws SQLException {
        TypeOfMedicine typeOfMedicine = new TypeOfMedicine(
                nameOfType,
                new GeneralTypeOfMedicine(gen_type_id, null),
                new TypeOfProduction(production_id, null)
        );
        return repository.save(typeOfMedicine);
    }

    @RequestMapping("/type/medicine/upd")
    public TypeOfMedicine updateTypeOfMedicine(@RequestParam int id, String nameOfType,
                                               int gen_type_id, int production_id) throws SQLException {
        TypeOfMedicine typeOfMedicine = new TypeOfMedicine(
                id,
                nameOfType,
                new GeneralTypeOfMedicine(gen_type_id, null),
                new TypeOfProduction(production_id, null)
        );
        return repository.save(typeOfMedicine);
    }


}
