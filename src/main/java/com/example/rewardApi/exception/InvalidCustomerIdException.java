package com.example.rewardApi.exception;

/**
 * Exception thrown when customer ID is invalid.
 */
public class InvalidCustomerIdException extends RuntimeException{

    public InvalidCustomerIdException(String message) {
        super(message);
    }
}
