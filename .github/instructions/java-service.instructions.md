---
applyTo: '**/*Service.java, **/service/**/*.java'
---
## Service Layer Standards for Sari-Sari Store API

When generating or modifying Spring Boot service classes, always follow these rules:

### Class Structure
```java
@Service
@RequiredArgsConstructor
public class MyService {

    private final MyRepository myRepository;
    private final AnotherRepository anotherRepository;

    // methods...
}
```
- Always use `@Service`
- Always use **constructor injection** via `@RequiredArgsConstructor` (Lombok) — never `@Autowired` field injection
- One service class per domain aggregate (e.g., `TransactionService`, `PaymentService`, `InventoryService`)

### `@Transactional` Rules
```java
// Mutating operations — always transactional
@Transactional
public TransactionResponseDto checkout(CheckoutRequestDto request) { }

@Transactional
public PaymentResponseDto recordPayment(Long customerId, PaymentRequestDto request) { }

// Read operations — use readOnly for performance
@Transactional(readOnly = true)
public Page<ProductDto> getAllProducts(Pageable pageable) { }
```
- **Every method that writes to the DB must be `@Transactional`**
- Read-only queries must use `@Transactional(readOnly = true)`
- Never split a multi-step write operation across multiple methods without a parent `@Transactional`

### Atomic Checkout Operation Pattern
The `checkout()` method is the most critical — it must do all of the following or nothing:
```java
@Transactional
public TransactionResponseDto checkout(CheckoutRequestDto request) {
    // 1. Validate products exist and are active
    // 2. Validate stock availability — throw InsufficientStockException if any item fails
    // 3. Persist Transaction
    // 4. For each item: persist TransactionItem (with price snapshot), deduct stock
    // 5. Persist StockMovement (STOCK_OUT) per product
    // 6. If DEBT: persist DebtLedger (DEBT_INCURRED), increment Customer.totalBalance
    // 7. Return mapped DTO
}
```

### Exception Handling
Create and throw specific domain exceptions — never throw raw `RuntimeException`:
```java
// Examples of custom exceptions to create/use
throw new InsufficientStockException("Product '" + product.getName() + "' has insufficient stock.");
throw new ResourceNotFoundException("Customer not found with id: " + id);
throw new InvalidPaymentException("Payment amount exceeds current balance.");
```
- Custom exceptions should extend `RuntimeException` so Spring rolls back `@Transactional` methods automatically
- Never catch and swallow exceptions inside a `@Transactional` method

### Input Validation
- Always validate DTOs before processing — use `@Valid` in controller; add business-rule checks in service
- For monetary operations, always check `amount.compareTo(BigDecimal.ZERO) > 0`
- For payments, check `amount.compareTo(customer.getTotalBalance()) <= 0`

### DebtLedger Rules (Append-Only)
```java
// CORRECT — always create new entry
DebtLedger entry = DebtLedger.builder()
    .customer(customer)
    .transaction(transaction)
    .type(DebtLedgerType.DEBT_INCURRED)
    .amount(transaction.getTotalAmount())
    .build();
debtLedgerRepository.save(entry);

// NEVER do this
debtLedgerRepository.deleteById(id);       
existingEntry.setAmount(newAmount);         
```

### Stock Guard Pattern
```java
private void validateStock(Product product, int requestedQty) {
    if (product.getStockQuantity() < requestedQty) {
        throw new InsufficientStockException(
            "Insufficient stock for '" + product.getName() + "'. " +
            "Available: " + product.getStockQuantity() + ", Requested: " + requestedQty
        );
    }
}
```

### What to Avoid
`@Transactional` on private methods — Spring AOP won't intercept them
- Multiple separate `@Transactional` calls in a controller for a single operation
- Catching `Exception` inside a `@Transactional` method without rethrowing
- Business logic in `@RestController` or `@Repository` classes
- Direct entity mutation outside of the service layer
