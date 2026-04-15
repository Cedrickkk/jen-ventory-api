package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.customer.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.customer.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.customer.entity.Customer;
import com.jenventory.jenventoryapi.customer.mapper.CustomerMapper;
import com.jenventory.jenventoryapi.customer.repository.CustomerRepository;
import com.jenventory.jenventoryapi.customer.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    // ──────────────────────────────────────────────
    // Helper builders
    // ──────────────────────────────────────────────

    private CustomerRequest buildCustomerRequest() {
        return CustomerRequest.builder()
                .name("Maria Santos")
                .phone("09171234567")
                .address("123 Rizal St, Manila")
                .build();
    }

    private Customer buildCustomerEntity(Long id) {
        return Customer.builder()
                .id(id)
                .name("Maria Santos")
                .phone("09171234567")
                .address("123 Rizal St, Manila")
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    private CustomerResponse buildCustomerResponse(Long id) {
        return CustomerResponse.builder()
                .id(id)
                .name("Maria Santos")
                .phone("09171234567")
                .address("123 Rizal St, Manila")
                .active(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    // ──────────────────────────────────────────────
    // create() tests
    // ──────────────────────────────────────────────

    @Test
    void create_validRequest_returnsCustomerResponse() {
        // given
        CustomerRequest request = buildCustomerRequest();
        Customer entity = buildCustomerEntity(null);
        Customer savedEntity = buildCustomerEntity(1L);
        CustomerResponse expectedResponse = buildCustomerResponse(1L);

        given(customerMapper.toEntity(request)).willReturn(entity);
        given(customerRepository.save(entity)).willReturn(savedEntity);
        given(customerMapper.toResponse(savedEntity)).willReturn(expectedResponse);

        // when
        CustomerResponse response = customerService.create(request, null);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("Maria Santos");
        assertThat(response.getPhone()).isEqualTo("09171234567");
        assertThat(response.getAddress()).isEqualTo("123 Rizal St, Manila");
        assertThat(response.isActive()).isTrue();

        verify(customerMapper, times(1)).toEntity(request);
        verify(customerRepository, times(1)).save(entity);
        verify(customerMapper, times(1)).toResponse(savedEntity);
    }

    @Test
    void create_validRequest_verifiesSaveCalledOnce() {
        // given
        CustomerRequest request = buildCustomerRequest();
        Customer entity = buildCustomerEntity(null);
        Customer savedEntity = buildCustomerEntity(1L);

        given(customerMapper.toEntity(request)).willReturn(entity);
        given(customerRepository.save(entity)).willReturn(savedEntity);
        given(customerMapper.toResponse(savedEntity)).willReturn(buildCustomerResponse(1L));

        // when
        customerService.create(request, null);

        // then
        verify(customerRepository, times(1)).save(any(Customer.class));
        verifyNoMoreInteractions(customerRepository);
    }

    // ──────────────────────────────────────────────
    // getAll() tests
    // ──────────────────────────────────────────────

    @Test
    void getAll_withActiveCustomers_returnsPagedResults() {
        // given
        Pageable pageable = PageRequest.of(0, 20);
        Customer customer1 = buildCustomerEntity(1L);
        Customer customer2 = buildCustomerEntity(2L);
        customer2.setName("Juan Dela Cruz");
        customer2.setPhone("09181234567");

        List<Customer> customers = List.of(customer1, customer2);
        Page<Customer> customerPage = new PageImpl<>(customers, pageable, customers.size());

        CustomerResponse response1 = buildCustomerResponse(1L);
        CustomerResponse response2 = buildCustomerResponse(2L);
        response2.setName("Juan Dela Cruz");
        response2.setPhone("09181234567");

        given(customerRepository.findAllByActiveTrue(pageable)).willReturn(customerPage);
        given(customerMapper.toResponse(customer1)).willReturn(response1);
        given(customerMapper.toResponse(customer2)).willReturn(response2);

        // when
        Page<CustomerResponse> result = customerService.getAll(pageable);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getTotalElements()).isEqualTo(2);
        assertThat(result.getContent().get(0).getName()).isEqualTo("Maria Santos");
        assertThat(result.getContent().get(1).getName()).isEqualTo("Juan Dela Cruz");

        verify(customerRepository, times(2)).findAllByActiveTrue(pageable);
    }

    @Test
    void getAll_noActiveCustomers_returnsEmptyPage() {
        // given
        Pageable pageable = PageRequest.of(0, 20);
        Page<Customer> emptyPage = new PageImpl<>(List.of(), pageable, 0);

        given(customerRepository.findAllByActiveTrue(pageable)).willReturn(emptyPage);

        // when
        Page<CustomerResponse> result = customerService.getAll(pageable);

        // then
        assertThat(result).isNotNull();
        assertThat(result.getContent()).isEmpty();
        assertThat(result.getTotalElements()).isZero();
    }

    @Test
    void getAll_paginationSecondPage_returnsCorrectPage() {
        // given
        Pageable pageable = PageRequest.of(1, 1);
        Customer customer = buildCustomerEntity(2L);

        Page<Customer> customerPage = new PageImpl<>(List.of(customer), pageable, 3);
        CustomerResponse response = buildCustomerResponse(2L);

        given(customerRepository.findAllByActiveTrue(pageable)).willReturn(customerPage);
        given(customerMapper.toResponse(customer)).willReturn(response);

        // when
        Page<CustomerResponse> result = customerService.getAll(pageable);

        // then
        assertThat(result.getContent()).hasSize(1);
        assertThat(result.getNumber()).isEqualTo(1);
        assertThat(result.getTotalElements()).isEqualTo(3);
    }

    // ──────────────────────────────────────────────
    // findById() tests
    // ──────────────────────────────────────────────
    // Note: findById() currently returns null (not yet implemented).
    // Tests below document expected behavior for when implementation is complete.

    @Test
    void findById_notImplemented_returnsNull() {
        // given / when
        CustomerResponse response = customerService.findById(1L);

        // then
        assertThat(response).isNull();

        verifyNoInteractions(customerRepository);
        verifyNoInteractions(customerMapper);
    }

    // ──────────────────────────────────────────────
    // search() tests
    // ──────────────────────────────────────────────
    // Note: search() currently returns empty list (not yet implemented).

    @Test
    void search_notImplemented_returnsEmptyList() {
        // given / when
        List<CustomerResponse> result = customerService.search("Maria");

        // then
        assertThat(result).isEmpty();

        verifyNoInteractions(customerRepository);
        verifyNoInteractions(customerMapper);
    }

    // ──────────────────────────────────────────────
    // update() tests
    // ──────────────────────────────────────────────
    // Note: update() currently returns null (not yet implemented).

    @Test
    void update_notImplemented_returnsNull() {
        // given
        CustomerRequest request = buildCustomerRequest();

        // when
        CustomerResponse response = customerService.update(1L, request);

        // then
        assertThat(response).isNull();

        verifyNoInteractions(customerRepository);
        verifyNoInteractions(customerMapper);
    }

    // ──────────────────────────────────────────────
    // deactivate() tests
    // ──────────────────────────────────────────────
    // Note: deactivate() currently has no implementation (empty body).

    @Test
    void deactivate_notImplemented_noInteractions() {
        // given / when
        customerService.deactivate(1L);

        // then
        verifyNoInteractions(customerRepository);
    }

    // ──────────────────────────────────────────────
    // reactivate() tests
    // ──────────────────────────────────────────────
    // Note: reactivate() currently has no implementation (empty body).

    @Test
    void reactivate_notImplemented_noInteractions() {
        // given / when
        customerService.reactivate(1L);

        // then
        verifyNoInteractions(customerRepository);
    }
}

