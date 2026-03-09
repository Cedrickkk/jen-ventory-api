package com.jenventory.jenventoryapi.customer.service;

import com.jenventory.jenventoryapi.customer.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerResponse create(CustomerRequest request);

    CustomerResponse findById(Long id);

    Page<CustomerResponse> getAll(Pageable pageable);

    List<CustomerResponse> search(String query);

    CustomerResponse update(Long id, CustomerRequest request);

    void deactivate(Long id);

    CustomerResponse reactivate(Long id);
}
