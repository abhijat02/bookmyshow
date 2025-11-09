package com.bookmyshow.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Movie {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank(message = "Movie title cannot be blank")
   private String title;

   @NotBlank(message = "Genre cannot be blank")
   private String genre;

   @NotBlank(message = "Language cannot be blank")
   private String language;

   @NotNull(message = "Duration is required")
   @Min(value = 30, message = "Duration must be at least 30 minutes")
   private Integer duration;
   
   public Movie() {}

   public Movie(String title, String genre, int duration){
    this.title = title;
    this.genre = genre;
    this.duration = duration;
   }

   public Long getId(){
    return id;
   }

   public String getTitle(){
    return title;
   }

   public void setTitle(String title){
    this.title = title;
   }

   public String getGenre(){
    return genre;
   }

   public void setGenre(String genre){
    this.genre = genre;
   }

   public String getLanguage(){
      return language;
   }

   public void setLanguage(String language){
      this.language = language;
   }

   public int getDuration(){
    return duration;
   }

   public void setDuration(int duration){
    this.duration = duration;
   }
}
