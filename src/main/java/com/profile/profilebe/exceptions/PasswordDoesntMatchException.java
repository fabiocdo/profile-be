package com.profile.profilebe.exceptions;

public class PasswordDoesntMatchException extends Exception {

    public PasswordDoesntMatchException(String errorMessage) {
        super(errorMessage);
    }
}