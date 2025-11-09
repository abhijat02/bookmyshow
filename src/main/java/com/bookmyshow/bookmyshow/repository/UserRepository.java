package com.bookmyshow.bookmyshow.repository;

import com.bookmyshow.bookmyshow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
