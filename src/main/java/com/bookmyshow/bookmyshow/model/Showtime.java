package com.bookmyshow.bookmyshow.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime showTime;
    private int totalSeats = 100;
    private int availableSeats = 100;
    private double pricePerSeat = 250.0;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Booking> bookings; 

    public Showtime() {}

    public Showtime(LocalDateTime showTime, Movie movie, Theatre theatre){
        this.showTime = showTime;
        this.movie = movie;
        this.theatre = theatre;
    }

    public Long getId(){
        return id;
    }

    public LocalDateTime getShowTime(){
        return showTime;
    }

    public void setShowtime(LocalDateTime showTime){
        this.showTime = showTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPricePerSeat(){ 
        return pricePerSeat; 
    }

    public void setPricePerSeat(double pricePerSeat){ 
        this.pricePerSeat = pricePerSeat; 
    }


    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public Theatre getTheatre(){
        return theatre;
    }

    public void setTheatre(Theatre theatre){
        this.theatre = theatre;
    }
}
