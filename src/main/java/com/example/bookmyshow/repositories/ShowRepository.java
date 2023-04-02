package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Created using Spring
@Repository
public interface ShowRepository extends JpaRepository<Show,Integer>{
    Show findByIdEquals(int id);
}
