package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dates_of_ordering_and_receiving")
@EntityListeners(AuditingEntityListener.class)
public class DatesOfOrderingAndReceiving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateOfOrdering;
    private Date dateOfReceiving;
    @ManyToOne
    private OrderStatus orderStatus;

    public DatesOfOrderingAndReceiving() {
    }

    public DatesOfOrderingAndReceiving(Date dateOfOrdering, Date dateOfReceiving, OrderStatus orderStatus) {
        this.dateOfOrdering = dateOfOrdering;
        this.dateOfReceiving = dateOfReceiving;
        this.orderStatus = orderStatus;
    }

    public DatesOfOrderingAndReceiving(Integer id, Date dateOfOrdering,
                                       Date dateOfReceiving, OrderStatus orderStatus) {
        this.id = id;
        this.dateOfOrdering = dateOfOrdering;
        this.dateOfReceiving = dateOfReceiving;
        this.orderStatus = orderStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfOrdering() {
        return dateOfOrdering;
    }

    public void setDateOfOrdering(Date dateOfOrdering) {
        this.dateOfOrdering = dateOfOrdering;
    }

    public Date getDateOfReceiving() {
        return dateOfReceiving;
    }

    public void setDateOfReceiving(Date dateOfReceiving) {
        this.dateOfReceiving = dateOfReceiving;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
