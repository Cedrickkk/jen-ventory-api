package com.jenventory.jenventoryapi.transaction.repository;

import com.jenventory.jenventoryapi.transaction.entity.TransactionPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionPaymentRepository extends JpaRepository<TransactionPayment, Long> {

    List<TransactionPayment> findAllByTransactionId(Long transactionId);

}
