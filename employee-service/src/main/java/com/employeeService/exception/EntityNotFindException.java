package com.employeeService.exception;

public class EntityNotFindException extends RuntimeException{
    public EntityNotFindException(String message) {
        super(message);
    }
}
