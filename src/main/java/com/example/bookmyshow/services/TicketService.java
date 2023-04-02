package com.example.bookmyshow.services;

import com.example.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TicketPriceCalculator ticketPriceCalculator;
    private TicketRepository ticketRepository;
    @Autowired
    public TicketService(ShowRepository showRepository,ShowSeatRepository showSeatRepository,TicketPriceCalculator ticketPriceCalculator,TicketRepository ticketRepository){
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketPriceCalculator = ticketPriceCalculator;
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(int showId, List<Integer> showSeatIds) throws ShowSeatNotAvailableException {
        // 1. Get Sow with showId

        Show show = showRepository.findByIdEquals(showId);

        // 2. get ShowSeat with those ID's

        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        // 3. check if all seats are available

        for(ShowSeat showSeat: showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Show Seat "+showSeat.getId()+" is not available for booking");
            }
        }

        // 4.1 If available:
        //      set status to LOCKED
        //      create a ticket and save to DB
        // 4.2 If not available:
        //      throw an exception

        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        Ticket ticket = new Ticket();
        ticket.setTicketStatus(TicketStatus.IN_PROCESS);
        ticket.setBookingTime(new Date());
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setAmount(ticketPriceCalculator.calculateTicketPrice(showSeats));

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
}
