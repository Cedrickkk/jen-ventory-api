package com.jenventory.jenventoryapi.gcash.controller;

import com.jenventory.jenventoryapi.common.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.common.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashFeeTierRequest;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashServiceLogRequest;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashFeeTierResponse;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashServiceLogResponse;
import com.jenventory.jenventoryapi.gcash.service.GCashService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gcash")
@RequiredArgsConstructor
public class GCashController {

    private final GCashService gcashService;

    @GetMapping("/fee-tiers")
    public ResponseEntity<SuccessApiResponse<List<GCashFeeTierResponse>>> getFeeTiers() {
        List<GCashFeeTierResponse> allFeeTiers = gcashService.getAllFeeTiers();

        SuccessApiResponse<List<GCashFeeTierResponse>> response =
                ApiResponseUtil.success(allFeeTiers, "GCash fee tiers retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/fee-tiers")
    public ResponseEntity<SuccessApiResponse<GCashFeeTierResponse>> createFeeTier(@Valid @RequestBody GCashFeeTierRequest request) {
        GCashFeeTierResponse feeTier = gcashService.createFeeTier(request);

        SuccessApiResponse<GCashFeeTierResponse> response =
                ApiResponseUtil.created(feeTier, "GCash fee tier created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/fee-tiers/{id}")
    public ResponseEntity<SuccessApiResponse<GCashFeeTierResponse>> updateFeeTiers(@PathVariable Long id, @Valid @RequestBody GCashFeeTierRequest request) {
        GCashFeeTierResponse updateFeeTier = gcashService.updateFeeTier(id, request);

        SuccessApiResponse<GCashFeeTierResponse> response =
                ApiResponseUtil.created(updateFeeTier, "GCash fee tier updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/fee-tiers/{id}")
    public ResponseEntity<SuccessApiResponse<Void>> deleteFeeTiers(@PathVariable Long id) {
        gcashService.deleteFeeTier(id);

        SuccessApiResponse<Void> response = ApiResponseUtil.noContent("GCash fee tier deleted successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/transactions")
    public ResponseEntity<SuccessApiResponse<Page<GCashServiceLogResponse>>> getTransactions(Pageable pageable) {
        Page<GCashServiceLogResponse> allServiceLogs = gcashService.getAllServiceLogs(pageable);

        SuccessApiResponse<Page<GCashServiceLogResponse>> response =
                ApiResponseUtil.success(allServiceLogs, "GCash transactions retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/transactions")
    public ResponseEntity<SuccessApiResponse<GCashServiceLogResponse>> createTransaction(@Valid @RequestBody GCashServiceLogRequest request) {
        GCashServiceLogResponse serviceLog = gcashService.createServiceLog(request);

        SuccessApiResponse<GCashServiceLogResponse> response =
                ApiResponseUtil.created(serviceLog, "GCash transaction created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<SuccessApiResponse<GCashServiceLogResponse>> getTransactionById(@PathVariable Long id) {
        GCashServiceLogResponse gCashServiceLog = gcashService.findServiceLogById(id);

        SuccessApiResponse<GCashServiceLogResponse> response =
                ApiResponseUtil.success(gCashServiceLog, "GCash transaction retrieved successfully");

        return ResponseEntity.ok(response);
    }
}
