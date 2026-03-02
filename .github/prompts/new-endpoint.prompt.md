---
description: 'Scaffold a new REST endpoint with request DTO, service method, and controller method for the Sari-Sari Store API.'
mode: 'agent'
---
Add a new endpoint to an existing feature in this Spring Boot project. Follow ALL conventions in the instruction files.

## Endpoint Details
Feature / Resource: [RESOURCE_NAME, e.g. "Product", "Customer", "Transaction"]
HTTP Method: [GET | POST | PUT | DELETE | PATCH]
Path: `/api/v1/[resource-path]`
Purpose: [DESCRIBE_WHAT_THIS_ENDPOINT_DOES]
Inputs: [DESCRIBE_REQUEST_BODY_OR_PARAMS]
Output: [DESCRIBE_RESPONSE_BODY]

---

## Generate the following:

### 1. Request DTO (if applicable)
- Package: `com.store.api.dto.[resource]`
- Include all required Bean Validation annotations (`@NotNull`, `@NotBlank`, `@Positive`, `@DecimalMin`, etc.)
- Use `BigDecimal` for money fields, never `double`
- Use `@Valid` on nested object lists

### 2. Response DTO (if new or modified)
- Use a Java `record` for immutable response types
- Include all fields the Angular client will need
- Add any derived/computed fields (e.g. `isLowStock`, `totalBalance`)

### 3. Service Method
- Add to the existing relevant service class
- Annotate with `@Transactional` (write) or `@Transactional(readOnly = true)` (read)
- Validate business rules before DB operations
- Throw domain-specific exceptions (`ResourceNotFoundException`, `InsufficientStockException`, etc.) — never raw `RuntimeException`
- Never expose JPA entities — map to DTOs before returning

### 4. Controller Method
- Add to the existing relevant controller class
- Use correct HTTP method annotation (`@GetMapping`, `@PostMapping`, etc.)
- Use `@Valid` on `@RequestBody` parameters
- Return `ResponseEntity<Dto>` with the correct status code
- No business logic — delegate entirely to the service

---

After generating, confirm:
- The `@Transactional` boundary for this operation
- HTTP status code used and why
- Any edge cases handled (not found, invalid input, conflict)
