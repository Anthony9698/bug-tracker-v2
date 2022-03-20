package com.bugtrackerv2.server.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(final String msg) {
        super(msg);
    }
}
