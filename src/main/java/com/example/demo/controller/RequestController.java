package com.example.demo.controller;

import com.example.demo.model.Requests.Amount;
import com.example.demo.model.BuyersHasMedicines;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineHasIngredients;
import com.example.demo.model.Requests.BuyerHasMedicinesAndAmount;
import com.example.demo.model.Requests.IngredientsAndVolume;
import com.example.demo.model.Requests.MadeMedicineAndPrice;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    BuyerHasMedicinesRepository buyerHasMedicinesRepository;
    @Autowired
    MedicineHasIngredientsRepository medicineHasIngredientsRepository;
    @Autowired
    MedicineRepository medicineRepository;

    @RequestMapping("/request1_1")
    List<BuyersHasMedicines> getBuyerThatDidntComeForMedicine(){
        return buyerHasMedicinesRepository.getBuyerThatDidntComeForMedicine();
    }

    @RequestMapping("/request1_2")
    Amount getAmountOfBuyerThatDidntComeForMedicine(){
        return new Amount(buyerHasMedicinesRepository.getAmountOfBuyerThatDidntComeForMedicine());
    }

    /*******************************************************************************/
    @RequestMapping("/request2_list_all")
    List<BuyersHasMedicines> getAllBuyersThatWaitingForMedicines(){
        return buyerHasMedicinesRepository.getAllBuyersThatWaitingForMedicines();
    }

    @RequestMapping("/request2_amount_all")
    Amount getAmountOfAllBuyersThatWaitingForMedicines(){
        return new Amount(buyerHasMedicinesRepository.getAmountOfAllBuyersThatWaitingForMedicines());
    }

    @RequestMapping("/request2_list_selected_type")
    List<BuyersHasMedicines> getBuyersThatWaitingForMedicinesOfSelectedType(@RequestParam Integer id){
        return buyerHasMedicinesRepository.
                getBuyersThatWaitingForMedicinesOfSelectedType(id);
    }

    @RequestMapping("/request2_amount_selected_type")
    Amount getAmountOfBuyersThatWaitingForMedicinesOfSelectedType(@RequestParam Integer id){
        return new Amount(buyerHasMedicinesRepository.
                getAmountOfBuyersThatWaitingForMedicinesOfSelectedType(id));
    }

    /*******************************************************************************/
    @RequestMapping("/request3_all")
    List<BuyerHasMedicinesAndAmount> getAllTheMostPopularMedicines(){
        List<BuyersHasMedicines> allMostPopularMedicines =
                buyerHasMedicinesRepository.getAllTheMostPopularMedicinesList();

        List<Long> allMostPopularMedicinesAmount =
                buyerHasMedicinesRepository.getAllTheMostPopularMedicinesAmount();

        List<BuyerHasMedicinesAndAmount> buyerHasMedicinesAndAmount = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            buyerHasMedicinesAndAmount.add(
                    new BuyerHasMedicinesAndAmount(allMostPopularMedicines.get(i),
                            allMostPopularMedicinesAmount.get(i)));
        }
            
        return buyerHasMedicinesAndAmount;
    }

    @RequestMapping("/request3_type")
    List<BuyerHasMedicinesAndAmount> getTheMostPopularMedicinesOfSelectedType(@RequestParam("id") Integer id){
        List<BuyersHasMedicines> allMostPopularMedicines =
                buyerHasMedicinesRepository.getTheMostPopularMedicinesOfSelectedType(id);

        List<Long> allMostPopularMedicinesAmount =
                buyerHasMedicinesRepository.getTheMostPopularMedicinesOfSelectedTypeAmount(id);

        List<BuyerHasMedicinesAndAmount> buyerHasMedicinesAndAmount = new ArrayList<>();
        for (int i = 0; i < allMostPopularMedicines.size(); i++){
            buyerHasMedicinesAndAmount.add(
                    new BuyerHasMedicinesAndAmount(allMostPopularMedicines.get(i),
                            allMostPopularMedicinesAmount.get(i)));
        }

        return buyerHasMedicinesAndAmount;
    }

    /*******************************************************************************/
    @RequestMapping("/request4")
    List<IngredientsAndVolume> getVolumeOfIngredientsBetweenSelectedDates(
            @RequestParam Date firstDate, Date secondDate){
        List<MedicineHasIngredients> ingredients =
                medicineHasIngredientsRepository.getIngredientsBetweenSelectedDates(
                        firstDate, secondDate) ;

        List<Long> volumes =
                medicineHasIngredientsRepository.getVolumeOfIngredientsBetweenSelectedDates(
                        firstDate, secondDate) ;

        List<IngredientsAndVolume> ingredientsAndVolumes = new ArrayList<>();
        for(int i = 0; i < ingredients.size(); i++){
            ingredientsAndVolumes.add(
                    new IngredientsAndVolume(
                            ingredients.get(i), volumes.get(i))
            );
        }


        return ingredientsAndVolumes;
    }

    /*******************************************************************************/
    @RequestMapping("/request5_all_buyers_amount")
    Integer getAmountOfBuyersThatOrderSelectedMedicineBetweenSelectedDates
            (@RequestParam Integer id,Date firstDate,Date secondDate){
        return buyerHasMedicinesRepository
                .getAmountOfBuyersThatOrderSelectedMedicineBetweenSelectedDates(
                        id, firstDate, secondDate);
    }

    @RequestMapping("/request5_all_buyers_list")
    List<BuyersHasMedicines> getListOfBuyersThatOrderSelectedMedicineBetweenSelectedDates
            (@RequestParam Integer id, Date firstDate, Date secondDate){
        return buyerHasMedicinesRepository.getListOfBuyersThatOrderSelectedMedicineBetweenSelectedDates(
                id, firstDate, secondDate
        );
    }

    @RequestMapping("/request5_medicine_type_buyers_amount")
    Integer getAmountOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates
            (@RequestParam Integer id, Date firstDate, Date secondDate){
        return buyerHasMedicinesRepository.getAmountOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates(
                id, firstDate, secondDate
        );
    }

    @RequestMapping("/request5_medicine_type_buyers_list")
    List<BuyersHasMedicines> getListOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates
            (@RequestParam Integer id, Date firstDate, Date secondDate){
        return buyerHasMedicinesRepository.getListOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates(
                id, firstDate, secondDate
        );
    }

    /*******************************************************************************/
    @RequestMapping("/request6_medicine_critical_rate")
    List<Medicine> getListOfMedicineThatHaveReachedCriticalRate(){
        return medicineRepository.getListOfMedicineThatHaveReachedCriticalRate("Рецепт%");
    }

    @RequestMapping("/request6_type_of_medicine_critical_rate")
    List<Medicine> getListOfTypesOfMedicineThatHaveReachedCriticalRate(){
        return medicineRepository.getListOfTypesOfMedicineThatHaveReachedCriticalRate("Рецепт%");
    }

    private Calendar today = Calendar.getInstance();

    @RequestMapping("/request6_medicine_expiration_term")
    List<Medicine> getListOfMedicineThatExpired(){
        today.set(Calendar.HOUR_OF_DAY, 0);
        java.util.Date todayDate = today.getTime();

        List<Medicine> resultList = medicineRepository.getListOfMedicineThatExpired("Рецепт%");

        for(int i = 0; i < resultList.size();i++){
            Medicine m = resultList.get(i);
            Integer daysBetweenDates = (
                    todayDate.getYear()*365+todayDate.getMonth()*30+todayDate.getDay()
                            -m.getManufactureDate().getYear()*365-m.getManufactureDate().getMonth()*30
                            -m.getManufactureDate().getDay());
            Integer expirationTerm = (m.getExpirationTerm()*30);
            if((daysBetweenDates < expirationTerm)){
                resultList.remove(m);
                i--;
            }
        }

        return resultList;
    }

    @RequestMapping("/request6_type_of_medicine_expiration_term")
    List<Medicine> getListOfTypesOfMedicineThatExpired(){
        today.set(Calendar.HOUR_OF_DAY, 0);
        java.util.Date todayDate = today.getTime();

        List<Medicine> resultList = medicineRepository.getListOfTypesOfMedicineThatExpired("Рецепт%");

        for(int i = 0; i < resultList.size();i++){
            Medicine m = resultList.get(i);
            Integer daysBetweenDates = (
                    todayDate.getYear()*365+todayDate.getMonth()*30+todayDate.getDay()
                            -m.getManufactureDate().getYear()*365-m.getManufactureDate().getMonth()*30
                            -m.getManufactureDate().getDay());
            Integer expirationTerm = (m.getExpirationTerm()*30);
            if((daysBetweenDates < expirationTerm)){
                resultList.remove(m);
                i--;
            }
        }

        return resultList;
    }

    /*******************************************************************************/
    @RequestMapping("/request7")
    List<Medicine> getListOfMedicineOfSelectedTypeWithMinimalStocks
            (@RequestParam Integer id){
        return medicineRepository.getListOfMedicineOfSelectedTypeWithMinimalStocks(
                id);
    }

    /*******************************************************************************/
    @RequestMapping("/request8_amount")
    Amount getAmountOfOrdersThatAreMakingNow(){
        return new Amount(buyerHasMedicinesRepository.getAmountOfOrdersThatAreMakingNow());
    }

    @RequestMapping("/request8_list")
    List<BuyersHasMedicines> getListOfOrdersThatAreMakingNow(){
        return buyerHasMedicinesRepository.getListOfOrdersThatAreMakingNow();
    }

    /*******************************************************************************/
    @RequestMapping("/request9_list")
    List<MedicineHasIngredients> getListOfIngredientsOfMedicinesThatAreMaking(){
        return medicineHasIngredientsRepository.getListOfIngredientsOfMedicinesThatAreMaking(
                "Виготовляється"
        );
    }

    @RequestMapping("/request9_amount")
    Amount getAmountOfIngredientsOfMedicinesThatAreMaking(){
        return new Amount(
                medicineHasIngredientsRepository.getAmountOfIngredientsOfMedicinesThatAreMaking(
                "Виготовляється"
        ));
    }

    /*******************************************************************************/
    @RequestMapping("/request10_made_medicines")
    List<MadeMedicineAndPrice> getListOfVolumeAndPriceOfIngredientsOfMedicinesThatMakeInDrugstore(
            @RequestParam Integer id){
        List<MedicineHasIngredients> medicineHasIngredients =
                medicineHasIngredientsRepository.getListOfVolumeOfIngredientsOfMedicinesThatMakeInDrugstore(id) ;

        List<Double> prices =
                medicineHasIngredientsRepository.getListOfPriceOfIngredientsOfMedicinesThatMakeInDrugstore(id) ;

        List<MadeMedicineAndPrice> madeMedicineAndPrices = new ArrayList<>();
        for(int i = 0; i < medicineHasIngredients.size(); i++){
            madeMedicineAndPrices.add(
                    new MadeMedicineAndPrice(
                            medicineHasIngredients.get(i), prices.get(i))
            );
        }


        return madeMedicineAndPrices;
    }

    @RequestMapping("/request10_officinal")
    List<Medicine> getInformationAboutOfficinalMedicine(
            @RequestParam Integer id){
        return medicineRepository.getInformationAboutOfficinalMedicine(id);
    }
    @RequestMapping("/for_request10_officinal")
    List<Medicine> getListOfOfficinalMedicine(){
        return medicineRepository.getListOfOfficinalMedicine("Рецепт%");
    }


    /*******************************************************************************/
    @RequestMapping("/request11_all")
    List<BuyerHasMedicinesAndAmount> getListOfBuyersThatBuyMostOften(){
        List<BuyersHasMedicines> buyersHasMedicines =
                buyerHasMedicinesRepository.getListOfBuyersThatBuyMostOften() ;

        List<Long> buyersHasMedicinesAmount =
                buyerHasMedicinesRepository.getAmountOfBuyersThatBuyMostOften() ;
        Long maxAmount = Long.valueOf(0);
        for (Long l : buyersHasMedicinesAmount){
            if(l > maxAmount){
                maxAmount = l;
            }
        }

        List<BuyerHasMedicinesAndAmount> buyerHasMedicinesAndAmount = new ArrayList<>();
        for(int i = 0; i < buyersHasMedicinesAmount.size(); i++){
            if(buyersHasMedicinesAmount.get(i).longValue() == maxAmount.longValue()){
                buyerHasMedicinesAndAmount.add(
                        new BuyerHasMedicinesAndAmount(
                                buyersHasMedicines.get(i), buyersHasMedicinesAmount.get(i))
                );
            }
        }


        return buyerHasMedicinesAndAmount;
    }

    @RequestMapping("/request11_medicine")
    List<BuyerHasMedicinesAndAmount> getListOfBuyersThatBuySelectedMedicineMostOften(
            @RequestParam Integer id){
        List<BuyersHasMedicines> buyersHasMedicines =
                buyerHasMedicinesRepository.getListOfBuyersThatBuySelectedMedicineMostOften(id) ;

        List<Long> buyersHasMedicinesAmount =
                buyerHasMedicinesRepository.getAmountOfBuyersThatBuySelectedMedicineMostOften(id) ;
        Long maxAmount = Long.valueOf(0);
        for (Long l : buyersHasMedicinesAmount){
            if(l > maxAmount){
                maxAmount = l;
            }
        }

        List<BuyerHasMedicinesAndAmount> buyerHasMedicinesAndAmount = new ArrayList<>();
        for(int i = 0; i < buyersHasMedicinesAmount.size(); i++){
            if(buyersHasMedicinesAmount.get(i).longValue() == maxAmount.longValue()){
                buyerHasMedicinesAndAmount.add(
                        new BuyerHasMedicinesAndAmount(
                                buyersHasMedicines.get(i), buyersHasMedicinesAmount.get(i))
                );
            }
        }


        return buyerHasMedicinesAndAmount;
    }

    @RequestMapping("/request11_type")
    List<BuyerHasMedicinesAndAmount> getListOfBuyersThatBuySelectedTypeOfMedicineMostOften(
            @RequestParam Integer id){
        List<BuyersHasMedicines> buyersHasMedicines =
                buyerHasMedicinesRepository.getListOfBuyersThatBuySelectedTypeOfMedicineMostOften(id) ;

        List<Long> buyersHasMedicinesAmount =
                buyerHasMedicinesRepository.getAmountOfBuyersThatBuySelectedTypeOfMedicineMostOften(id) ;
        Long maxAmount = Long.valueOf(0);
        for (Long l : buyersHasMedicinesAmount){
            if(l > maxAmount){
                maxAmount = l;
            }
        }

        List<BuyerHasMedicinesAndAmount> buyerHasMedicinesAndAmount = new ArrayList<>();
        for(int i = 0; i < buyersHasMedicinesAmount.size(); i++){
            if(buyersHasMedicinesAmount.get(i).longValue() == maxAmount.longValue()){
                buyerHasMedicinesAndAmount.add(
                        new BuyerHasMedicinesAndAmount(
                                buyersHasMedicines.get(i), buyersHasMedicinesAmount.get(i))
                );
            }
        }


        return buyerHasMedicinesAndAmount;
    }

    /*****************************************************************************/
    @RequestMapping("/request12")
    List<MedicineHasIngredients> getInformationAboutMadeMedicine(
            @RequestParam Integer id){
        return medicineRepository.getInformationAboutMadeMedicineHasIngredients(id);
    }
    @RequestMapping("/request12_medicine")
    List<Medicine> getInformationAboutMadeMedicine_Med(
            @RequestParam Integer id){
        List<Medicine> medicineList = medicineRepository.getInformationAboutMadeMedicine(id);
        for (int i = 1; i < medicineList.size(); i++){
            medicineList.remove(i);
            i--;
        }
        return medicineList;
    }
    @RequestMapping("/for_request12")
    List<Medicine> getListOfMadeMedicine(){
        return medicineRepository.getListOfMadeMedicine("Рецепт%");
    }
}