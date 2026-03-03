package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.dto.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerResponse create(CustomerRequest customer);

    CustomerResponse findById(Long id);

    Page<CustomerResponse> getAll(Pageable pageable);

    List<CustomerResponse> search(String name);

    CustomerResponse update(Long id, CustomerRequest customer);

    void deactivate(Long id);

    void reactivate(Long id);
}
