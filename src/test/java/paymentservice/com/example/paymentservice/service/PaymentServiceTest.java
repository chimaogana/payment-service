package paymentservice.com.example.paymentservice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import paymentservice.com.example.paymentservice.entity.Payment;
import paymentservice.com.example.paymentservice.repository.PaymentRepository;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @Test
    public void testCreatePayment() {
        double amount = 100.0;
        Payment payment = new Payment();
        payment.setAmount(amount);

        given(paymentRepository.save(payment)).willReturn(payment);

        Payment createdPayment = paymentService.createPayment(amount);
        assertThat(createdPayment.getAmount()).isEqualTo(amount);
        assertThat(createdPayment.getStatus()).isEqualTo("Pending");
    }

    @Test
    public void testGetPaymentById() {
        Long paymentId = 1L;
        Payment mockPayment = new Payment();
        mockPayment.setId(paymentId);
        mockPayment.setAmount(100.0);
        mockPayment.setStatus("Completed");

        given(paymentRepository.findById(paymentId)).willReturn(Optional.of(mockPayment));

        Payment retrievedPayment = paymentService.getPaymentById(paymentId);
        assertThat(retrievedPayment.getId()).isEqualTo(paymentId);
        assertThat(retrievedPayment.getAmount()).isEqualTo(100.0);
        assertThat(retrievedPayment.getStatus()).isEqualTo("Completed");
    }

}