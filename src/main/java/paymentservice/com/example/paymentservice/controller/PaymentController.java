package paymentservice.com.example.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import paymentservice.com.example.paymentservice.entity.Payment;
import paymentservice.com.example.paymentservice.exceptions.InvalidPaymentException;
import paymentservice.com.example.paymentservice.exceptions.PaymentNotFoundException;
import paymentservice.com.example.paymentservice.request.PaymentRequest;
import paymentservice.com.example.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;


    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> createPayment (@RequestBody PaymentRequest paymentRequest){
        try {
            // Validate payment amount
            if (paymentRequest.getAmount() <= 0) {
                throw new InvalidPaymentException("Payment amount should be a positive number");
            }

            // Process payment creation
            Payment payment = paymentService.createPayment(paymentRequest.getAmount());

            return ResponseEntity.ok("Payment created successfully with ID: " + payment.getId());
        } catch (InvalidPaymentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create payment");
        }

    }

    @GetMapping("/{paymentId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> getPayment(@PathVariable Long paymentId) {
        try {
            Payment payment = paymentService.getPaymentById(paymentId);
            return ResponseEntity.ok(payment);
        } catch (PaymentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve payment");
        }
    }


}
