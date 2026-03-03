package com.jenventory.jenventoryapi.repository;

import com.jenventory.jenventoryapi.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findAllByIsActiveTrue(Pageable pageable);

    Optional<Customer> findByIdAndIsActiveTrue(Long id);

    Optional<Customer> findByPhoneAndIsActiveTrue(String phone);

    List<Customer> findByNameContainingIgnoreCaseAndIsActiveTrue(String name);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndIsActiveTrue(String phone);

}
