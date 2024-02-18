
# Rent Car

This is an API for a car rental application called RentCar. It provides endpoints for managing users, products (cars), bookings, categories, features, and images

## Stack utilizada

**Java:** Programming language used for backend development.

**Spring Boot:** Framework for creating Java applications.

**Spring Security:** For authentication and authorization.

**Spring Data JPA:** Simplifies the implementation of data access layers.

**JWT (JSON Web Tokens):** For secure token-based authentication.

**Swagger:** For API documentation.

**Jackson:** For JSON serialization and deserialization.

**H2 Database:** In-memory database for development and testing.

**Gradle:** Build automation tool.

**JUnit:** Testing framework for unit tests.

**Mockito:** Mocking framework for unit tests.

## API Documentation


- **Swagger UI:** Accessible at /swagger-ui.html after running the application.

### Endpoints:
**Authentication:**

- /auth/login: POST request to authenticate users and generate JWT tokens.
- /auth/register: POST request to register new users.
**Users:**

/users: CRUD operations for managing users.

**Products:**

- /products: CRUD operations for managing products (cars). 

- /products/category/{categoryId}: GET request to retrieve products by category.

- /products/city/{cityId}: GET request to retrieve products by city.

**Bookings:**
- /bookings: CRUD operations for managing bookings.
**Categories:**

- /categories: CRUD operations for managing categories.
**Features:**

/features: CRUD operations for managing features.
Images:

/images: CRUD operations for managing images.
### Notes:
Ensure you have the Java Development Kit (JDK) installed on your system to run the Java application. Additionally, Maven should be configured properly in your environment.
## Installation:

Clone the Repository:

```bash
  git clone <repository-url>
```
This will clone the repository to your local environment.

Navigate to the Project Directory:    
```bash
cd rentcar-api
```
Compile and Package:
```bash
  mvn clean package
```
Run the Application:
```bash
  java -jar target/rentcar-api.jar
```