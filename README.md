# payment-details-service

ayment-details-services is a Spring Boot application designed to manage payment data.
It is built to handle incoming payment data via Kafka, store the data using Redis cache, and provide a REST endpoint for
fetching payment information based on a reference.

**Key Features**:

1. **Kafka Integration**: The application is integrated with Kafka to listen for incoming payment data messages.

2. **Redis Cache**: Upon receiving payment data from Kafka, the application stores the information in Redis cache for
   fast and efficient distributed data retrieval.

3. **RESTful API Endpoint**: The application exposes a REST endpoint to retrieve payment details based on a specified
   reference.

**Benefits**:

- Scalability: Easily scalable to handle increased payment data volume due to the decoupled and distributed nature of
  Kafka and Redis.
- Performance: Redis caching ensures rapid data retrieval across multiple instances.

### Technologies

* Java 21
* Spring Boot 3
* Build tool: Maven
* Use docker-compose to have Redis and Kafka up and running

---

### How to run locally

#### Prerequisites

- JDK 21

### Build/Run

1. While in the root, run `./docker-compose.yaml`.
2. Go to root directory and run: `mvn clean install`
3. Run application using: `mvn clean spring-boot:run`

---

### TODO:

### Integration tests

### API Documentation

### Monitoring / Observability

### Concepts / Improvement points
