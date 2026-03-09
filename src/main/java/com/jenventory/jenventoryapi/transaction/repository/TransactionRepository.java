package com.jenventory.jenventoryapi.transaction.repository;

import com.jenventory.jenventoryapi.transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findAllByCustomerId(Long customerId, Pageable pageable);

    @Query("""
            SELECT t FROM Transaction t
            LEFT JOIN FETCH t.payments
            WHERE t.customer.id = :id
            """)
    Page<Transaction> findAllByCustomerIdWithPayments(@Param("id") Long customerId, Pageable pageable);

    @Query("""
            SELECT t FROM Transaction t
            LEFT JOIN FETCH t.customer c
            """)
    Page<Transaction> findAllWithCustomer(Pageable pageable);

    /**
     * NOTE: Set is used to avoid MultipleBagFetchException when fetching multiple collections with JOIN FETCH
     */
    @Query("""
            SELECT t FROM Transaction t
            LEFT JOIN FETCH t.items ti
            LEFT JOIN FETCH ti.productVariant pv
            LEFT JOIN FETCH pv.product
            LEFT JOIN FETCH t.payments
            WHERE t.id = :id
            """)
    Optional<Transaction> findByIdWithItemsAndPayments(@Param("id") Long id);

}
