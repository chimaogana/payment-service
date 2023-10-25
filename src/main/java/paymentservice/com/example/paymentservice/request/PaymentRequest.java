package paymentservice.com.example.paymentservice.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentRequest {
    private double amount;
    private String transactionId;
    private String status;
    private LocalDateTime timestamp;
}
