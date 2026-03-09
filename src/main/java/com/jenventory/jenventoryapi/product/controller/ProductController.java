package com.jenventory.jenventoryapi.product.controller;

import com.jenventory.jenventoryapi.dto.response.ApiResponseUtil;
import com.jenventory.jenventoryapi.dto.response.SuccessApiResponse;
import com.jenventory.jenventoryapi.product.dto.request.ProductRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductResponse;
import com.jenventory.jenventoryapi.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<SuccessApiResponse<Page<ProductResponse>>> getAll(Pageable pageable) {
        Page<ProductResponse> paginatedProducts = productService.getAll(pageable);

        SuccessApiResponse<Page<ProductResponse>> response =
                ApiResponseUtil.success(paginatedProducts, "Products retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<ProductResponse>> getById(@PathVariable Long id) {
        ProductResponse productResponse = productService.findById(id);

        SuccessApiResponse<ProductResponse> response =
                ApiResponseUtil.success(productResponse, "Product retrieved successfully");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<SuccessApiResponse<ProductResponse>> create(
            @Valid @RequestBody ProductRequest request) {

        ProductResponse productResponse = productService.create(request);

        SuccessApiResponse<ProductResponse> response =
                ApiResponseUtil.created(productResponse, "Product created successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<ProductResponse>> update(
            @PathVariable Long id, @Valid @RequestBody ProductRequest request) {

        ProductResponse product = productService.update(id, request);

        SuccessApiResponse<ProductResponse> response =
                ApiResponseUtil.success(product, "Product updated successfully");

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessApiResponse<Void>> delete(@PathVariable Long id) {
        productService.deactivate(id);

        SuccessApiResponse<Void> response = ApiResponseUtil.noContent("Product deactivated successfully");

        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{id}/reactivate")
    public ResponseEntity<SuccessApiResponse<ProductResponse>> reactivate(@PathVariable Long id) {
        ProductResponse product = productService.reactivate(id);

        SuccessApiResponse<ProductResponse> response =
                ApiResponseUtil.success(product, "Product reactivated successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<SuccessApiResponse<List<ProductResponse>>> search(
            @RequestParam(name = "query", required = false, defaultValue = "") String query) {

        List<ProductResponse> products = productService.search(query);

        SuccessApiResponse<List<ProductResponse>> response =
                ApiResponseUtil.success(products, "Result for search query: " + query);

        return ResponseEntity.ok(response);
    }

}
