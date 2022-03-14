package ir.mapsa.springatm.exeptions;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
