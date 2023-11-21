package com.cvillegas.app.main.model;

import lombok.*;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseEntity {
    private String name;
    private String description;
    private LocalDate paymentDate;
    private BigDecimal payableAmount;
    private boolean notify;
}
