package com.example.demo.repository;

import com.example.demo.model.Buyer;
import com.example.demo.model.Medicine;
import com.example.demo.model.MedicineHasIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    @Query("select m " +
            "from Medicine m " +
            "join MedicineHasIngredients mhi ON m.id = mhi.medicine.id " +
            "where m.id = :id")
    List<Medicine> getInformationAboutMadeMedicine(@Param("id")Integer id);
    @Query("select mhi " +
            "from Medicine m " +
            "join MedicineHasIngredients mhi ON m.id = mhi.medicine.id " +
            "where m.id = :id")
    List<MedicineHasIngredients> getInformationAboutMadeMedicineHasIngredients(@Param("id")Integer id);

    @Query("select m " +
            "from Medicine m " +
            "where m.id = :id")
    List<Medicine> getInformationAboutOfficinalMedicine(
            @Param("id")Integer id);

    @Query("select m " +
            "from Medicine m " +
            "where m.typeOfMedicine.id = :id " +
            "and m.amount <= m.criticalRate")
    List<Medicine> getListOfMedicineOfSelectedTypeWithMinimalStocks(
            @Param("id")Integer id);

    @Query("select m " +
            "from Medicine m " +
            "where m.amount <= m.criticalRate " +
            "and not (m.nameOfMedicine like :nameOfMedicine)")
    List<Medicine> getListOfMedicineThatHaveReachedCriticalRate(
            @Param("nameOfMedicine")String nameOfMedicine);

    @Query("select m " +
            "from Medicine m " +
            "where not (m.nameOfMedicine like :nameOfMedicine)")
    List<Medicine> getListOfMedicineThatExpired(
            @Param("nameOfMedicine")String nameOfMedicine);

    @Query("select m " +
            "from Medicine m " +
            "where not (m.nameOfMedicine like :nameOfMedicine)")
    List<Medicine> getListOfTypesOfMedicineThatExpired(
            @Param("nameOfMedicine")String nameOfMedicine);

    @Query("select m " +
            "from Medicine m " +
            "where m.amount <= m.criticalRate " +
            "and not (m.nameOfMedicine like :nameOfMedicine) " +
            "group by m.typeOfMedicine.id")
    List<Medicine> getListOfTypesOfMedicineThatHaveReachedCriticalRate(
            @Param("nameOfMedicine")String nameOfMedicine);


    @Query("select m " +
            "from Medicine m " +
            "where (m.nameOfMedicine like :nameOfMedicine)")
    List<Medicine> getListOfMadeMedicine(
            @Param("nameOfMedicine")String nameOfMedicine);
    @Query("select m " +
            "from Medicine m " +
            "where not (m.nameOfMedicine like :nameOfMedicine)")
    List<Medicine> getListOfOfficinalMedicine(
            @Param("nameOfMedicine")String nameOfMedicine);
}
