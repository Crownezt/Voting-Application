package com.martinso.votingapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiRequestException extends UserDetailsException{

    @Getter
    public HttpStatus status = HttpStatus.BAD_REQUEST;

    public ApiRequestException() {
        this("API Request Error");
    }
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, HttpStatus status){
        this(message);
        this.status = status;
    }
}
