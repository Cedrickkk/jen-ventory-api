package com.jenventory.jenventoryapi.service.impl;

import com.jenventory.jenventoryapi.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.entity.Customer;
import com.jenventory.jenventoryapi.mapper.CustomerMapper;
import com.jenventory.jenventoryapi.repository.CustomerRepository;
import com.jenventory.jenventoryapi.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse findById(Long id) {
        return null;
    }

    @Override
    public Page<CustomerResponse> getAll(Pageable pageable) {
        Page<Customer> allByIsActiveTrue = customerRepository.findAllByIsActiveTrue(pageable);

        log.info("Retrieved {} active customers", allByIsActiveTrue.getContent());

        return customerRepository.findAllByIsActiveTrue(pageable)
                .map(customerMapper::toResponse);
    }

    @Transactional
    @Override
    public CustomerResponse create(CustomerRequest request) {
        log.info("Creating customer with request: {}", request);

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public List<CustomerResponse> search(String name) {
        return List.of();
    }

    @Override
    public CustomerResponse update(Long id, CustomerRequest customer) {
        return null;
    }

    @Override
    public void deactivate(Long id) {

    }

    @Override
    public void reactivate(Long id) {

    }
}
