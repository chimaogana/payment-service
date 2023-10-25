package paymentservice.com.example.paymentservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import paymentservice.com.example.paymentservice.request.PaymentRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void testCreatePayment() throws Exception {
//        PaymentRequest paymentRequest = new PaymentRequest();
//        paymentRequest.setAmount(100.0);
//
//        mockMvc.perform(post("/api/payments/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(paymentRequest)))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Payment created successfully")));
//    }
}