package com.jenventory.jenventoryapi.product.repository;

import com.jenventory.jenventoryapi.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByActiveTrue(Pageable pageable);

    Optional<Product> findByIdAndActiveTrue(Long id);

    Optional<Product> findByIdAndActiveFalse(Long id);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);

    @Query("""
            SELECT p FROM Product p
            WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%'))
            AND p.active = true
            """)
    List<Product> search(@Param("query") String query);

}
