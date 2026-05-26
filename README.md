# jen-ventory-api

> REST API powering Jenventory — an inventory, POS, and debt tracking system built for small sari-sari store owners.

## The Story Behind It

My sister runs a small sari-sari store, and whenever I helped out I'd run into the same two problems: I never knew the current prices of products off the top of my head, and tracking customers who owed money was a complete mess — everything was in a notebook, and finding someone's name in it was a headache.

So I built Jenventory. What started as a simple product list grew into a full backend that handles inventory management, a point-of-sale flow, and a debt/debtor tracking system with reporting. It's a real-world problem I lived through, and this API is how I solved it.

## What It Does

- **Inventory Management** — add, update, and track products with variants, stock levels, and pricing
- **Point of Sale** — process transactions and automatically update stock on each sale
- **Customer & Debt Tracking** — record customers who owe money (utang), log what they took, and monitor outstanding balances
- **GCash Logging** — log GCash cash-in and cash-out transactions (not actual payment processing, just record-keeping)
- **File Management** — image uploads for products and customers with cache-controlled serving
- **Reports** — generate PDF reports for sales and customer debt summaries using OpenPDF

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 4.0 |
| Language | Java 17 |
| Database | PostgreSQL |
| ORM | Spring Data JPA (Hibernate) |
| Auth | Spring Security + JWT (jjwt 0.12.6) |
| PDF Generation | OpenPDF 3.0.3 |
| Build Tool | Maven |
| Utilities | Lombok |

## Getting Started

### Prerequisites

- Java 17+
- PostgreSQL
- Maven (or use the included `./mvnw` wrapper)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/Cedrickkk/jen-ventory-api.git
   cd jen-ventory-api
   ```

2. Create a PostgreSQL database:
   ```sql
   CREATE DATABASE jenventory_db;
   ```

3. Configure your `application.properties` (or `application.yml`) with your database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/jenventory_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   app.jwt.secret=your_jwt_secret
   app.jwt.expiration=86400000
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

## Project Structure

```
src/
└── main/
    └── java/com/jenventory/jenventoryapi/
        ├── auth/             # JWT auth, security config, filters
        ├── common/           # Shared utilities, base classes, exception handling
        ├── customer/         # Customer/debtor management
        ├── file/             # File/image upload and serving
        ├── gcash/            # GCash services logging
        ├── product/          # Inventory and product variant management
        ├── report/controller # PDF report generation
        ├── transaction/      # POS and sales transactions
        └── JenVentoryApiApplication.java
```

## API Overview

Authentication is handled via JWT. All protected routes require a `Bearer` token in the `Authorization` header.

| Domain | Base Path |
|---|---|
| Auth | `/api/v1/auth` |
| Products | `/api/products` |
| Transactions / POS | `/api/v1/transactions` |
| Customers / Debts | `/api/v1/customers` |
| GCash Payments | `/api/v1/gcash` |
| Files / Images | `/api/v1/files` |
| Reports | `/api/v1/reports` |

## What I'd Do Differently

This project taught me a lot and I'm proud of what it does, but if I were to rebuild it:

**Add proper testing from the start.** The API has no unit or integration tests right now. I wrote features and manually tested everything, which worked, but it's not sustainable. I'd write tests alongside the code — at minimum service-layer unit tests and controller integration tests with `@SpringBootTest`.

**Be more intentional about UI/UX from day one.** Since this backs a real user (my sister), the workflows she'd actually use daily — like quickly checking who owes what — should have been thought through more carefully before writing a single endpoint. Design and backend should've been planned together.

## Related

Frontend (React client): [jen-ventory-client](https://github.com/Cedrickkk/jen-ventory-client)
