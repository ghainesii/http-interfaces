package net.ghaines.httpinterfaces.controller;


import lombok.extern.slf4j.Slf4j;
import net.ghaines.httpinterfaces.exception.BreweryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class BreweryControllerAdvice {

    @ExceptionHandler(BreweryException.class)
    private ProblemDetail handleException(BreweryException e) {
        log.error("Received an error", e);
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Could not find brewery");
    }

}
