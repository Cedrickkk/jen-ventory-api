package com.jenventory.jenventoryapi.gcash.mapper;

import com.jenventory.jenventoryapi.gcash.dto.request.GCashFeeTierRequest;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashFeeTierResponse;
import com.jenventory.jenventoryapi.gcash.entity.GCashFeeTier;
import org.springframework.stereotype.Component;

@Component
public class GCashFeeTierMapper {

    public GCashFeeTierResponse toResponse(GCashFeeTier feeTier) {
        if (feeTier == null) {
            return null;
        }
        return GCashFeeTierResponse.builder()
                .id(feeTier.getId())
                .minAmount(feeTier.getMinAmount())
                .maxAmount(feeTier.getMaxAmount())
                .fee(feeTier.getFee())
                .build();
    }

    public GCashFeeTier toEntity(GCashFeeTierRequest request) {
        if (request == null) {
            return null;
        }
        return GCashFeeTier.builder()
                .minAmount(request.getMinAmount())
                .maxAmount(request.getMaxAmount())
                .fee(request.getFee())
                .build();
    }

}
