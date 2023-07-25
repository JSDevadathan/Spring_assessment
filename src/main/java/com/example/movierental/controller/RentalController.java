package com.example.movierental.controller;

import com.example.movierental.contract.RentalResponseDto;
import com.example.movierental.service.RentalService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public ResponseEntity<List<RentalResponseDto>> getAllMovies() {
        return new ResponseEntity<>(rentalService.getAllRentals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDto> getRentalMovieById(@PathVariable int id) {
        return new ResponseEntity<>(rentalService.getRentalById((long) id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentalResponseDto> addRentalMovie(
            @Valid @RequestBody RentalResponseDto rental) {
        RentalResponseDto rentalResponseDto = rentalService.addRental(rental);
        return new ResponseEntity<>(rentalResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalResponseDto> updateRentalMovieById(
            @PathVariable int id, @Valid @RequestBody RentalResponseDto rental) {
        RentalResponseDto updatedRentalMovie = rentalService.updateRentalById((long) id, rental);
        return new ResponseEntity<>(updatedRentalMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentedMovieById(@PathVariable int id) {
        rentalService.deleteRentalById((long) id);
        return ResponseEntity.ok("Movie with ID " + id + " has been deleted.");
    }
}
