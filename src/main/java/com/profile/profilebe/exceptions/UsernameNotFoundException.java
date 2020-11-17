package com.profile.profilebe.exceptions;

public class UsernameNotFoundException extends Exception {

    public UsernameNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}