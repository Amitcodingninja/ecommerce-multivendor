package com.amitXplode.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private Double discountPercentage;

    private LocalDate validityStartDate;

    private LocalDate validityEndDate;

    private Double minimumOrderValue;

    private boolean isActive = true;

    @ManyToMany(mappedBy = "usedCoupons")
    private Set<User> usedByUsers = new HashSet<>();
}
