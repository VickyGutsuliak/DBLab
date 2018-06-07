package com.example.demo.repository;

import com.example.demo.model.BuyersHasMedicines;
import com.example.demo.model.Requests.BuyerHasMedicinesAndAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BuyerHasMedicinesRepository extends JpaRepository<BuyersHasMedicines, Integer> {
    @Query("select buyerHasMedicines from BuyersHasMedicines buyerHasMedicines where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 3")
    List<BuyersHasMedicines> getBuyerThatDidntComeForMedicine();

    @Query("select count (buyerHasMedicines) from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 3")
    Long getAmountOfBuyerThatDidntComeForMedicine();

    @Query("select buyerHasMedicines from BuyersHasMedicines buyerHasMedicines" +
            " where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 2")
    List<BuyersHasMedicines> getAllBuyersThatWaitingForMedicines();

    @Query("select count (buyerHasMedicines) from BuyersHasMedicines buyerHasMedicines" +
            " where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 2")
    Integer getAmountOfAllBuyersThatWaitingForMedicines();

    @Query("select buyerHasMedicines from BuyersHasMedicines buyerHasMedicines" +
            " where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 2 and " +
            "buyerHasMedicines.medicine.typeOfMedicine.id = :id")
    List<BuyersHasMedicines> getBuyersThatWaitingForMedicinesOfSelectedType(
            @Param("id")Integer id);

    @Query("select count (buyerHasMedicines) from BuyersHasMedicines buyerHasMedicines" +
            " where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 2 and " +
            "buyerHasMedicines.medicine.typeOfMedicine.id = :id")
    Integer getAmountOfBuyersThatWaitingForMedicinesOfSelectedType(
            @Param("id")Integer id);

    @Query("select buyerHasMedicines from BuyersHasMedicines buyerHasMedicines " +
            "group by buyerHasMedicines.medicine.id order by count (buyerHasMedicines.buyer.id) desc")
    List<BuyersHasMedicines> getAllTheMostPopularMedicinesList();
    @Query("select count(buyerHasMedicines.buyer.id) from BuyersHasMedicines buyerHasMedicines " +
            "group by buyerHasMedicines.medicine.id order by count (buyerHasMedicines.buyer.id) desc")
    List<Long> getAllTheMostPopularMedicinesAmount();

    @Query("select buyerHasMedicines from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.typeOfMedicine.id = :id " +
            "group by buyerHasMedicines.medicine.id order by count (buyerHasMedicines.buyer.id) desc")
    List<BuyersHasMedicines> getTheMostPopularMedicinesOfSelectedType(
            @Param("id")Integer id
    );
    @Query("select count(buyerHasMedicines.buyer.id) from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.typeOfMedicine.id = :id " +
            "group by buyerHasMedicines.medicine.id order by count (buyerHasMedicines.buyer.id) desc")
    List<Long> getTheMostPopularMedicinesOfSelectedTypeAmount(
            @Param("id")Integer id
    );

    @Query("select count (buyerHasMedicines.buyer.id), buyerHasMedicines.medicine.nameOfMedicine " +
            "from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.id = :id and " +
            "buyerHasMedicines.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate")
    Integer getAmountOfBuyersThatOrderSelectedMedicineBetweenSelectedDates(
        @Param("id")Integer id, @Param("firstDate")Date firstDate,
        @Param("secondDate")Date secondDate
    );

    @Query("select buyerHasMedicines.buyer.PIB, buyerHasMedicines.medicine.nameOfMedicine " +
            "from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.id = :id and " +
            "buyerHasMedicines.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate")
    List<BuyersHasMedicines> getListOfBuyersThatOrderSelectedMedicineBetweenSelectedDates(
            @Param("id")Integer id, @Param("firstDate")Date firstDate,
            @Param("secondDate")Date secondDate
    );

    @Query("select count (buyerHasMedicines.buyer.id) " +
            "from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.typeOfMedicine.id = :id and " +
            "buyerHasMedicines.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate")
    Integer getAmountOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates(
            @Param("id")Integer id, @Param("firstDate")Date firstDate,
            @Param("secondDate")Date secondDate
    );

    @Query("select buyerHasMedicines " +
            "from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.medicine.typeOfMedicine.id = :id and " +
            "buyerHasMedicines.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate")
    List<BuyersHasMedicines> getListOfBuyersThatOrderSelectedTypeOfMedicineBetweenSelectedDates(
            @Param("id")Integer id, @Param("firstDate")Date firstDate,
            @Param("secondDate")Date secondDate
    );

    @Query("select buyerHasMedicines" +
            " from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 4")
    List<BuyersHasMedicines> getListOfOrdersThatAreMakingNow();

    @Query("select count (buyerHasMedicines.medicine.nameOfMedicine)" +
            " from BuyersHasMedicines buyerHasMedicines " +
            "where buyerHasMedicines.datesOfOrderingAndReceiving.orderStatus.id = 4")
    Integer getAmountOfOrdersThatAreMakingNow();

    @Query("select buyerHasMedicines2 " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "group by buyerHasMedicines2.buyer.id order by count(buyerHasMedicines2.medicine.id) desc")
    List<BuyersHasMedicines> getListOfBuyersThatBuyMostOften();
    @Query("select count(buyerHasMedicines2.medicine.id) " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "group by buyerHasMedicines2.buyer.id order by count(buyerHasMedicines2.medicine.id) desc")
    List<Long> getAmountOfBuyersThatBuyMostOften();

    @Query("select buyerHasMedicines2 " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "where buyerHasMedicines2.medicine.id = :id " +
            "group by buyerHasMedicines2.buyer.id " +
            "order by count(buyerHasMedicines2.medicine.id) desc")
    List<BuyersHasMedicines> getListOfBuyersThatBuySelectedMedicineMostOften(
            @Param("id")Integer id);
    @Query("select count(buyerHasMedicines2.medicine.id) " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "where buyerHasMedicines2.medicine.id = :id " +
            "group by buyerHasMedicines2.buyer.id " +
            "order by count(buyerHasMedicines2.medicine.id) desc")
    List<Long> getAmountOfBuyersThatBuySelectedMedicineMostOften(
            @Param("id")Integer id);

    @Query("select buyerHasMedicines2 " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "where buyerHasMedicines2.medicine.typeOfMedicine.id = :id " +
            "group by buyerHasMedicines2.buyer.id " +
            "order by count(buyerHasMedicines2.medicine.id) desc")
    List<BuyersHasMedicines> getListOfBuyersThatBuySelectedTypeOfMedicineMostOften(
            @Param("id")Integer id);
    @Query("select count(buyerHasMedicines2.medicine.id) " +
            "from BuyersHasMedicines buyerHasMedicines2 " +
            "where buyerHasMedicines2.medicine.typeOfMedicine.id = :id " +
            "group by buyerHasMedicines2.buyer.id " +
            "order by count(buyerHasMedicines2.medicine.id) desc")
    List<Long> getAmountOfBuyersThatBuySelectedTypeOfMedicineMostOften(
            @Param("id")Integer id);
}