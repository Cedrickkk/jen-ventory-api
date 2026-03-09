package com.jenventory.jenventoryapi.product.service;

import com.jenventory.jenventoryapi.product.dto.request.AdjustmentRequest;
import com.jenventory.jenventoryapi.product.dto.request.RestockRequest;
import com.jenventory.jenventoryapi.product.dto.request.ReturnRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.product.dto.response.StockMovementResponse;
import com.jenventory.jenventoryapi.product.enums.StockMovementReason;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockMovementService {

    ProductVariantResponse restock(Long variantId, RestockRequest request);

    ProductVariantResponse adjust(Long variantId, AdjustmentRequest request);

    ProductVariantResponse processReturn(Long variantId, ReturnRequest request);

    Page<StockMovementResponse> getMovements(Long variantId, StockMovementReason reason, Pageable pageable);

}
