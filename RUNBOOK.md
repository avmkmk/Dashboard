# Cloud Kitchen Analytics Backend Services Runbook

This document outlines the steps and commands required to build and run the backend microservices for the Cloud Kitchen Analytics Dashboard.

## Prerequisites

Ensure you have the following installed and configured:

1.  **Java Development Kit (JDK) 17 or higher**
2.  **Apache Maven 3.6.0 or higher**
3.  **Docker Desktop (or Docker Engine and Docker Compose)**

## Steps to Run the Backend Services

### 1. Build the Microservices

Navigate to the root directory of the project (`D:\Projects\CloudKitchenAnalytics`) and build each microservice using Maven. It's crucial to build them in order, as `analytics-processing-service` depends on `data-ingestion-service`.

**Commands:**

```bash
# Navigate to the project root if you are not already there
cd D:\Projects\CloudKitchenAnalytics

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

### 2. Start the Services using Docker Compose

From the root directory of the project (`D:\Projects\CloudKitchenAnalytics`), run Docker Compose to start all services, including the PostgreSQL database.

**Command:**

```bash
# Navigate to the project root if you are not already there
cd D:\Projects\CloudKitchenAnalytics

docker compose up --build -d
```

*   `--build`: Rebuilds images before starting containers (useful if you made code changes).
*   `-d`: Runs containers in detached mode (in the background).

You can check the status of your running containers with:

```bash
docker compose ps
```

### 3. Stopping the Services

To stop and remove all containers, networks, and volumes created by Docker Compose:

```bash
# Navigate to the project root if you are not already there
cd D:\Projects\CloudKitchenAnalytics

docker compose down -v
```

*   `-v`: Removes named volumes declared in the `volumes` section of the `docker-compose.yml` file. This is important to ensure a clean slate for the database.
