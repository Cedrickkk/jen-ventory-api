package com.jenventory.jenventoryapi.transaction.service;

import com.jenventory.jenventoryapi.transaction.dto.request.DebtPaymentRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtLedgerResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtSummaryResponse;
import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DebtService {

    DebtSummaryResponse recordDebtPayment(Long customerId, DebtPaymentRequest request);

    DebtSummaryResponse getDebtSummary(Long customerId);

    Page<DebtLedgerResponse> getDebtHistory(Long customerId, DebtLedgerType type, Pageable pageable);

}
