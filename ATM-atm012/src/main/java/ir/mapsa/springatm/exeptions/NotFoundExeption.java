package ir.mapsa.springatm.exeptions;

public class NotFoundExeption extends RuntimeException {


    public NotFoundExeption() {
    }

    public NotFoundExeption(String message) {
        super(message);
    }
}
