package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllByIdIn(List<Integer>showSeatIds);

    // If the show seat passed in the parameter doesn't have an id:
    //      it creates a new row in db
    // else it updates show seat belonging to that id
    ShowSeat save(ShowSeat showSeat);
}
