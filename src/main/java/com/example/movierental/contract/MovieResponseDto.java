package com.example.movierental.contract;

import com.example.movierental.validation.movies.ValidGenre;
import com.example.movierental.validation.movies.ValidStatus;
import com.example.movierental.validation.movies.ValidTitle;
import com.example.movierental.validation.movies.ValidYear;
import lombok.*;

import java.time.Year;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {
    private Long id;
    @ValidTitle private String title;
    @ValidGenre private String genre;
    @ValidYear private Year releaseYear;
    @ValidStatus private String status;

    public enum MovieStatus {
        Available,
        Rented
    }
}
