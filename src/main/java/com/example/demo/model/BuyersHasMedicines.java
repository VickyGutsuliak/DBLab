package com.example.demo.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "buyer_has_medicine")
@EntityListeners(AuditingEntityListener.class)
public class BuyersHasMedicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Buyer buyer;
    @ManyToOne
    private Medicine medicine;
    @ManyToOne
    private DatesOfOrderingAndReceiving datesOfOrderingAndReceiving;
    private String doctorPIB;
    private String diagnosis;
    private Integer amountOfMedicine;

    public BuyersHasMedicines() {
    }

    public BuyersHasMedicines(Buyer buyer, Medicine medicine, DatesOfOrderingAndReceiving datesOfOrderingAndReceiving, String doctorPIB, String diagnosis, Integer amountOfMedicine) {
        this.buyer = buyer;
        this.medicine = medicine;
        this.datesOfOrderingAndReceiving = datesOfOrderingAndReceiving;
        this.doctorPIB = doctorPIB;
        this.diagnosis = diagnosis;
        this.amountOfMedicine = amountOfMedicine;
    }

    public BuyersHasMedicines(Integer id, Buyer buyer, Medicine medicine,
                              DatesOfOrderingAndReceiving datesOfOrderingAndReceiving,
                              String doctorPIB, String diagnosis, Integer amountOfMedicine) {
        this.id = id;
        this.buyer = buyer;
        this.medicine = medicine;
        this.datesOfOrderingAndReceiving = datesOfOrderingAndReceiving;
        this.doctorPIB = doctorPIB;
        this.diagnosis = diagnosis;
        this.amountOfMedicine = amountOfMedicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public DatesOfOrderingAndReceiving getDatesOfOrderingAndReceiving() {
        return datesOfOrderingAndReceiving;
    }

    public void setDatesOfOrderingAndReceiving(DatesOfOrderingAndReceiving datesOfOrderingAndReceiving) {
        this.datesOfOrderingAndReceiving = datesOfOrderingAndReceiving;
    }

    public String getDoctorPIB() {
        return doctorPIB;
    }

    public void setDoctorPIB(String doctorPIB) {
        this.doctorPIB = doctorPIB;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Integer getAmountOfMedicine() {
        return amountOfMedicine;
    }

    public void setAmountOfMedicine(Integer amountOfMedicine) {
        this.amountOfMedicine = amountOfMedicine;
    }
}
