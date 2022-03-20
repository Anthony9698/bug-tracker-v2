package com.bugtrackerv2.server.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(final String msg) {
        super(msg);
    }
}
