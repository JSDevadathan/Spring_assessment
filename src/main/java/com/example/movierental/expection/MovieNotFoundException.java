package com.example.movierental.expection;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(int id) {
        super("Couldn't find movie with id: " + id);
    }
}
