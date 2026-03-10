package com.jenventory.jenventoryapi.gcash.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gcash_fee_tiers")
public class GCashFeeTier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "minimum_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal minAmount;

    @NotNull
    @Column(name = "maximum_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal maxAmount;

    @NotNull
    @Column(name = "fee", precision = 10, scale = 2, nullable = false)
    private BigDecimal fee;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}