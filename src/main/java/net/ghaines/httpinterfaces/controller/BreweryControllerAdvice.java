package net.ghaines.httpinterfaces.controller;


import net.ghaines.httpinterfaces.exception.BreweryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BreweryControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreweryControllerAdvice.class);

    @ExceptionHandler(BreweryException.class)
    private ProblemDetail handleException(BreweryException e) {
        LOGGER.error("Received an error", e);
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Could not find brewery");
    }

}
