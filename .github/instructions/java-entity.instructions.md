---
applyTo: '**/*Entity.java, **/entity/**/*.java, **/domain/**/*.java'
---
## JPA Entity Standards for Sari-Sari Store API

When generating or modifying JPA entity classes, always follow these rules:

### Class-Level Annotations
```java
@Entity
@Table(name = "table_name")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyEntity { }
```
- Always use `@Table(name = "...")` with snake_case table names
- Always include Lombok: `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@Builder`

### Primary Key
```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```
- Always use `Long` (not `long`) for IDs
- Always use `GenerationType.IDENTITY`

### Monetary Fields
```java
@Column(nullable = false, precision = 10, scale = 2)
private BigDecimal amount;
```
- **Always `BigDecimal`** — never `double` or `float` for money
- Always specify `precision` and `scale` on monetary columns

### Optimistic Locking (for Product entity only)
```java
@Version
private Long version;
```
- Required on `Product` to prevent concurrent stock update conflicts

### Audit Fields (include on every entity)
```java
@Column(nullable = false, updatable = false)
private LocalDateTime createdAt;

private LocalDateTime updatedAt;

@PrePersist
protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
}

@PreUpdate
protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
}
```

### Relationships
- Use `FetchType.LAZY` on all `@ManyToOne` and `@OneToMany` by default
- Always specify `@JoinColumn(name = "fk_column_name")` on the owning side
- For `@OneToMany`, use `mappedBy` on the non-owning side
```java
// Owning side (child)
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "customer_id", nullable = false)
private Customer customer;

// Non-owning side (parent)
@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
private List<DebtLedger> debtLedgers = new ArrayList<>();
```

### Enums
```java
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private TransactionType type;
```
- Always use `EnumType.STRING` — never `EnumType.ORDINAL`

### Business Rules to Enforce
- `Product.stockQuantity` must have `@Min(0)` and service-layer guard
- `DebtLedger` rows must never be updated after insert — mark mutable fields carefully
- `TransactionItem.unitPriceAtSale` must be set from `Product.currentPrice` at time of sale, not later

### What to Avoid
- `@Data` on JPA entities — causes issues with Hibernate proxies
- Bidirectional relationships without `mappedBy`
- `FetchType.EAGER` — causes N+1 query problems
- `float` or `double` for any numeric field representing money
- `EnumType.ORDINAL` — breaks when enum order changes
