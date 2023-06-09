package com.cvillegas.app.main.model.repository;

import com.cvillegas.app.main.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
