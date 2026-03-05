package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.dto.request.ProductRequest;
import com.jenventory.jenventoryapi.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest request);

    ProductResponse findById(Long id);

    Page<ProductResponse> getAll(Pageable pageable);

    List<ProductResponse> search(String query);

    ProductResponse update(Long id, ProductRequest request);

    void deactivate(Long id);

    ProductResponse reactivate(Long id);

}
