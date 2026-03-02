---
applyTo: '**/*Controller.java, **/controller/**/*.java'
description: 'description'
---
## REST Controller Standards for Sari-Sari Store API

When generating or modifying Spring Boot controller classes, always follow these rules:

### Class Structure
```java
@RestController
@RequestMapping("/api/v1/resource-name")
@RequiredArgsConstructor
@Tag(name = "Resource Name", description = "Operations for resource")
public class MyController {

    private final MyService myService;

    // endpoints...
}
```
- Always `@RestController` — never `@Controller` (no server-side views)
- Always `@RequestMapping("/api/v1/...")` with plural, kebab-case resource names
- Use constructor injection via `@RequiredArgsConstructor`
- No business logic — only delegate to the service layer

### Endpoint Patterns
```java
// GET list (paginated)
@GetMapping
public ResponseEntity<Page<ProductDto>> getAll(
    @PageableDefault(size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
    return ResponseEntity.ok(productService.getAll(pageable));
}

// GET single
@GetMapping("/{id}")
public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.getById(id));
}

// POST create
@PostMapping
public ResponseEntity<ProductDto> create(@Valid @RequestBody CreateProductDto request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request));
}

// PUT update
@PutMapping("/{id}")
public ResponseEntity<ProductDto> update(@PathVariable Long id,
                                          @Valid @RequestBody UpdateProductDto request) {
    return ResponseEntity.ok(productService.update(id, request));
}

// DELETE
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
}
```

### HTTP Status Codes
| Operation | Status Code |
|---|---|
| GET (found) | `200 OK` |
| POST (created) | `201 Created` |
| PUT/PATCH (updated) | `200 OK` |
| DELETE (success) | `204 No Content` |
| Validation error | `400 Bad Request` |
| Not found | `404 Not Found` |
| Conflict (e.g. insufficient stock) | `409 Conflict` |
| Server error | `500 Internal Server Error` |

### Request Validation
```java
// Always use @Valid on request bodies
public ResponseEntity<Dto> create(@Valid @RequestBody CreateDto request) { }

// Use @PathVariable for IDs, @RequestParam for filters
public ResponseEntity<Page<Dto>> search(
    @RequestParam(required = false) String name,
    @RequestParam(required = false) Boolean lowStock,
    Pageable pageable) { }
```

### Global Exception Handler (always use — do not handle exceptions in controllers)
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(404, "NOT_FOUND", ex.getMessage()));
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorResponse> handleStock(InsufficientStockException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
            .body(new ErrorResponse(409, "INSUFFICIENT_STOCK", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest()
            .body(new ErrorResponse(400, "VALIDATION_ERROR", message));
    }
}
```

### CORS Configuration
```java
// Since Angular frontend is on a different origin, configure CORS globally
@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowedOrigins(List.of("http://localhost:4200", "https://your-frontend-domain.com"));
    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    // ...
}
```

### What to Avoid
- Business logic or DB calls in controllers
- Returning JPA entities directly — always use DTOs
- `@Autowired` field injection
- Catching exceptions in controller methods — let `@RestControllerAdvice` handle them
- `@Controller` (implies view rendering) — always use `@RestController`
- Hardcoded strings for paths — keep path segments consistent with `/api/v1/` prefix
