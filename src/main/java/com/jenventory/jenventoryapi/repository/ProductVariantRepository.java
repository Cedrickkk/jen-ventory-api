package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.ProductVariant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    Page<ProductVariant> findAllByProductIdAndActiveTrue(Long productId, Pageable pageable);

    Optional<ProductVariant> findByIdAndActiveTrue(Long id);

    Optional<ProductVariant> findByIdAndActiveFalse(Long id);

    boolean existsBySku(String sku);

    boolean existsBySkuAndIdNot(String sku, Long id);

}
