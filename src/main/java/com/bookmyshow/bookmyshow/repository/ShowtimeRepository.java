package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}

