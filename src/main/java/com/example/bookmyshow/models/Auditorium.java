package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    //1:m 1 audi many shows
    //1:1 1 show in 1 audi
    @OneToMany(mappedBy = "auditorium")
    private List<Show>shows;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature>features;
    //1:m 1 audi multiple seats
    //1:1 1 seat 1 audi
    @OneToMany
    private List<Seat>seats;

}
