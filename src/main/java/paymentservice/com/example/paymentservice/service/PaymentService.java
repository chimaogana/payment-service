package paymentservice.com.example.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import paymentservice.com.example.paymentservice.entity.Payment;
import paymentservice.com.example.paymentservice.exceptions.InvalidPaymentException;
import paymentservice.com.example.paymentservice.exceptions.PaymentNotFoundException;
import paymentservice.com.example.paymentservice.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment createPayment(double amount) {
        // Validate payment amount
        if (amount <= 0) {
            throw new InvalidPaymentException("Payment amount should be a positive number");
        }

        // Create a new payment
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setStatus("Pending");
        payment.setTransactionId(generateTransactionId());
        payment.setTimestamp(LocalDateTime.now());

        // Save the payment to the database
        return paymentRepository.save(payment);
    }
    private String generateTransactionId() {
        // Implement logic to generate a unique transaction ID
        // You can use UUID.randomUUID().toString() to generate a unique ID
        return UUID.randomUUID().toString();
    }


    @Async
    public void processPayment(Payment payment) {
        try {
            // Simulate payment processing delay
            TimeUnit.SECONDS.sleep(5);
            // Update payment status to "Completed"
            payment.setStatus("Completed");
            // Save the updated payment to the database
            paymentRepository.save(payment);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Handle interrupted exception
        }
    }


    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with ID: " + paymentId));
    }



}
