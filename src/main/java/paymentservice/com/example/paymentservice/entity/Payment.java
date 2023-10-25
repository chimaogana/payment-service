package paymentservice.com.example.paymentservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String transactionId;
    private String status;
    private LocalDateTime timestamp;

    public Payment() {
        this.transactionId = UUID.randomUUID().toString();
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
