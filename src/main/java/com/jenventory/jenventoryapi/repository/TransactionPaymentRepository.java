package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.TransactionPayment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionPaymentRepository extends JpaRepository<TransactionPayment, Long> {

    List<TransactionPayment> findAllByTransactionId(Long transactionId, Pageable pageable);

}
