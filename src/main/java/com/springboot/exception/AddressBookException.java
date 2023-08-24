package com.springboot.exception;

public class AddressBookException extends RuntimeException{
    public AddressBookException(String message){
        super(message);
    }
}
