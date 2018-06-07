package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_production")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfType;

    public TypeOfProduction() {
    }

    public TypeOfProduction(String nameOfType) {
        this.nameOfType = nameOfType;
    }

    public TypeOfProduction(Integer id, String nameOfType) {
        this.id = id;
        this.nameOfType = nameOfType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfType() {
        return nameOfType;
    }

    public void setNameOfType(String nameOfType) {
        this.nameOfType = nameOfType;
    }
}
