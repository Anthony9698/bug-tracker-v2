package com.bugtrackerv2.server.exception;

import org.springframework.security.core.AuthenticationException;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException(final String msg) {
        super(msg);
    }
}
