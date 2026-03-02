---
description: 'Scaffold a complete JPA entity with repository, DTOs, service, and controller for the Sari-Sari Store API.'
mode: 'agent'
---
Generate a complete vertical slice for a new entity in this Spring Boot project. Follow ALL rules in `java-entity.instructions.md`, `java-service.instructions.md`, `java-controller.instructions.md`, and `java-dto.instructions.md`.

## Entity Details
Entity name: [ENTITY_NAME]
Table name: [TABLE_NAME]
Fields: [LIST_FIELDS_WITH_TYPES]
Relationships: [DESCRIBE_RELATIONSHIPS]

## Generate the following files:

### 1. Entity Class
- Package: `com.store.api.domain.entity`
- Use `@Entity`, `@Table`, Lombok (`@Getter`, `@Setter`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor`)
- Use `@GeneratedValue(strategy = GenerationType.IDENTITY)` for ID
- Add `@PrePersist` / `@PreUpdate` audit hooks for `createdAt` / `updatedAt`
- Use `BigDecimal` for money, `EnumType.STRING` for enums, `FetchType.LAZY` for all relationships
- Add `@Version` if this entity has fields subject to concurrent writes (e.g. stock or balance)

### 2. Repository Interface
- Package: `com.store.api.repository`
- Extend `JpaRepository<Entity, Long>`
- Add any custom `@Query` methods needed for search or filtering

### 3. DTOs
- Package: `com.store.api.dto.[entity-name]`
- `Create[Entity]Dto` — with Bean Validation annotations
- `Update[Entity]Dto` — with appropriate optional/required fields
- `[Entity]Dto` — response record (Java record preferred)
- `[Entity]Mapper` component class

### 4. Service Class
- Package: `com.store.api.service`
- Implement: `getAll(Pageable)`, `getById(Long)`, `create(CreateDto)`, `update(Long, UpdateDto)`, `delete(Long)`
- Annotate writes with `@Transactional`, reads with `@Transactional(readOnly = true)`
- Throw `ResourceNotFoundException` for missing entities

### 5. Controller Class
- Package: `com.store.api.controller`
- Map to `/api/v1/[resource-name]`
- Use `@RestController`, `@RequiredArgsConstructor`
- Endpoints: GET (paginated list), GET by ID, POST, PUT, DELETE
- Return correct HTTP status codes: 200, 201, 204, 404

---

After generating, summarize:
- The entity's relationships and why they are modeled that way
- Any `@Transactional` boundaries and why
- Any fields that required special handling (money, enums, optimistic locking)