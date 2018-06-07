package com.example.demo.model.Requests;

import com.example.demo.model.MedicineHasIngredients;

public class IngredientsAndVolume {
    MedicineHasIngredients medicineHasIngredients;
    Long volume;

    public IngredientsAndVolume(MedicineHasIngredients medicineHasIngredients, Long volume) {
        this.medicineHasIngredients = medicineHasIngredients;
        this.volume = volume;
    }

    public MedicineHasIngredients getMedicineHasIngredients() {
        return medicineHasIngredients;
    }

    public void setMedicineHasIngredients(MedicineHasIngredients medicineHasIngredients) {
        this.medicineHasIngredients = medicineHasIngredients;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
}
