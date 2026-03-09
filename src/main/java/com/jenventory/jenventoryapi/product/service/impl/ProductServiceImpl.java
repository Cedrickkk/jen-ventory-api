package com.jenventory.jenventoryapi.product.service.impl;

import com.jenventory.jenventoryapi.common.exception.DuplicateResourceException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.product.dto.request.ProductRequest;
import com.jenventory.jenventoryapi.product.dto.response.ProductResponse;
import com.jenventory.jenventoryapi.product.entity.Product;
import com.jenventory.jenventoryapi.product.mapper.ProductMapper;
import com.jenventory.jenventoryapi.product.repository.ProductRepository;
import com.jenventory.jenventoryapi.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<ProductResponse> getAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse create(ProductRequest request) {
        if (productRepository.existsByName(request.getName())) {
            throw new DuplicateResourceException("Product with name " + request.getName() + " already exists.");
        }

        Product product = productRepository.save(productMapper.toEntity(request));

        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        if (productRepository.existsByNameAndIdNot(request.getName(), id)) {
            throw new DuplicateResourceException("Product with name " + request.getName() + " already exists.");
        }

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        productRepository.save(product);

        return productMapper.toResponse(product);
    }


    @Override
    @Transactional
    public void deactivate(Long id) {
        Product product = productRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Active product not found with id: " + id));

        product.setActive(false);

        productRepository.save(product);
    }

    @Override
    @Transactional
    public ProductResponse reactivate(Long id) {
        Product product = productRepository.findByIdAndActiveFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inactive product not found with id: " + id));

        product.setActive(true);
        productRepository.save(product);

        return productMapper.toResponse(product);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> search(String query) {
        if (query.isBlank()) {
            return List.of();
        }

        List<Product> products = productRepository.search(query);

        return products.stream()
                .map(productMapper::toResponse)
                .toList();
    }

}
