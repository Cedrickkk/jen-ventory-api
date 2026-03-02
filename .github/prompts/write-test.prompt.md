---
description: 'Generate a thorough JUnit 5 + Mockito unit test for a service method in the Sari-Sari Store API.'
mode: 'agent'
---
Write a complete unit test class for the following service method. Use JUnit 5 and Mockito only — no Spring context, no `@SpringBootTest`.

## Test Target
Service class: [SERVICE_CLASS_NAME, e.g. "TransactionService"]
Method to test: [METHOD_NAME, e.g. "checkout"]
Method signature: [PASTE_METHOD_SIGNATURE]

---

## Test Structure

```java
@ExtendWith(MockitoExtension.class)
class [ServiceClass]Test {

    @InjectMocks
    private [ServiceClass] [serviceInstance];

    @Mock
    private [Repository1] [repo1];

    @Mock
    private [Repository2] [repo2];

    // ... additional mocks

    @Test
    void [methodName]_[scenario]_[expectedOutcome]() { }
}
```

## Required Test Cases to Generate

### Happy Path
- All valid inputs — assert correct return DTO
- Verify all repository `.save()` calls were made
- Verify correct number of interactions (e.g. `StockMovement` saved once per item)

### Edge Cases
- Entity not found — assert `ResourceNotFoundException` is thrown
- Insufficient stock — assert `InsufficientStockException` is thrown
- Invalid payment (amount > balance) — assert `InvalidPaymentException` is thrown
- Debt transaction without customer — assert appropriate exception

### Boundary Tests (if applicable)
- Exact stock match (requesting all available stock) — should succeed
- Payment exactly equal to balance — should succeed and set balance to zero
- Partial payment — balance correctly reduced

---

## Testing Standards
- Use `@ExtendWith(MockitoExtension.class)` — no Spring context
- Use `given(...).willReturn(...)` style (BDDMockito) for readability
- Use `assertThat(...)` from AssertJ — not `assertEquals`
- Use `assertThatThrownBy(() -> ...).isInstanceOf(...).hasMessageContaining(...)` for exception tests
- Use `verify(repo, times(n)).save(any())` to assert side effects
- Name test methods as: `methodName_scenario_expectedOutcome`
- Build test data using entity/DTO builders or factory methods — keep setup readable

---

After generating, list:
- All scenarios covered
- Any mocked dependencies and why
- Any important assertions about `@Transactional` rollback behavior (note: these require integration tests)
