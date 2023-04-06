package com.organizationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTime(LocalDateTime.now());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setErrorCode("ORGANIZATION_NOT_FOUND");
        errorDetails.setPath(webRequest.getDescription(false));
        return errorDetails;
    }
}
