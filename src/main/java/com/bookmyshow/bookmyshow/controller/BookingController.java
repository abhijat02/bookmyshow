package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.*;
import com.bookmyshow.bookmyshow.repository.*;
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
    public Booking createBooking(@RequestParam Long userId, @RequestParam Long showtimeId, @RequestParam int seats){
        User user = userRepository.findById(userId).orElseThrow();
        Showtime showtime = showtimeRepository.findById(showtimeId).orElseThrow();

        Booking booking = new Booking(seats, LocalDateTime.now(), user, showtime);
        return bookingRepository.save(booking);
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
