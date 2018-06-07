package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "buyer")
@EntityListeners(AuditingEntityListener.class)
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String PIB;
    private Integer age;

    public Buyer() {
    }

    public Buyer(String PIB, Integer age) {
        this.PIB = PIB;
        this.age = age;
    }

    public Buyer(Integer ID, String PIB, Integer age) {
        this.id = ID;
        this.PIB = PIB;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
