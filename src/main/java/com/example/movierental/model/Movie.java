package com.example.movierental.model;

import jakarta.persistence.*;
import java.time.Year;
import lombok.*;

@Entity
@Table(name = "Movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String title;

    private String genre;

    private Year releaseYear;

    private String status;
}
