package com.bookmyshow.bookmyshow.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfSeats;
    private LocalDateTime bookingTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    public Booking() {};

    public Booking(int numberOfSeats, LocalDateTime bookingTime, User user, Showtime showtime){
        this.numberOfSeats = numberOfSeats;
        this.bookingTime = bookingTime;
        this.user = user;
        this.showtime = showtime;
    }

    public Long getId() { return id; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Showtime getShowtime() { return showtime; }
    public void setShowtime(Showtime showtime) { this.showtime = showtime; }

}
