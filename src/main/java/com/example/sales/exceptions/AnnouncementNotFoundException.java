package com.example.sales.exceptions;

public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException(String message) {
        super(message);
    }
}
