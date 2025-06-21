package com.university.traditionalmonolith.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nim;
    private String name;
    private boolean active;
    private String email;
}
