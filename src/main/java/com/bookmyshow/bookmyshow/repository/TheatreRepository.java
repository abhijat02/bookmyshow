package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    
}
