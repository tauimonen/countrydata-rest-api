# Country Data API

A Spring Boot application providing a RESTful API for managing and retrieving information about countries. The API allows users to access details such as population, surface area, government form, capital city, and more.

## Table of Contents
- [Technology Stack](#technology-stack)
- [API Endpoints](#api-endpoints)
- [Exception Handling](#exception-handling)
- [Running the Application](#running-the-application)

## Technology Stack
- **Spring Boot** - Framework for building the RESTful application.
- **JPA (Java Persistence API)** - For managing the database entities.
- **MySQL** - Used to store country data.
- **Spring Security** - Basic authentication for API access.

## Database

The database used in this application is based on the MySQL example database called `world`. This database includes information about countries, cities, and other geographic data.

You can download the example database from the official MySQL documentation site here: [MySQL Example Database - World](https://dev.mysql.com/doc/index-other.html)

## API Endpoints

### 1. `GET /api/countries`
Retrieves a list of all countries in the database.

**Response:**
- A JSON array containing country details.

### 2. `GET /api/countries/{countryCode}`
Retrieves a specific country by its 3-letter country code.

**Parameters:**
- `countryCode` (String) - The 3-letter code of the country.

**Response:**
- A JSON object containing the country's details.

**Error Response:**
- Status: `404 Not Found` if the country with the provided code does not exist.

## Exception Handling

The application includes custom exception handling for scenarios such as a country not being found.

- `CountryNotFoundException` is thrown if a country is not found by its code.
- Global exception handler `CountryRestExceptionHandler` sends a detailed error response with status codes.

### Error Response Example
```json
{
  "status": 404,
  "message": "Country with code {countryCode} not found",
  "timeStamp": 1622557389000
}
```

## Running the Application

1. Clone the repository.
2. Ensure MySQL is running on `localhost:3306` with a database named `world`.
3. Run the application with the following command:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application at `http://localhost:8080/api/countries`.

