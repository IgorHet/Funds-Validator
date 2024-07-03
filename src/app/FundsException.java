package app;

// Кастомний виняток
public class FundsException extends Exception {

    public FundsException(String message) {
        super(message);
    }
}