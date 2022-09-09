package com.kenzie.library;

public class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String bookTitle) {
        super(bookTitle + " has already been checked out.  Please try again later.");
    }
}