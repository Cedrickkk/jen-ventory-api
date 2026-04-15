package com.jenventory.jenventoryapi.gcash.service.impl;

import com.jenventory.jenventoryapi.common.exception.BusinessRuleException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.customer.repository.CustomerRepository;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashFeeTierRequest;
import com.jenventory.jenventoryapi.gcash.dto.request.GCashServiceLogRequest;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashFeeTierResponse;
import com.jenventory.jenventoryapi.gcash.dto.response.GCashServiceLogResponse;
import com.jenventory.jenventoryapi.gcash.entity.GCashFeeTier;
import com.jenventory.jenventoryapi.gcash.entity.GCashServiceLog;
import com.jenventory.jenventoryapi.gcash.mapper.GCashFeeTierMapper;
import com.jenventory.jenventoryapi.gcash.mapper.GCashServiceLogMapper;
import com.jenventory.jenventoryapi.gcash.repository.GCashFeeTierRepository;
import com.jenventory.jenventoryapi.gcash.repository.GCashServiceLogRepository;
import com.jenventory.jenventoryapi.gcash.service.GCashService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GCashServiceImpl implements GCashService {

    private final GCashFeeTierRepository gcashFeeTierRepository;
    private final GCashServiceLogRepository gCashServiceLogRepository;
    private final CustomerRepository customerRepository;
    private final GCashFeeTierMapper gCashFeeTierMapper;
    private final GCashServiceLogMapper gCashServiceLogMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GCashFeeTierResponse> getAllFeeTiers() {
        return gcashFeeTierRepository.findAll()
                .stream()
                .map(gCashFeeTierMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public GCashFeeTierResponse createFeeTier(GCashFeeTierRequest request) {
        if (gcashFeeTierRepository.existsByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(request.getMaxAmount(), request.getMinAmount())) {
            throw new BusinessRuleException("Fee tier with overlapping amount range already exists.");
        }

        GCashFeeTier gCashFeeTier = gcashFeeTierRepository.save(gCashFeeTierMapper.toEntity(request));

        return gCashFeeTierMapper.toResponse(gCashFeeTier);
    }

    @Override
    @Transactional
    public GCashFeeTierResponse updateFeeTier(Long id, GCashFeeTierRequest request) {
        GCashFeeTier gCashFeeTier = gcashFeeTierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee tier not found with id: " + id));

        if (gcashFeeTierRepository.existsByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndIdNot(request.getMaxAmount(), request.getMinAmount(), id)) {
            throw new BusinessRuleException("Fee tier with overlapping amount range already exists.");
        }

        gCashFeeTier.setMinAmount(request.getMinAmount());
        gCashFeeTier.setMaxAmount(request.getMaxAmount());
        gCashFeeTier.setFee(request.getFee());

        gcashFeeTierRepository.save(gCashFeeTier);

        return gCashFeeTierMapper.toResponse(gCashFeeTier);
    }

    @Override
    @Transactional
    public void deleteFeeTier(Long id) {
        gcashFeeTierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee tier not found with id: " + id));
        gcashFeeTierRepository.deleteById(id);
    }

    @Override
    @Transactional
    public GCashServiceLogResponse createServiceLog(GCashServiceLogRequest request) {
        Customer customer;

        if (request.getCustomerId() != null) {
            customer = customerRepository.findByIdAndActiveTrue(request.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + request.getCustomerId()));
        } else {
            customer = null;
        }

        if (customer == null && (request.getRepresentativeName() == null || request.getRepresentativeName().isBlank())) {
            throw new BusinessRuleException("Either customer ID or representative name must be provided.");
        }

        BigDecimal gCashTierFee = gcashFeeTierRepository.findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqual(
                        request.getAmount(),
                        request.getAmount())
                .orElseThrow(() -> new BusinessRuleException("No fee tier found for the specified amount: " + request.getAmount()))
                .getFee();

        GCashServiceLog gCashServiceLog = gCashServiceLogRepository.save(gCashServiceLogMapper.toEntity(request, customer, gCashTierFee));

        return gCashServiceLogMapper.toResponse(gCashServiceLog);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GCashServiceLogResponse> getAllServiceLogs(Pageable pageable) {
        return gCashServiceLogRepository.findAll(pageable)
                .map(gCashServiceLogMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public GCashServiceLogResponse findServiceLogById(Long id) {
        return gCashServiceLogRepository.findById(id)
                .map(gCashServiceLogMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Service log not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GCashServiceLogResponse> getCustomerGCashHistory(Long customerId, Pageable pageable) {
        customerRepository.findByIdAndActiveTrue(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        return gCashServiceLogRepository.findAllByCustomerId(customerId, pageable)
                .map(gCashServiceLogMapper::toResponse);
    }

    @Override
    public Page<GCashServiceLogResponse> search(String query, Pageable pageable) {
        if (query == null || query.isBlank()) {
            return Page.empty(pageable);
        }

        Page<GCashServiceLog> serviceLogs = gCashServiceLogRepository.search(query.trim(), pageable);

        return serviceLogs.map(gCashServiceLogMapper::toResponse);
    }
}
