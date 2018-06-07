package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@EntityListeners(AuditingEntityListener.class)
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer criticalRate;
    private Integer amount;
    private Double price;

    public Ingredients() {
    }

    public Ingredients(String name, Integer criticalRate, Integer amount, Double price) {
        this.name = name;
        this.criticalRate = criticalRate;
        this.amount = amount;
        this.price = price;
    }

    public Ingredients(Integer id, String name, Integer criticalRate,
                       Integer amount, Double price) {
        this.id = id;
        this.name = name;
        this.criticalRate = criticalRate;
        this.amount = amount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
