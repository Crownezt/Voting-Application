package com.martinso.votingapp.exception;

public class AgeIsAllowedException extends UserDetailsException {
    public AgeIsAllowedException(String message) {
        super(message);
    }
}
