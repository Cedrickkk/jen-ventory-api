package com.jenventory.jenventoryapi.controller;

import com.jenventory.jenventoryapi.dto.request.TransactionRequest;
import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionResponse;
import com.jenventory.jenventoryapi.dto.response.TransactionSummaryResponse;
import com.jenventory.jenventoryapi.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<SuccessApiResponse<Page<TransactionSummaryResponse>>> getAll(Pageable pageable) {

        Page<TransactionSummaryResponse> paginatedProductVariants = transactionService.getAll(pageable);

        SuccessApiResponse<Page<TransactionSummaryResponse>> response =
                ApiResponseUtil.success(paginatedProductVariants, "Transactions retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SuccessApiResponse<TransactionResponse>> create(@Valid @RequestBody TransactionRequest request) {
        TransactionResponse transactionResponse = transactionService.create(request);

        SuccessApiResponse<TransactionResponse> response =
                ApiResponseUtil.created(transactionResponse, "Transaction created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
