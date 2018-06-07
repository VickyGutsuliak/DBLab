package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_medicine_has_type_of_using")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfMedicineHasTypeOfUsing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private TypeOfMedicine typeOfMedicine;
    @ManyToOne
    private TypeOfUsing typeOfUsing;

    public TypeOfMedicineHasTypeOfUsing() {
    }

    public TypeOfMedicineHasTypeOfUsing(TypeOfMedicine typeOfMedicine, TypeOfUsing typeOfUsing) {
        this.typeOfMedicine = typeOfMedicine;
        this.typeOfUsing = typeOfUsing;
    }

    public TypeOfMedicineHasTypeOfUsing(Integer id, TypeOfMedicine typeOfMedicine, TypeOfUsing typeOfUsing) {
        this.id = id;
        this.typeOfMedicine = typeOfMedicine;
        this.typeOfUsing = typeOfUsing;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeOfMedicine getTypeOfMedicine() {
        return typeOfMedicine;
    }

    public void setTypeOfMedicine(TypeOfMedicine typeOfMedicine) {
        this.typeOfMedicine = typeOfMedicine;
    }

    public TypeOfUsing getTypeOfUsing() {
        return typeOfUsing;
    }

    public void setTypeOfUsing(TypeOfUsing typeOfUsing) {
        this.typeOfUsing = typeOfUsing;
    }
}
