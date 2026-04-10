package com.jenventory.jenventoryapi.product.service;

import com.jenventory.jenventoryapi.product.dto.request.ProductVariantRequest;
import com.jenventory.jenventoryapi.product.dto.request.ProductVariantUpdateRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductVariantResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductVariantService {

    ProductVariantResponse create(Long productId, ProductVariantRequest request);

    ProductVariantResponse findById(Long id);

    Page<ProductVariantResponse> getAll(Long productId, Pageable pageable);

    ProductVariantResponse update(Long id, ProductVariantUpdateRequest request);

    void deactivate(Long productId, Long id);

    ProductVariantResponse reactivate(Long productId, Long id);

}
