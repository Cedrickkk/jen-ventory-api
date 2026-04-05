package com.jenventory.jenventoryapi.product.repository;

import com.jenventory.jenventoryapi.product.entity.Product;

public interface ProductWithVariantCount {
    Product getProduct();

    Long getVariantCount();
}
