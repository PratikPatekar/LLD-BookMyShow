package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment>payments;
    private double amount;
    //1 ticket multiple show seats
    //1 show seat multiple tickets because of cancellation and rebooking etc
    @ManyToMany
    private List<ShowSeat>showSeats;
    private Date bookingTime;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
