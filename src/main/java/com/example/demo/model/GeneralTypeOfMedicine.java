package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "general_type_of_medicine")
@EntityListeners(AuditingEntityListener.class)
public class GeneralTypeOfMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfGeneralType;

    public GeneralTypeOfMedicine() {
    }

    public GeneralTypeOfMedicine(Integer id, String nameOfGeneralType) {
        this.id = id;
        this.nameOfGeneralType = nameOfGeneralType;
    }

    public GeneralTypeOfMedicine(String nameOfGeneralType) {
        this.nameOfGeneralType = nameOfGeneralType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfGeneralType() {
        return nameOfGeneralType;
    }

    public void setNameOfGeneralType(String nameOfGeneralType) {
        this.nameOfGeneralType = nameOfGeneralType;
    }
}
