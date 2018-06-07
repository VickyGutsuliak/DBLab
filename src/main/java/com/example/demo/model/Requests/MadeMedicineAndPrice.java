package com.example.demo.model.Requests;

import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineHasIngredients;

public class MadeMedicineAndPrice {
    MedicineHasIngredients medicineHasIngredients;
    Double price;

    public MadeMedicineAndPrice(MedicineHasIngredients medicine, double price) {
        this.medicineHasIngredients = medicine;
        this.price = price;
    }

    public MedicineHasIngredients getMedicine() {
        return medicineHasIngredients;
    }

    public void setMedicine(MedicineHasIngredients medicine) {
        this.medicineHasIngredients = medicine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
