package com.jenventory.jenventoryapi.product.service.impl;

import com.jenventory.jenventoryapi.common.exception.DuplicateResourceException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.file.entity.File;
import com.jenventory.jenventoryapi.file.enums.FileType;
import com.jenventory.jenventoryapi.file.service.FileService;
import com.jenventory.jenventoryapi.product.dto.request.ProductVariantRequest;
import com.jenventory.jenventoryapi.product.dto.request.ProductVariantUpdateRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductVariantResponse;
import com.jenventory.jenventoryapi.product.entity.Product;
import com.jenventory.jenventoryapi.product.entity.ProductVariant;
import com.jenventory.jenventoryapi.product.mapper.ProductVariantMapper;
import com.jenventory.jenventoryapi.product.repository.ProductRepository;
import com.jenventory.jenventoryapi.product.repository.ProductVariantRepository;
import com.jenventory.jenventoryapi.product.service.ProductVariantService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;
    private final ProductVariantMapper productVariantMapper;
    private final ProductRepository productRepository;
    private final FileService fileService;

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
    public ProductVariantResponse create(Long productId, ProductVariantRequest request, @Nullable MultipartFile image) {
        Product product = productRepository.findByIdAndActiveTrue(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));

        if (productVariantRepository.existsBySku(request.getSku())) {
            throw new DuplicateResourceException("Product variant with sku " + request.getSku() + " already exists.");
        }

        ProductVariant productVariant = productVariantMapper.toEntity(request, product);

        productVariantRepository.save(productVariant);

        if (image != null && !image.isEmpty()) {
            File imageFile = fileService.create(image, FileType.IMAGE);
            productVariant.setImage(imageFile);
        }

        return productVariantMapper.toResponse(productVariant);
    }

    @Override
    @Transactional
    public ProductVariantResponse update(Long id, ProductVariantUpdateRequest request) {
        ProductVariant productVariant = productVariantRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product variant not found with id: " + id));

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
