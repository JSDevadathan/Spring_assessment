package com.example.movierental.repository;

import com.example.movierental.model.Rental;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findById(int id);
}
