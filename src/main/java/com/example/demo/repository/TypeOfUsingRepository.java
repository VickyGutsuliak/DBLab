package com.example.demo.repository;

import com.example.demo.model.Buyer;
import com.example.demo.model.TypeOfUsing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfUsingRepository extends JpaRepository<TypeOfUsing, Integer> {
}
