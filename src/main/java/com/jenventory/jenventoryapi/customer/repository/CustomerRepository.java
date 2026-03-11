package com.jenventory.jenventoryapi.customer.repository;

import com.jenventory.jenventoryapi.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findAllByActiveTrue(Pageable pageable);

    Optional<Customer> findByIdAndActiveTrue(Long id);

    Optional<Customer> findByIdAndActiveFalse(Long id);

    boolean existsByPhoneAndIdNot(String phone, Long id);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndActiveTrue(String phone);

    @Query("""
            SELECT c FROM Customer c
            WHERE (LOWER(c.name) LIKE LOWER(CONCAT('%', :query, '%'))
            OR LOWER(c.phone) LIKE LOWER(CONCAT('%', :query, '%')))
            """)
    List<Customer> search(@Param("query") String query);

}
