package com.jenventory.jenventoryapi.customer.controller;

import com.jenventory.jenventoryapi.customer.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerTransactionResponse;
import com.jenventory.jenventoryapi.customer.service.CustomerService;
import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<SuccessApiResponse<Page<CustomerResponse>>> getAll(Pageable pageable) {
        Page<CustomerResponse> paginatedCustomers = customerService.getAll(pageable);

        SuccessApiResponse<Page<CustomerResponse>> response =
                ApiResponseUtil.success(paginatedCustomers, "Customers retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<CustomerResponse>> getById(@PathVariable Long id) {
        CustomerResponse customerResponse = customerService.findById(id);

        SuccessApiResponse<CustomerResponse> response =
                ApiResponseUtil.success(customerResponse, "Customer retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SuccessApiResponse<CustomerResponse>> create(
            @Valid @RequestBody CustomerRequest request) {

        CustomerResponse customerResponse = customerService.create(request);

        SuccessApiResponse<CustomerResponse> response =
                ApiResponseUtil.created(customerResponse, "Customer created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<CustomerResponse>> update(
            @PathVariable Long id, @Valid @RequestBody CustomerRequest request) {

        CustomerResponse customer = customerService.update(id, request);

        SuccessApiResponse<CustomerResponse> response =
                ApiResponseUtil.success(customer, "Customer updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<Void>> delete(@PathVariable Long id) {
        customerService.deactivate(id);

        SuccessApiResponse<Void> response = ApiResponseUtil.noContent("Customer deactivated successfully");

        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}/reactivate")
    public ResponseEntity<SuccessApiResponse<CustomerResponse>> reactivate(@PathVariable Long id) {
        CustomerResponse customer = customerService.reactivate(id);

        SuccessApiResponse<CustomerResponse> response =
                ApiResponseUtil.success(customer, "Customer reactivated successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<SuccessApiResponse<List<CustomerResponse>>> search(
            @RequestParam(name = "query", required = false, defaultValue = "") String query) {

        log.info("QUERY PARAMS: {}", query);

        List<CustomerResponse> customers = customerService.search(query);

        SuccessApiResponse<List<CustomerResponse>> response =
                ApiResponseUtil.success(customers, "Result for search query: " + query);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<SuccessApiResponse<Page<CustomerTransactionResponse>>> getTransactionsForCustomer(
            @PathVariable Long id, Pageable pageable) {
        Page<CustomerTransactionResponse> transactions = transactionService.getCustomerTransactions(id, pageable);

        SuccessApiResponse<Page<CustomerTransactionResponse>> response =
                ApiResponseUtil.success(transactions, "Customer transactions retrieved successfully");

        return ResponseEntity.ok(response);
    }
}
