package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.*;
import com.bookmyshow.bookmyshow.repository.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShowtimeRepository showtimeRepository;

    public BookingController(BookingRepository bookingRepository, UserRepository userRepository, ShowtimeRepository showtimeRepository){
        this.bookingRepository = bookingRepository;
        this.showtimeRepository = showtimeRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestParam Long userId, @RequestParam Long showtimeId, @RequestParam int seats){
        User user = userRepository.findById(userId).orElseThrow();
        Showtime showtime = showtimeRepository.findById(showtimeId).orElseThrow();

        if(showtime.getAvailableSeats() < seats){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough seats available! Only " + showtime.getAvailableSeats() + " left.");
        }

        showtime.setAvailableSeats(showtime.getAvailableSeats() - seats);
        showtimeRepository.save(showtime);

        double totalPrice = seats*showtime.getPricePerSeat();

        Booking booking = new Booking(seats, LocalDateTime.now(), totalPrice, user, showtime);
        bookingRepository.save(booking);

        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId){
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        Showtime showtime = booking.getShowtime();

        showtime.setAvailableSeats(showtime.getAvailableSeats() + booking.getNumberOfSeats());
        showtimeRepository.save(showtime);

        bookingRepository.delete(booking);

        return ResponseEntity.ok("Booking cancelled successfully. Seats restored!");
    }

    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId){
        return bookingRepository.findByUserId(userId);
    }

}
