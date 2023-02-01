package com.atl.tutorialtask.exception;

public class NoSuchTutorialExistsException extends RuntimeException {
    private String message;


    public NoSuchTutorialExistsException() {

    }

    public NoSuchTutorialExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
