package com.bookmyshow.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmyshow.bookmyshow.model.Movie;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<Movie> findByLanguage(String language);

    List<Movie> findByGenre(String genre);

    List<Movie> findByTitleContainingIgnoreCase(String keyword);
}
