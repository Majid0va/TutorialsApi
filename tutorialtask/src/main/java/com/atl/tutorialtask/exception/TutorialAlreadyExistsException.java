package com.atl.tutorialtask.exception;

public class TutorialAlreadyExistsException extends RuntimeException {
    private String message;


    public TutorialAlreadyExistsException() {

    }

    public TutorialAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
