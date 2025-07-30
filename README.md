# Cloud Kitchen Analytics Dashboard (Backend MVP)

This project implements a backend system for cloud kitchens to centralize and analyze critical operational data, providing actionable insights into revenue, costs, order patterns, and basic wastage. It consists of three microservices: `data-ingestion-service`, `analytics-processing-service`, and `analytics-query-service`, orchestrated using Docker Compose.

## Prerequisites

Before you can run this project, ensure you have the following installed and configured:

1.  **Java Development Kit (JDK) 17 or higher:**
    *   Verify installation: `java -version`
    *   Verify Maven is configured to use JDK 17.

2.  **Apache Maven 3.6.0 or higher:**
    *   Verify installation: `mvn -v`

3.  **Docker Desktop (or Docker Engine and Docker Compose):**
    *   Ensure Docker Desktop is running and has sufficient resources allocated.
    *   Verify Docker installation: `docker -v`
    *   Verify Docker Compose installation: `docker compose version`

4.  **PostgreSQL Database:**
    *   The `docker-compose.yml` file will automatically set up a PostgreSQL container. You do **not** need a separate local PostgreSQL installation unless you prefer to run it outside Docker.
    *   **Database Details (as configured in `docker-compose.yml`):**
        *   **Database Name:** `cloud_kitchen`
        *   **User:** `postgres`
        *   **Password:** `password`
        *   **Port:** `5432` (mapped from container to host)

## Getting Started

Follow these steps to set up and run the project:

### 1. Clone the Repository (if not already done)

```bash
git clone <repository_url>
cd CloudKitchenAnalytics
```

### 2. Build the Microservices

Navigate to the root directory of the project (`D:\Projects\CloudKitchenAnalytics`) and build each microservice. It's crucial to build them in order, as `analytics-processing-service` depends on `data-ingestion-service`.

```bash
# Build data-ingestion-service (skipping tests for initial setup as DB might not be fully ready)
cd data-ingestion-service
mvn clean install -DskipTests
cd ..

# Build analytics-processing-service
cd analytics-processing-service
mvn clean install -DskipTests
cd ..

# Build analytics-query-service
cd analytics-query-service
mvn clean install -DskipTests
cd ..
```

### 3. Start the Services using Docker Compose

From the root directory of the project (`D:\Projects\CloudKitchenAnalytics`), run Docker Compose to start all services, including the PostgreSQL database:

```bash
docker compose up --build -d
```

*   `--build`: Rebuilds images before starting containers (useful if you made code changes).
*   `-d`: Runs containers in detached mode (in the background).

You can check the status of your running containers with:

```bash
docker compose ps
```

### 4. Initial Database Setup (Optional, for manual verification)

The Spring Boot applications are configured to automatically create tables on startup if they don't exist (using `spring.jpa.hibernate.ddl-auto=update`). However, if you need to manually inspect or manage the database, you can connect to it using the details provided in the "Prerequisites" section.

### 5. Data Ingestion

Once all services are up, you can ingest data using the `data-ingestion-service` API.

*   **Endpoint:** `POST http://localhost:8081/api/raw-data/items-report`
*   **Endpoint:** `POST http://localhost:8081/api/raw-data/orders-report`
*   **Content-Type:** `multipart/form-data`
*   **Parameter Name:** `file` (for the CSV file)

You can use tools like Postman, Insomnia, or `curl` to send CSV files to these endpoints.

### 6. Trigger Analytics Processing

After ingesting raw data, trigger the analytics processing service to calculate KPIs.

*   **Endpoint:** `POST http://localhost:8082/api/analytics/process`

This endpoint currently acts as a manual trigger. In a more advanced setup, this could be event-driven (e.g., via a message queue).

### 7. Query Analytics Data

Once analytics have been processed, you can query the results using the `analytics-query-service` API.

*   **Swagger UI:** `http://localhost:8080/swagger-ui.html` (for API documentation and testing)

**Example Endpoints:**

*   **Daily Revenue:** `GET http://localhost:8080/api/analytics/revenue/daily?date=YYYY-MM-DD`
*   **Weekly Revenue:** `GET http://localhost:8080/api/analytics/revenue/weekly?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD`
*   **Monthly Revenue:** `GET http://localhost:8080/api/analytics/revenue/monthly?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD`

### 8. Stopping the Services

To stop and remove all containers, networks, and volumes created by Docker Compose:

```bash
docker compose down -v
```

*   `-v`: Removes named volumes declared in the `volumes` section of the `docker-compose.yml` file. This is important to ensure a clean slate for the database.

## Project Structure

*   `data-ingestion-service`: Handles CSV file uploads, parsing, and raw data storage.
*   `analytics-processing-service`: Consumes raw data, calculates KPIs, and stores aggregated analytics.
*   `analytics-query-service`: Exposes REST APIs for querying processed analytics data.
*   `docker-compose.yml`: Defines and orchestrates the multi-container Docker application.

## Future Enhancements

Refer to the `PRD.pdf` and `LLD.pdf` documents in the `Cloud Kitchen Analytics` folder for detailed future considerations and out-of-scope features.