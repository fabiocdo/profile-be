package com.profile.profilebe.exceptions;

public class UsernameAlreadyExistsException extends Exception {

    public UsernameAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}