package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private String status;
    private Ticket ticket;
}
