package net.ghaines.httpinterfaces.brewery;

class BreweryException extends RuntimeException {

    BreweryException(String errorMessage) {
        super(errorMessage);
    }

    BreweryException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}
