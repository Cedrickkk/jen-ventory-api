package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findAllByCustomerId(Long customerId, Pageable pageable);

}
