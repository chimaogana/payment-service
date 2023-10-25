package paymentservice.com.example.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentservice.com.example.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
