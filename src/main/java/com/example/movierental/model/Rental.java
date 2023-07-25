package com.example.movierental.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "Rentals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String movieId;

    private String userId;

    private LocalDate rentalDate;

    private LocalDate returnDate;
}
