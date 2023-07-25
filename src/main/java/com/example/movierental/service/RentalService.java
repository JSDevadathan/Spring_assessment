package com.example.movierental.service;

import com.example.movierental.contract.RentalResponseDto;
import com.example.movierental.expection.RentalNotFoundException;
import com.example.movierental.model.Rental;
import com.example.movierental.repository.RentalRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RentalService {
    private final RentalRepository rentalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RentalService(RentalRepository rentalRepository, ModelMapper modelMapper) {
        this.rentalRepository = rentalRepository;
        this.modelMapper = modelMapper;
    }

    public List<RentalResponseDto> getAllRentals() {
        List<Rental> rentals = this.rentalRepository.findAll();
        List<RentalResponseDto> responses = new ArrayList<>();
        for (Rental r : rentals) {
            responses.add(modelMapper.map(r, RentalResponseDto.class));
        }
        return responses;
    }

    public RentalResponseDto getRentalById(Long id) throws RentalNotFoundException {
        Rental rental =
                rentalRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Rental with id: {} not found", id);
                                    return new RentalNotFoundException(id);
                                });
        return modelMapper.map(rental, RentalResponseDto.class);
    }

    public RentalResponseDto addRental(RentalResponseDto rentalDto) {
        Rental rental = modelMapper.map(rentalDto, Rental.class);
        Rental savedRental = rentalRepository.save(rental);
        return modelMapper.map(savedRental, RentalResponseDto.class);
    }

    public RentalResponseDto updateRentalById(Long id, @Valid RentalResponseDto rental)
            throws RentalNotFoundException {
        Rental existingRental =
                rentalRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Rental with id: {} not found", id);
                                    return new RentalNotFoundException(id);
                                });

        modelMapper.map(rental, existingRental);
        Rental updatedRental = rentalRepository.save(existingRental);
        return modelMapper.map(updatedRental, RentalResponseDto.class);
    }

    public void deleteRentalById(Long id) throws RentalNotFoundException {
        if (!rentalRepository.existsById(id)) {
            throw new RentalNotFoundException(id);
        }
        rentalRepository.deleteById(id);
    }
}
