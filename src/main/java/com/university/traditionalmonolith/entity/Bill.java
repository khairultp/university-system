package com.university.traditionalmonolith.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private BigDecimal amount;
    private boolean paid;
}
