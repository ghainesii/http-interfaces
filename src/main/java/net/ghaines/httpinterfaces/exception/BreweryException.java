package net.ghaines.httpinterfaces.exception;

public class BreweryException extends RuntimeException {

    public BreweryException(String errorMessage) {
        super(errorMessage);
    }

    public BreweryException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}
