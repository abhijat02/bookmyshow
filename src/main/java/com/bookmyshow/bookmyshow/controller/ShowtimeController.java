package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.*;
import com.bookmyshow.bookmyshow.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
    private final ShowtimeRepository showtimeRepository;
    private final TheatreRepository theatreRepository;
    private final MovieRepository movieRepository;

    public ShowtimeController(ShowtimeRepository showtimeRepository, MovieRepository movieRepository, TheatreRepository theatreRepository){
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    @GetMapping
    public List<Showtime> getAllShowtimes(){
        return showtimeRepository.findAll();
    }

    @PostMapping
    public Showtime addShowtime(@RequestParam Long movieId, @RequestParam Long theatreId, @RequestParam String showTime){
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow();

        Showtime showtime = new Showtime(
            java.time.LocalDateTime.parse(showTime),
            movie,
            theatre
        );

        return showtimeRepository.save(showtime);
    }
}
