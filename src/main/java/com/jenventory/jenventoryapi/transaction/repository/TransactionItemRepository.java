package com.jenventory.jenventoryapi.transaction.repository;

import com.jenventory.jenventoryapi.transaction.entity.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {

    List<TransactionItem> findAllByTransactionId(Long transactionId);

}
