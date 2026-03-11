package com.localpermit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "permits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private String applicantContact;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermitType permitType;

    @Column(nullable = false)
    private String wardOrArea;

    @Column(nullable = false)
    private LocalDate applicationDate;

    @Column(nullable = false)
    private LocalDate intendedStartDate;

    @Column(nullable = false)
    private LocalDate intendedEndDate;

    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
