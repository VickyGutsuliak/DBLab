package com.example.demo.model.Requests;

import com.example.demo.model.BuyersHasMedicines;

public class BuyerHasMedicinesAndAmount {
    BuyersHasMedicines buyersHasMedicines;
    long amount;

    public BuyerHasMedicinesAndAmount(BuyersHasMedicines buyersHasMedicines, long amount) {
        this.buyersHasMedicines = buyersHasMedicines;
        this.amount = amount;
    }

    public BuyersHasMedicines getBuyersHasMedicines() {
        return buyersHasMedicines;
    }

    public void setBuyersHasMedicines(BuyersHasMedicines buyersHasMedicines) {
        this.buyersHasMedicines = buyersHasMedicines;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
