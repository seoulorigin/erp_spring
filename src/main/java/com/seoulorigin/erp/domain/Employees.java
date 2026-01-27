package com.seoulorigin.erp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor // parameter 없는 default constructor 생성
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 DB에 위임
    private Long id; // BIGINT ; Unsigned --> Biginteger

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String department;

    @Column(nullable = false, length = 100)
    private String position;

    private LocalDateTime created_at;

    public Employees(String name, String department, String position) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.created_at = LocalDateTime.now();
    }

    public void update(String department, String position) {
        this.department = department;
        this.position = position;
    }
}
