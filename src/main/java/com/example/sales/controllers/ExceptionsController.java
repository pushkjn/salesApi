package com.example.sales.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.sales.domain.ErrorResponce;
import com.example.sales.exceptions.AnnouncementNotFoundException;
import com.example.sales.exceptions.IncorrectAnnouncementException;

import org.springframework.http.HttpStatus;


@RestControllerAdvice
public class ExceptionsController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IncorrectAnnouncementException.class)
    public ErrorResponce onIncorrectParameters(IncorrectAnnouncementException exception) {
        return new ErrorResponce("Incorrect announcement data", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AnnouncementNotFoundException.class)
    public ErrorResponce onAnnouncementNotFound(AnnouncementNotFoundException exception) {
        return new ErrorResponce("Announcement not found", exception.getMessage());
    }
    
}
