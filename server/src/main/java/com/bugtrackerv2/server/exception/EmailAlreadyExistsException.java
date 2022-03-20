package com.bugtrackerv2.server.exception;

import org.springframework.security.core.AuthenticationException;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(final String msg) {
        super(msg);
    }
}
