package com.jenventory.jenventoryapi.gcash.repository;

import com.jenventory.jenventoryapi.gcash.entity.GCashFeeTier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface GCashFeeTierRepository extends JpaRepository<GCashFeeTier, Long> {

    boolean existsByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(BigDecimal maxAmount, BigDecimal minAmount);

    boolean existsByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndIdNot(BigDecimal minAmount, BigDecimal maxAmount, Long id);

    Optional<GCashFeeTier> findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(BigDecimal minAmount, BigDecimal maxAmount);

}
