package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "medicine")
@EntityListeners(AuditingEntityListener.class)
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfMedicine;
    @ManyToOne
    private TypeOfMedicine typeOfMedicine;
    private Integer criticalRate;
    private Integer amount;
    private Double price;
    private Date manufactureDate;
    private Integer expirationTerm;

    public Medicine() {
    }

    public Medicine(String nameOfMedicine, TypeOfMedicine typeOfMedicine, Integer criticalRate, Integer amount, Double price, Date manufactureDate, Integer expirationTerm) {
        this.nameOfMedicine = nameOfMedicine;
        this.typeOfMedicine = typeOfMedicine;
        this.criticalRate = criticalRate;
        this.amount = amount;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expirationTerm = expirationTerm;
    }

    public Medicine(Integer id, String nameOfMedicine, TypeOfMedicine typeOfMedicine,
                    Integer criticalRate, Integer amount, Double price,
                    Date manufactureDate, Integer expirationTerm) {
        this.id = id;
        this.nameOfMedicine = nameOfMedicine;
        this.typeOfMedicine = typeOfMedicine;
        this.criticalRate = criticalRate;
        this.amount = amount;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.expirationTerm = expirationTerm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    public void setNameOfMedicine(String nameOfMedicine) {
        this.nameOfMedicine = nameOfMedicine;
    }

    public TypeOfMedicine getTypeOfMedicine() {
        return typeOfMedicine;
    }

    public void setTypeOfMedicine(TypeOfMedicine typeOfMedicine) {
        this.typeOfMedicine = typeOfMedicine;
    }

    public Integer getCriticalRate() {
        return criticalRate;
    }

    public void setCriticalRate(Integer criticalRate) {
        this.criticalRate = criticalRate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Integer getExpirationTerm() {
        return expirationTerm;
    }

    public void setExpirationTerm(Integer expirationTerm) {
        this.expirationTerm = expirationTerm;
    }
}
