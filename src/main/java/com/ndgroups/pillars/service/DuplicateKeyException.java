package com.ndgroups.pillars.service;

public class DuplicateKeyException extends RuntimeException{
    public DuplicateKeyException(String message) {
        super(message);
    }
}
