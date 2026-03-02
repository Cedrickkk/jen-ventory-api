---
applyTo: '**'
description: 'description'
---
## DTO & Validation Standards for Sari-Sari Store API

When generating or modifying DTO classes, always follow these rules.

### Naming Conventions
| Purpose | Naming Pattern | Example |
|---|---|---|
| Create request | `Create{Entity}Dto` | `CreateProductDto` |
| Update request | `Update{Entity}Dto` | `UpdateProductDto` |
| Response/read | `{Entity}Dto` | `ProductDto` |
| Nested/summary | `{Entity}SummaryDto` | `CustomerSummaryDto` |

### DTO Structure (use Java Records for immutable DTOs where possible)
```java
// Response DTO — use record for immutability
public record ProductDto(
    Long id,
    String name,
    String unit,
    BigDecimal currentPrice,
    int stockQuantity,
    int lowStockThreshold,
    boolean active,
    boolean isLowStock,       // derived field — computed in mapper
    LocalDateTime createdAt
) {}

// Request DTO — use class with Bean Validation annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDto {

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Unit is required")
    private String unit;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 8, fraction = 2, message = "Invalid price format")
    private BigDecimal currentPrice;

    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stockQuantity;

    @Min(value = 0, message = "Low stock threshold cannot be negative")
    private int lowStockThreshold;
}
```

### Bean Validation Annotations by Field Type
```java
// Strings
@NotBlank(message = "Field is required")
@Size(min = 2, max = 100, message = "...")

// Numbers (monetary)
@NotNull
@DecimalMin(value = "0.01")
@Digits(integer = 8, fraction = 2)
private BigDecimal amount;

// Numbers (quantities)
@Min(value = 1, message = "Quantity must be at least 1")
@Max(value = 9999)
private int quantity;

// IDs (foreign keys in request body)
@NotNull(message = "Customer ID is required")
@Positive(message = "Customer ID must be a positive number")
private Long customerId;

// Enums
@NotNull
private TransactionType type;

// Lists
@NotEmpty(message = "At least one item is required")
@Valid  // validate each element in the list
private List<TransactionItemDto> items;
```

### Checkout Request DTO (most critical)
```java
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CheckoutRequestDto {

    @NotNull(message = "Payment type is required")
    private TransactionType type;           // CASH or DEBT

    // Required only when type = DEBT
    private Long customerId;

    @NotEmpty(message = "At least one item is required")
    @Valid
    private List<CheckoutItemDto> items;
}

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CheckoutItemDto {

    @NotNull @Positive
    private Long productId;

    @Min(1) @Max(999)
    private int quantity;
}
```

### Payment Request DTO
```java
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentRequestDto {

    @NotNull
    @DecimalMin(value = "0.01", message = "Payment amount must be greater than zero")
    @Digits(integer = 8, fraction = 2)
    private BigDecimal amount;

    private String notes;   // optional, e.g. "partial payment"
}
```

### Mapper Pattern (Manual or MapStruct)
```java
// Manual mapper example
@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getUnit(),
            product.getCurrentPrice(),
            product.getStockQuantity(),
            product.getLowStockThreshold(),
            product.isActive(),
            product.getStockQuantity() <= product.getLowStockThreshold(),  // derived
            product.getCreatedAt()
        );
    }
}
```

### What to Avoid
- Exposing JPA entities directly in API responses
- Using `double` or `float` in DTOs for monetary fields — always `BigDecimal`
- Missing `@Valid` on nested DTO lists — each element won't be validated
- `@Data` on request DTOs used with Jackson — can cause issues; prefer explicit `@Getter @Setter`
- Business logic inside DTOs or mappers
- Reusing the same DTO for both create and update if their validation rules differ