package com.jenventory.jenventoryapi.transaction.controller;

import com.jenventory.jenventoryapi.common.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.common.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.transaction.dto.request.DebtPaymentRequest;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtLedgerResponse;
import com.jenventory.jenventoryapi.transaction.dto.response.DebtSummaryResponse;
import com.jenventory.jenventoryapi.transaction.enums.DebtLedgerType;
import com.jenventory.jenventoryapi.transaction.service.DebtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers/{id}/debt")
@RequiredArgsConstructor
public class DebtController {

    private final DebtService debtService;

    @GetMapping("/summary")
    public ResponseEntity<SuccessApiResponse<DebtSummaryResponse>> getDebtSummary(@PathVariable Long id) {
        DebtSummaryResponse debtSummary = debtService.getDebtSummary(id);

        SuccessApiResponse<DebtSummaryResponse> response =
                ApiResponseUtil.success(debtSummary, "Customer debt summary retrieved successfully.");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/payment")
    public ResponseEntity<SuccessApiResponse<DebtSummaryResponse>> createDebtPayment(
            @PathVariable Long id, @Valid @RequestBody DebtPaymentRequest request) {
        DebtSummaryResponse summaryResponse = debtService.recordDebtPayment(id, request);

        SuccessApiResponse<DebtSummaryResponse> response =
                ApiResponseUtil.success(summaryResponse, "Debt payment recorded successfully.");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<SuccessApiResponse<Page<DebtLedgerResponse>>> getDebtHistory(
            @PathVariable Long id,
            @RequestParam(name = "type", required = false, defaultValue = "") DebtLedgerType type,
            Pageable pageable) {

        Page<DebtLedgerResponse> debtHistory = debtService.getDebtHistory(id, type, pageable);

        SuccessApiResponse<Page<DebtLedgerResponse>> response =
                ApiResponseUtil.success(debtHistory, "Debt history retrieved successfully.");

        return ResponseEntity.ok(response);
    }

}
