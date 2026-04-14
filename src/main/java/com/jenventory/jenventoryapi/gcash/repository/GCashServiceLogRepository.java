package com.jenventory.jenventoryapi.gcash.repository;

import com.jenventory.jenventoryapi.gcash.entity.GCashServiceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GCashServiceLogRepository extends JpaRepository<GCashServiceLog, Long> {

    Page<GCashServiceLog> findAll(Pageable pageable);

    Page<GCashServiceLog> findAllByCustomerId(Long customerId, Pageable pageable);

    @Query("""
                SELECT g FROM GCashServiceLog g
                LEFT JOIN g.customer c
                WHERE LOWER(g.representativePhone) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(g.representativeName)  LIKE LOWER(CONCAT('%', :query, '%'))
                   OR (c IS NOT NULL AND LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%')))
                   OR LOWER(CAST(g.amount AS string)) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(g.serviceType)          LIKE LOWER(CONCAT('%', :query, '%'))
            """)
    Page<GCashServiceLog> search(@Param("query") String query, Pageable pageable);

}
