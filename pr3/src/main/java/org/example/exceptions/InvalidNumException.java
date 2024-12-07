package org.example.exceptions;

public class InvalidNumException extends RuntimeException {
    public InvalidNumException(String message, Throwable cause) {
        super(message, cause);
    }
}
