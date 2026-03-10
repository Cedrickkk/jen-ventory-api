package com.jenventory.jenventoryapi.gcash.repository;

import com.jenventory.jenventoryapi.gcash.entity.GCashServiceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GCashServiceLogRepository extends JpaRepository<GCashServiceLog, Long> {

    Page<GCashServiceLog> findAll(Pageable pageable);

    Page<GCashServiceLog> findAllByCustomerId(Long customerId, Pageable pageable);

}
