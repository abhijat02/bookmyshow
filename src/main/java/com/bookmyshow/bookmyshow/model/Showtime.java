package com.bookmyshow.bookmyshow.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

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
