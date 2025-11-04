package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.Movie;
import com.bookmyshow.bookmyshow.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @GetMapping("/language/{language}")
    public List<Movie> getMoviesByLanguage(@PathVariable String language) {
        return movieRepository.findByLanguage(language);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre){
        return movieRepository.findByGenre(genre);
    }

    @GetMapping("/search/{keyword}")
    public List<Movie> searchMovies(@PathVariable String keyword){
        return movieRepository.findByTitleContainingIgnoreCase(keyword);
    }
    
}
