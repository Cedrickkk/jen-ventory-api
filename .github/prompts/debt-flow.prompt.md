---
description: 'Explain the complete debt (utang) transaction flow or scaffold the full implementation including checkout, ledger entry, and payment recording.'
mode: 'ask'
---
This prompt covers the core business logic of the Sari-Sari Store: the **Debt (Utang) Flow**. Use this to either explain, debug, or implement any part of the debt lifecycle.

## Debt Lifecycle Overview

```
[Customer buys on credit]
        │
        ▼
TransactionService.checkout(type=DEBT)
        │
        ├─ Creates Transaction (type=DEBT, customer=X)
        ├─ Creates TransactionItem(s) with price snapshot
        ├─ Deducts Product.stockQuantity
        ├─ Creates StockMovement (STOCK_OUT)
        ├─ Creates DebtLedger (DEBT_INCURRED, amount=totalAmount)
        └─ Increments Customer.totalBalance += totalAmount
                │
                ▼
        [Customer's debt is now recorded]
                │
                ▼
PaymentService.recordPayment(customerId, amount)
        │
        ├─ Validates amount > 0 and amount <= customer.totalBalance
        ├─ Creates DebtLedger (PAYMENT, amount=paymentAmount)
        └─ Decrements Customer.totalBalance -= paymentAmount
                │
                ▼
        [Partial or full debt cleared]
```

---

## Task Options — Choose What You Need:

### Option A: Explain the Flow
Explain the complete debt flow end-to-end including:
- Why `DebtLedger` is append-only and why we never update/delete rows
- Why `Customer.totalBalance` is denormalized (not computed from ledger every time)
- How partial payments work and why the balance stays accurate
- Why the checkout and payment are separate `@Transactional` operations
- How `unitPriceAtSale` (price snapshot) protects historical records

### Option B: Scaffold the Full Implementation
Generate all code for the debt flow:
1. `DebtLedger` entity with `DEBT_INCURRED` and `PAYMENT` types
2. `DebtLedgerRepository` with queries: find by customer, sum by customer
3. `TransactionService.checkout()` — full atomic operation
4. `PaymentService.recordPayment()` — full atomic operation
5. `DebtLedgerController` — endpoints: get customer balance, get ledger history, post payment
6. DTOs: `CheckoutRequestDto`, `CheckoutResponseDto`, `PaymentRequestDto`, `DebtLedgerDto`, `CustomerBalanceDto`

### Option C: Debug or Fix an Issue
Describe the issue: [DESCRIBE_THE_BUG_OR_INCONSISTENCY]
Possible areas to investigate:
- Is the `@Transactional` boundary correctly wrapping ALL mutations?
- Is `Customer.totalBalance` being updated atomically with the `DebtLedger` entry?
- Is a `DebtLedger` row being updated instead of a new one inserted?
- Is optimistic locking (`@Version`) causing a conflict on `Customer`?

---

## Business Rules Reminder (always enforce)
- `DebtLedger` rows are **append-only** — never `UPDATE` or `DELETE`
- `Customer.totalBalance` must always equal `SUM(DEBT_INCURRED) - SUM(PAYMENT)` for that customer
- Payments support **partial amounts** — no requirement to clear the full balance
- All debt-related writes happen in a **single `@Transactional` method** — rollback on any failure
- The `DebtLedger.transaction` FK links debt entries to the originating sale for full traceability

---

After completing, confirm:
- The `@Transactional` boundaries for checkout and payment
- How rollback is triggered if any step fails
- How to verify ledger consistency: `Customer.totalBalance` vs. raw ledger sum