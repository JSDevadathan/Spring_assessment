package com.example.movierental.controller;

import com.example.movierental.contract.MovieResponseDto;
import com.example.movierental.expection.MovieNotFoundException;
import com.example.movierental.model.Movie;
import com.example.movierental.service.MovieService;
import jakarta.validation.Valid;
import java.util.List;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable int id)
            throws MovieNotFoundException {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<List<MovieResponseDto>> getMoviesByYear(@PathVariable int year) {
        List<MovieResponseDto> moviesByYear = movieService.getMoviesByYear(year);
        return new ResponseEntity<>(moviesByYear, HttpStatus.OK);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<MovieResponseDto>> getMoviesByStatus(@PathVariable("status") String status) {
        String formattedStatus = convertToTitleCase(status);
        List<MovieResponseDto> moviesByStatus = movieService.getMoviesByStatus(formattedStatus);
        return new ResponseEntity<>(moviesByStatus, HttpStatus.OK);
    }
    private String convertToTitleCase(String status) {
        return WordUtils.capitalizeFully(status);
    }

    @PostMapping
    public ResponseEntity<MovieResponseDto> addMovie(@Valid @RequestBody Movie movie) {
        MovieResponseDto movieResponseDto = movieService.addMovie(movie);
        return new ResponseEntity<>(movieResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> updateMovieById(
            @PathVariable int id, @Valid @RequestBody Movie movie) throws MovieNotFoundException {
        MovieResponseDto updatedMovie = movieService.updateMovieById(id, movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable int id)
            throws MovieNotFoundException {
        movieService.deleteMovieById(id);
        return ResponseEntity.ok("Movie with ID " + id + " has been deleted.");
    }
}
