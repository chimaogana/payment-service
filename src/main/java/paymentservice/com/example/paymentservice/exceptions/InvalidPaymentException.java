package paymentservice.com.example.paymentservice.exceptions;

public class InvalidPaymentException extends RuntimeException{
    public InvalidPaymentException(String message) {
        super(message);
    }
}
