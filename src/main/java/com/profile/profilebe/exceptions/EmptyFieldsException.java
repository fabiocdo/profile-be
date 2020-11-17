package com.profile.profilebe.exceptions;

public class EmptyFieldsException extends Exception {

    public EmptyFieldsException(String errorMessage) {
        super(errorMessage);
    }
}