package com.jenventory.jenventoryapi.service.impl;

import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.dto.request.AdjustmentRequest;
import com.jenventory.jenventoryapi.dto.request.RestockRequest;
import com.jenventory.jenventoryapi.dto.request.ReturnRequest;
import com.jenventory.jenventoryapi.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.dto.response.StockMovementResponse;
import com.jenventory.jenventoryapi.entity.ProductVariant;
import com.jenventory.jenventoryapi.entity.StockMovement;
import com.jenventory.jenventoryapi.enums.AdjustmentDirection;
import com.jenventory.jenventoryapi.enums.StockMovementReason;
import com.jenventory.jenventoryapi.mapper.ProductVariantMapper;
import com.jenventory.jenventoryapi.mapper.StockMovementMapper;
import com.jenventory.jenventoryapi.repository.ProductVariantRepository;
import com.jenventory.jenventoryapi.repository.StockMovementRepository;
import com.jenventory.jenventoryapi.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockMovementServiceImpl implements StockMovementService {

    private final ProductVariantRepository productVariantRepository;
    private final StockMovementRepository stockMovementRepository;
    private final ProductVariantMapper productVariantMapper;
    private final StockMovementMapper stockMovementMapper;

    @Override
    @Transactional
    public ProductVariantResponse restock(Long variantId, RestockRequest request) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(variantId)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + variantId));

        productVariant.addStock(request.getQuantity());
        productVariantRepository.save(productVariant);

        stockMovementRepository.save(StockMovement.builder()
                .variant(productVariant)
                .quantityChange(request.getQuantity())
                .reason(StockMovementReason.RESTOCK)
                .notes(request.getNotes())
                .build());

        return productVariantMapper.toResponse(productVariant);
    }

    @Override
    @Transactional
    public ProductVariantResponse adjust(Long variantId, AdjustmentRequest request) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(variantId)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + variantId));

        AdjustmentDirection direction = AdjustmentDirection.valueOf(request.getDirection());

        if (direction == AdjustmentDirection.DEDUCT) {
            productVariant.deductStock(request.getQuantity());
        } else {
            productVariant.addStock(request.getQuantity());
        }

        int signedQuantity = direction == AdjustmentDirection.DEDUCT
                ? -request.getQuantity()
                : request.getQuantity();

        productVariantRepository.save(productVariant);

        stockMovementRepository.save(StockMovement.builder()
                .variant(productVariant)
                .quantityChange(signedQuantity)
                .reason(StockMovementReason.ADJUSTMENT)
                .notes(request.getNotes())
                .build());

        return productVariantMapper.toResponse(productVariant);
    }

    @Override
    @Transactional
    public ProductVariantResponse processReturn(Long variantId, ReturnRequest request) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(variantId)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + variantId));

        productVariant.addStock(request.getQuantity());
        productVariantRepository.save(productVariant);

        stockMovementRepository.save(stockMovementMapper.toEntity(
                productVariant,
                null,
                StockMovementReason.RETURN,
                request.getQuantity(),
                request.getNotes())
        );

        return productVariantMapper.toResponse(productVariant);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StockMovementResponse> getMovements(Long variantId, StockMovementReason reason, Pageable pageable) {
        if (reason == null) {
            return stockMovementRepository.findAllByVariantId(variantId, pageable)
                    .map(stockMovementMapper::toResponse);
        }
        return stockMovementRepository.findAllByVariantIdAndReason(variantId, reason, pageable)
                .map(stockMovementMapper::toResponse);
    }
}
