package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    // 1 seat can have only 1 seatType but 1 seatType can be applied to many seats
    //1 : 1                                     m:1
    @ManyToOne
    private SeatType seatType;
    private String name;
    private int row;
    private int col;
}
