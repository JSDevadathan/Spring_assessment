package com.example.movierental.expection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String movieName) {
        super("Movie " + movieName + " is already exists");
    }
}