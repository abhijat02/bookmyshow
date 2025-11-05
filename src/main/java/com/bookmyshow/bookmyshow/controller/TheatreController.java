package com.bookmyshow.bookmyshow.controller;

import com.bookmyshow.bookmyshow.model.Theatre;
import com.bookmyshow.bookmyshow.repository.TheatreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    
    private final TheatreRepository theatreRepository;

    public TheatreController(TheatreRepository theatreRepository){
        this.theatreRepository = theatreRepository;
    }

    @GetMapping
    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    @PostMapping
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return theatreRepository.save(theatre);
    }
}
