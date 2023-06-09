package com.cvillegas.app.main.service;

import com.cvillegas.app.main.model.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findAll();
}
