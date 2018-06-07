package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "order_status")
@EntityListeners(AuditingEntityListener.class)
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfStatus;

    public OrderStatus() {
    }

    public OrderStatus(String nameOfStatus) {
        this.nameOfStatus = nameOfStatus;
    }

    public OrderStatus(int id, String nameOfStatus) {
        this.id = id;
        this.nameOfStatus = nameOfStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfStatus() {
        return nameOfStatus;
    }

    public void setNameOfStatus(String nameOfStatus) {
        this.nameOfStatus = nameOfStatus;
    }
}
