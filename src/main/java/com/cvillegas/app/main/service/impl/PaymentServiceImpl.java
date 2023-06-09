package com.cvillegas.app.main.service.impl;

import com.cvillegas.app.main.model.Payment;
import com.cvillegas.app.main.model.repository.IPaymentRepository;
import com.cvillegas.app.main.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {
    private final IPaymentRepository serviceRepository;

    public PaymentServiceImpl(IPaymentRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Payment> findAll() {
        return this.serviceRepository.findAll();
    }
}
