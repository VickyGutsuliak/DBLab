package com.example.demo.repository;

import com.example.demo.model.BuyersHasMedicines;
import com.example.demo.model.MedicineHasIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MedicineHasIngredientsRepository extends JpaRepository<MedicineHasIngredients, Integer> {
    @Query("select m " +
            "from MedicineHasIngredients m " +
            "join BuyersHasMedicines b ON m.medicine.id = b.medicine.id " +
            "where b.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate " +
            "group by m.ingredients")
    List<MedicineHasIngredients> getIngredientsBetweenSelectedDates(
            @Param("firstDate")Date firstDate, @Param("secondDate")Date secondDate
    );
    @Query("select sum(m.amountOfIngredients*b.amountOfMedicine) " +
            "from MedicineHasIngredients m " +
            "join BuyersHasMedicines b ON m.medicine.id = b.medicine.id " +
            "where b.datesOfOrderingAndReceiving.dateOfOrdering " +
            "between :firstDate and :secondDate " +
            "group by m.ingredients")
    List<Long> getVolumeOfIngredientsBetweenSelectedDates(
            @Param("firstDate")Date firstDate, @Param("secondDate")Date secondDate
    );

    @Query("select count(m.ingredients.id) " +
            "from MedicineHasIngredients m " +
            "join BuyersHasMedicines b ON m.medicine.id = b.medicine.id " +
            "where b.datesOfOrderingAndReceiving.orderStatus.nameOfStatus = :nameOfStatus ")
    Integer getAmountOfIngredientsOfMedicinesThatAreMaking(
            @Param("nameOfStatus") String nameOfStatus);

    @Query("select distinct m " +
            "from MedicineHasIngredients m " +
            "join BuyersHasMedicines b ON m.medicine.id = b.medicine.id " +
            "where b.datesOfOrderingAndReceiving.orderStatus.nameOfStatus = :nameOfStatus ")
    List<MedicineHasIngredients> getListOfIngredientsOfMedicinesThatAreMaking(
            @Param("nameOfStatus") String nameOfStatus);

    @Query("select m " +
            "from MedicineHasIngredients m " +
            "where m.medicine.id = :id ")
    List<MedicineHasIngredients> getListOfVolumeOfIngredientsOfMedicinesThatMakeInDrugstore(
            @Param("id") Integer id);
    @Query("select ((m.amountOfIngredients/100)*m.ingredients.price) " +
            "from MedicineHasIngredients m " +
            "where m.medicine.id = :id ")
    List<Double> getListOfPriceOfIngredientsOfMedicinesThatMakeInDrugstore(
            @Param("id") Integer id);
}
