package com.jenventory.jenventoryapi.gcash.service;

import com.jenventory.jenventoryapi.gcash.dto.request.GCashFeeTierRequest;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashServiceLogRequest;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashFeeTierResponse;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashServiceLogResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GCashService {

    List<GCashFeeTierResponse> getAllFeeTiers();

    GCashFeeTierResponse createFeeTier(GCashFeeTierRequest request);

    GCashFeeTierResponse updateFeeTier(Long id, GCashFeeTierRequest request);

    void deleteFeeTier(Long id);

    GCashServiceLogResponse createServiceLog(GCashServiceLogRequest request);

    Page<GCashServiceLogResponse> getAllServiceLogs(Pageable pageable);

    GCashServiceLogResponse findServiceLogById(Long id);

    Page<GCashServiceLogResponse> getCustomerGCashHistory(Long customerId, Pageable pageable);
}
