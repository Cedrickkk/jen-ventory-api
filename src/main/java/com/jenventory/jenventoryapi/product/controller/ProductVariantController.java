package com.jenventory.jenventoryapi.product.controller;

import com.jenventory.jenventoryapi.common.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.common.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.product.dto.request.*;
import com.jenventory.jenventoryapi.product.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.product.dto.response.StockMovementResponse;
import com.jenventory.jenventoryapi.product.enums.StockMovementReason;
import com.jenventory.jenventoryapi.product.service.ProductVariantService;
import com.jenventory.jenventoryapi.product.service.StockMovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/{productId}/variants")
@RequiredArgsConstructor
public class ProductVariantController {

    private final ProductVariantService productVariantService;
    private final StockMovementService stockMovementService;

    @GetMapping
    public ResponseEntity<SuccessApiResponse<Page<ProductVariantResponse>>> getAll(
            @PathVariable Long productId, Pageable pageable) {

        Page<ProductVariantResponse> paginatedProductVariants = productVariantService.getAll(productId, pageable);

        SuccessApiResponse<Page<ProductVariantResponse>> response =
                ApiResponseUtil.success(paginatedProductVariants, "Product variants for product id: " + productId + " retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> create(
            @PathVariable Long productId, @Valid @RequestBody ProductVariantRequest request) {

        ProductVariantResponse productVariantResponse = productVariantService.create(productId, request);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.created(productVariantResponse, "Product variant created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> getById(@PathVariable Long productId, @PathVariable Long id) {
        ProductVariantResponse productResponse = productVariantService.findById(id);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(productResponse, "Product variant retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> update(
            @PathVariable Long productId, @PathVariable Long id, @Valid @RequestBody ProductVariantUpdateRequest request) {

        ProductVariantResponse product = productVariantService.update(id, request);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(product, "Product variant updated successfully");

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<Void>> delete(@PathVariable Long productId, @PathVariable Long id) {
        productVariantService.deactivate(productId, id);

        SuccessApiResponse<Void> response = ApiResponseUtil.noContent("Product variant deactivated successfully");

        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}/reactivate")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> reactivate(@PathVariable Long productId, @PathVariable Long id) {
        ProductVariantResponse product = productVariantService.reactivate(productId, id);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(product, "Product variant reactivated successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/restock")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> restock(
            @PathVariable Long productId, @PathVariable Long id, @Valid @RequestBody RestockRequest request) {

        ProductVariantResponse productVariantResponse = stockMovementService.restock(id, request);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(productVariantResponse, "Product variant restocked successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/adjustment")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> adjustment(
            @PathVariable Long productId, @PathVariable Long id, @Valid @RequestBody AdjustmentRequest request) {

        ProductVariantResponse productVariantResponse = stockMovementService.adjust(id, request);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(productVariantResponse, "Product variant adjusted successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<SuccessApiResponse<ProductVariantResponse>> processReturn(
            @PathVariable Long productId, @PathVariable Long id, @Valid @RequestBody ReturnRequest request) {

        ProductVariantResponse productVariantResponse = stockMovementService.processReturn(id, request);

        SuccessApiResponse<ProductVariantResponse> response =
                ApiResponseUtil.success(productVariantResponse, "Product variant returned successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/stock-movements")
    public ResponseEntity<SuccessApiResponse<Page<StockMovementResponse>>> getStockMovements(
            @PathVariable Long productId, @PathVariable Long id,
            @RequestParam(name = "reason", required = false) StockMovementReason reason, Pageable pageable) {
        Page<StockMovementResponse> stockMovementResponse = stockMovementService.getMovements(id, reason, pageable);

        SuccessApiResponse<Page<StockMovementResponse>> response =
                ApiResponseUtil.success(stockMovementResponse, "Stock movements for product variant id: " + id + " retrieved successfully");

        return ResponseEntity.ok(response);
    }

}
