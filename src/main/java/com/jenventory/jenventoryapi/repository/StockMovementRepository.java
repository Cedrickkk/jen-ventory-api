package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.StockMovement;
import com.jenventory.jenventoryapi.enums.StockMovementReason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    Page<StockMovement> findAllByVariantId(Long variantId, Pageable pageable);

    Page<StockMovement> findAllByVariantIdAndReason(Long variantId, StockMovementReason reason, Pageable pageable);
}
