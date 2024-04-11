package com.example.springexample.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NewsByIdNotFoundException.class})
    protected ResponseEntity<ErrorMessage> handleException(NewsByIdNotFoundException e) {
        log.error("Application specific error handling", e);
        return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoSuchElementException.class})
    protected ResponseEntity<ErrorMessage> handleException(NoSuchElementException e) {
        log.error("Application specific error handling", e);
        return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
