package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.BookTicketRequestDTO;
import com.example.bookmyshow.dtos.BookTicketResponseDTO;
import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.Ticket;
import com.example.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        int showId = request.getShowId();
        List<Integer> showSeatIds = request.getShowSeatIds();
        try{
            Ticket ticket = ticketService.bookTicket(showId,showSeatIds);
            BookTicketResponseDTO response = new BookTicketResponseDTO();
            response.setStatus("SUCCESS");
            response.setTicket(ticket);
            return response;
        }catch(ShowSeatNotAvailableException exception){
            BookTicketResponseDTO response = new BookTicketResponseDTO();
            response.setStatus("FAILURE");
            return response;
        }
    }
}
