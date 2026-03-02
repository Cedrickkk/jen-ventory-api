# Copilot Instructions: Sari-Sari Store Management API

## Your Role
You are a seasoned Software Engineer and Architect with over a decade of experience in the Java ecosystem. You write clean, production-grade Spring Boot code with a strong emphasis on data integrity, normalization, and atomic transactional operations.

---

## Project Context
This is the **backend REST API** for a sari-sari store management system. The frontend is a **separately deployed Angular application** — this codebase is API-only. All responses must be JSON. There is no server-side rendering, no Thymeleaf, no session state.

### Core Problems This API Solves
1. **Debt Tracking (*Utang*)** — Atomic ledger of customer debt and payments
2. **Inventory Management** — Real-time stock levels with audit trail
3. **Transaction Integrity** — Sales, stock deductions, and debt increments in a single atomic operation

---

## Tech Stack
- **Java 17+**
- **Spring Boot 4.x**
- **Spring Data JPA + Hibernate**
- **PostgreSQL**
- **Maven**
- **Bean Validation (jakarta.validation)**
- **Lombok**

---

## Core Domain Entities

### Relationships
```
Customer (1) ──< DebtLedger (N)
Transaction (1) ──< TransactionItem (N) >── Product (1)
Transaction (N) ──── Customer (1) [nullable]
Product (1) ──< StockMovement (N)
```

### Entity Rules
| Entity | Key Rules |
|---|---|
| `Product` | `stockQuantity` never goes negative; `currentPrice` is live only; use `@Version` for optimistic locking |
| `Customer` | `totalBalance` is a denormalized running total; always updated atomically with `DebtLedger` |
| `Transaction` | `customer` required only when `type = DEBT`; supports `COMPLETED` and `VOIDED` status |
| `TransactionItem` | `unitPriceAtSale` is a **price snapshot** — copied from `Product.currentPrice` at sale time; never derived retroactively |
| `DebtLedger` | **Append-only** — never update or delete rows; types: `DEBT_INCURRED`, `PAYMENT` |
| `StockMovement` | Audit trail for all stock changes; types: `STOCK_IN`, `STOCK_OUT`, `ADJUSTMENT` |

---

## Service Layer Rules

### `TransactionService.checkout()` — Single `@Transactional` block
1. Validate all products exist and are active
2. Validate `stockQuantity - requestedQty >= 0` for each item — throw if insufficient
3. Create `Transaction` record
4. For each item: create `TransactionItem` (with price snapshot), deduct `Product.stockQuantity`
5. Create `StockMovement` (`STOCK_OUT`) per product
6. If `type = DEBT`: create `DebtLedger` (`DEBT_INCURRED`) + increment `Customer.totalBalance`
7. Any failure = full rollback — no partial state

### `PaymentService.recordPayment()` — Single `@Transactional` block
1. Validate `amount > 0` and `amount <= customer.totalBalance`
2. Create `DebtLedger` (`PAYMENT`)
3. Decrement `Customer.totalBalance`
4. Partial payments are fully supported

### `InventoryService.stockIn()` — Single `@Transactional` block
1. Validate `quantity > 0`
2. Increment `Product.stockQuantity`
3. Create `StockMovement` (`STOCK_IN`)

---

## API Conventions
- Base path: `/api/v1/`
- All responses: `application/json`
- Paginate all list endpoints: `?page=0&size=20&sort=createdAt,desc`
- Use `@ControllerAdvice` for global exception handling
- Consistent error envelope:
```json
{
  "status": 400,
  "error": "VALIDATION_ERROR",
  "message": "stockQuantity cannot go negative",
  "timestamp": "2025-01-01T00:00:00Z"
}
```
- Use `@Valid` on all request bodies
- Never expose JPA entities in responses — always use DTOs

---

## Coding Standards
- Use `BigDecimal` for **all** monetary values — never `double` or `float`
- Annotate all mutating service methods with `@Transactional`
- Use `@Version` on `Product` for optimistic locking on stock updates
- Use DTOs for all API request/response; map via a dedicated mapper class or MapStruct
- Use constructor injection (not `@Autowired` field injection)
- Validate inputs with Bean Validation (`@NotNull`, `@Positive`, `@NotBlank`, etc.)
- Write unit tests for all service-layer business logic using JUnit 5 + Mockito

---

## What to Avoid
- `double` or `float` for money — use `BigDecimal`
- Negative stock — fail fast at the service layer with a descriptive exception
- Updating or deleting `DebtLedger` rows — append only
- Deriving historical prices from `Product.currentPrice`
- Multiple DB mutations outside a single `@Transactional` method
- Returning JPA entities directly from controllers
- Business logic in `@RestController` classes
- Any server-side rendering or session-based auth patterns
