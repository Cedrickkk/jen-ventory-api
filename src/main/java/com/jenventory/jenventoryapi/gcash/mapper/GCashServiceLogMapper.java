package com.jenventory.jenventoryapi.gcash.mapper;

import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashServiceLogRequest;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashServiceLogResponse;
import com.jenventory.jenventoryapi.gcash.entity.GCashServiceLog;
import com.jenventory.jenventoryapi.gcash.enums.GCashTransactionType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GCashServiceLogMapper {

    public GCashServiceLog toEntity(GCashServiceLogRequest request, Customer customer, BigDecimal fee) {
        if (request == null) {
            return null;
        }

        return GCashServiceLog.builder()
                .customer(customer)
                .representativeName(request.getRepresentativeName())
                .representativePhone(request.getRepresentativePhone())
                .serviceType(GCashTransactionType.valueOf(request.getServiceType()))
                .amount(request.getAmount())
                .fee(fee)
                .notes(request.getNotes())
                .build();
    }


    public GCashServiceLogResponse toResponse(GCashServiceLog serviceLog) {
        if (serviceLog == null) {
            return null;
        }

        return GCashServiceLogResponse.builder()
                .id(serviceLog.getId())
                .customerId(serviceLog.getCustomer() != null ? serviceLog.getCustomer().getId() : null)
                .representativeName(serviceLog.getRepresentativeName())
                .representativePhone(serviceLog.getRepresentativePhone())
                .serviceType(serviceLog.getServiceType())
                .amount(serviceLog.getAmount())
                .fee(serviceLog.getFee())
                .notes(serviceLog.getNotes())
                .createdAt(serviceLog.getCreatedAt())
                .build();
    }
}
