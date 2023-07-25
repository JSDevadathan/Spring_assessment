package com.example.movierental.contract;

import com.example.movierental.validation.rentals.ValidMovieId;
import com.example.movierental.validation.rentals.ValidRentalDate;
import com.example.movierental.validation.rentals.ValidReturnDate;
import com.example.movierental.validation.rentals.ValidUserId;
import java.time.LocalDate;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponseDto {
    private Long id;
    @ValidMovieId private String movieId;
    @ValidUserId private String userId;
    @ValidRentalDate private LocalDate rentalDate;
    @ValidReturnDate private LocalDate returnDate;
}
