package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.DebtLedger;
import com.jenventory.jenventoryapi.enums.DebtLedgerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface DebtLedgerRepository extends JpaRepository<DebtLedger, Long> {

    Page<DebtLedger> findAllByCustomerId(Long customerId, Pageable pageable);

    Page<DebtLedger> findAllByCustomerIdAndType(Long customerId, DebtLedgerType type, Pageable pageable);

    List<DebtLedger> findAllByCustomerIdAndType(Long customerId, DebtLedgerType type);

    @Query("SELECT COALESCE(SUM(d.amount), 0) FROM DebtLedger d WHERE d.customer.id = :customerId AND d.type = :type")
    BigDecimal sumAmountByCustomerIdAndType(@Param("customerId") Long customerId, @Param("type") DebtLedgerType type);

}
