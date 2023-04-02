package com.example.bookmyshow;

import com.example.bookmyshow.controllers.TicketController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {
    private TicketController ticketController;
    public BookmyshowApplication(TicketController ticketController){
        this.ticketController = ticketController;
    }
    public static void main(String[] args) {
        SpringApplication.run(BookmyshowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO:
        //  0. Create a movie
        //  1. Create a city
        //  2. Create a theatre
        //  3. Add Auditorium to a theatre
        //  4. Create 3 seat types: VIP,GOLD,PLATINUM
        //  5. Create 50 seats in the above auditorium
        //  6. Create a Show
        //      showController.createShow(int movieId,Date startTime,Date endTime,Theatre theatreId)

        //  BookTicketResponseDto response = ticketController.bookticket()
    }
}
