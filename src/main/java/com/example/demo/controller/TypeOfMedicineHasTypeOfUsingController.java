package com.example.demo.controller;

import com.example.demo.model.TypeOfMedicine;
import com.example.demo.model.TypeOfMedicineHasTypeOfUsing;
import com.example.demo.model.TypeOfUsing;
import com.example.demo.repository.TypeOfMedicineHasTypeOfUsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfMedicineHasTypeOfUsingController {
    @Autowired
    TypeOfMedicineHasTypeOfUsingRepository repository;

    @RequestMapping("/type_medicine_has_type_using")
    public List<TypeOfMedicineHasTypeOfUsing> showTypeOfMedicineHasTypeOfUsing() throws SQLException {
        return (List<TypeOfMedicineHasTypeOfUsing>)repository.findAll();
    }

    @RequestMapping("/type_medicine_has_type_using/del")
    public void deleteTypeOfMedicineHasTypeOfUsing(@RequestParam int id) throws SQLException{
         repository.deleteById(id);
    }

    @RequestMapping("/type_medicine_has_type_using/add")
    public TypeOfMedicineHasTypeOfUsing addTypeOfMedicineHasTypeOfUsing(@RequestParam int id,
                                                                        int type_of_medicine_id,
                                                                        int type_of_using_id)
                                                                        throws SQLException{
        TypeOfMedicineHasTypeOfUsing typeOfMedicineHasTypeOfUsing =
                new TypeOfMedicineHasTypeOfUsing(
                        new TypeOfMedicine(type_of_medicine_id, null, null, null),
                        new TypeOfUsing(type_of_using_id, null)
                );

        return repository.save(typeOfMedicineHasTypeOfUsing);
    }

    @RequestMapping("/type_medicine_has_type_using/upd")
    public TypeOfMedicineHasTypeOfUsing updateTypeOfMedicineHasTypeOfUsing(@RequestParam int id,
                                                                        int type_of_medicine_id,
                                                                        int type_of_using_id)
                                                                        throws SQLException{
        TypeOfMedicineHasTypeOfUsing typeOfMedicineHasTypeOfUsing =
                new TypeOfMedicineHasTypeOfUsing(
                        id,
                        new TypeOfMedicine(type_of_medicine_id, null, null, null),
                        new TypeOfUsing(type_of_using_id, null)
                );

        return repository.save(typeOfMedicineHasTypeOfUsing);
    }


}
