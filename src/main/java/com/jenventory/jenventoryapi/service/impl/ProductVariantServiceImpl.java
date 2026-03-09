package com.jenventory.jenventoryapi.service.impl;

import com.jenventory.jenventoryapi.common.exception.DuplicateResourceException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.dto.request.ProductVariantRequest;
import com.jenventory.jenventoryapi.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.entity.Product;
import com.jenventory.jenventoryapi.entity.ProductVariant;
import com.jenventory.jenventoryapi.mapper.ProductVariantMapper;
import com.jenventory.jenventoryapi.repository.ProductRepository;
import com.jenventory.jenventoryapi.repository.ProductVariantRepository;
import com.jenventory.jenventoryapi.service.ProductVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductVariantMapper productVariantMapper;
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductVariantResponse> getAll(Long productId, Pageable pageable) {
        return productVariantRepository.findAllByProductIdAndActiveTrue(productId, pageable)
                .map(productVariantMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductVariantResponse findById(Long id) {
        ProductVariant product = productVariantRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + id));

        return productVariantMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductVariantResponse create(Long productId, ProductVariantRequest request) {
        Product product = productRepository.findByIdAndActiveTrue(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        if (productVariantRepository.existsBySku(request.getSku())) {
            throw new DuplicateResourceException("Product variant with sku " + request.getSku() + " already exists.");
        }

        ProductVariant productVariant = productVariantMapper.toEntity(request, product);

        productVariantRepository.save(productVariant);

        return productVariantMapper.toResponse(productVariant);
    }

    @Override
    @Transactional
    public ProductVariantResponse update(Long id, ProductVariantRequest request) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + id));

        if (productVariantRepository.existsBySkuAndIdNot(request.getSku(), id)) {
            throw new DuplicateResourceException("Product variant with sku " + request.getSku() + " already exists.");
        }

        productVariant.setSku(request.getSku());
        productVariant.setPrice(request.getPrice());
        productVariant.setSize(request.getSize());
        productVariant.setFlavor(request.getFlavor());
        productVariant.setPackaging(request.getPackaging());

        productVariantRepository.save(productVariant);

        return productVariantMapper.toResponse(productVariant);
    }


    @Override
    @Transactional
    public void deactivate(Long productId, Long id) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Active product variant not found with id: " + id));

        validateVariantBelongsToProduct(productId, productVariant);
        productVariant.setActive(false);

        productVariantRepository.save(productVariant);
    }

    @Override
    @Transactional
    public ProductVariantResponse reactivate(Long productId, Long id) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Active product variant not found with id: " + id));

        validateVariantBelongsToProduct(productId, productVariant);
        productVariant.setActive(true);
        productVariantRepository.save(productVariant);

        return productVariantMapper.toResponse(productVariant);
    }

    private void validateVariantBelongsToProduct(Long productId, ProductVariant variant) {
        if (!variant.getProduct().getId().equals(productId)) {
            throw new ResourceNotFoundException("Product variant with id: " + variant.getId() + " does not belong to product with id: " + productId);
        }
    }
}
