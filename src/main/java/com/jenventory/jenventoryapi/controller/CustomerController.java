package com.jenventory.jenventoryapi.controller;

import com.jenventory.jenventoryapi.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<SuccessApiResponse<Page<CustomerResponse>>> getAll(Pageable pageable) {
        Page<CustomerResponse> paginatedCustomers = customerService.getAll(pageable);

        SuccessApiResponse<Page<CustomerResponse>> response =
                ApiResponseUtil.success(paginatedCustomers, "Customers retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SuccessApiResponse<CustomerResponse>> createCustomer(
            @Validated @RequestBody CustomerRequest request) {

        CustomerResponse customerResponse = customerService.create(request);

        SuccessApiResponse<CustomerResponse> response =
                ApiResponseUtil.success(customerResponse, "Customer created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
