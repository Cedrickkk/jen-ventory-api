package com.jenventory.jenventoryapi.customer.service.impl;

import com.jenventory.jenventoryapi.common.exception.DuplicateResourceException;
import com.jenventory.jenventoryapi.common.exception.ResourceNotFoundException;
import com.jenventory.jenventoryapi.customer.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.customer.mapper.CustomerMapper;
import com.jenventory.jenventoryapi.customer.repository.CustomerRepository;
import com.jenventory.jenventoryapi.customer.service.CustomerService;
import com.jenventory.jenventoryapi.file.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final StorageService storageService;


    @Override
    @Transactional(readOnly = true)
    public Page<CustomerResponse> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable)
                .map(customerMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResponse findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        return customerMapper.toResponse(customer);
    }


    @Override
    @Transactional
    public CustomerResponse create(CustomerRequest request, MultipartFile image) {
        if (customerRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException("Customer with phone number " + request.getPhone() + " already exists.");
        }

        Customer _customer = customerMapper.toEntity(request);

        Customer customer = customerRepository.save(_customer);

        storageService.store(image);

        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponse update(Long id, CustomerRequest request) {
        Customer customer = customerRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        if (customerRepository.existsByPhoneAndIdNot(request.getPhone(), id)) {
            throw new DuplicateResourceException("Customer with phone number " + request.getPhone() + " already exists.");
        }

        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());

        customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponse deactivate(Long id) {
        Customer customer = customerRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResourceNotFoundException("Active customer not found with id: " + id));

        customer.setActive(false);
        customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional
    public CustomerResponse reactivate(Long id) {
        Customer customer = customerRepository.findByIdAndActiveFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inactive customer not found with id: " + id));

        customer.setActive(true);
        customerRepository.save(customer);

        return customerMapper.toResponse(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResponse> search(String query) {
        if (query.isBlank()) {
            return List.of();
        }

        List<Customer> customers = customerRepository.search(query);

        return customers.stream()
                .map(customerMapper::toResponse)
                .toList();
    }


}
