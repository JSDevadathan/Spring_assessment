package com.example.movierental.expection;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(int id) {
        super("Could not find movie with id: " + id);
    }
}
