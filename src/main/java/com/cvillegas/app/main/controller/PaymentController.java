package com.cvillegas.app.main.controller;

import com.cvillegas.app.main.model.Payment;
import com.cvillegas.app.main.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/info/monthly-services")
    public ResponseEntity<List<Payment>> findAll() {
        return ResponseEntity.ok(paymentService.findAll());
    }
}
