package com.jenventory.jenventoryapi.mapper;

import com.jenventory.jenventoryapi.dto.request.CustomerRequest;
import com.jenventory.jenventoryapi.dto.response.CustomerResponse;
import com.jenventory.jenventoryapi.dto.response.CustomerTransactionResponse;
import com.jenventory.jenventoryapi.entity.Customer;
import com.jenventory.jenventoryapi.entity.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();
    }

    public CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .active(customer.isActive())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }

    public CustomerTransactionResponse toTransactionResponse(
            Transaction transaction, BigDecimal amountPaid,
            BigDecimal debtAmount, BigDecimal creditAmount) {
        return CustomerTransactionResponse.builder()
                .id(transaction.getId())
                .representative(transaction.getRepresentative())
                .totalAmount(transaction.getTotalAmount())
                .amountPaid(amountPaid)
                .debtAmount(debtAmount)
                .creditAmount(creditAmount)
                .itemCount(transaction.getItems().size())
                .build();
    }

}


