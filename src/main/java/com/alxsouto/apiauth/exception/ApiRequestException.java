package com.alxsouto.apiauth.exception;

public class ApiRequestException extends RuntimeException{

    public ApiRequestException (String message){
        super(message);
    }
    public ApiRequestException (String message, Throwable causa){
        super(message, causa);
    }
}
