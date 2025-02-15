# Fomalhaut-core
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-blue.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3%2B-blue.svg)](https://maven.apache.org/)
[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://adoptium.net/)
![Version](https://img.shields.io/badge/alpha-0.0.0-yellow.svg)
> From TEIDESAT Project and Hyperspace Canarias

## Description
This software serves as the backend application and database service for the TEIDESAT Project's [mission control web application](https://github.com/Teidesat/Fomalhaut).
It runs a Spring Boot reactive web API with a MongoDB instance.


## Prerequisites
Before running the application, ensure you have installed the following:

- [Java JDK 17+](https://adoptium.net/)
- [Maven 3+](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/get-started) and [Docker Compose](https://docs.docker.com/compose/install/)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-user/your-repository.git
   cd your-repository
   ```
2. Environment variables are pre-configured in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://mongo:27017/coredev
   server.port=8081
   ```

## Running the Project
### Start MongoDB using Docker
To run the project with Docker:
```sh
docker compose up
```

### Start the backend with the embedded web server
```sh
mvn spring-boot:run
```

## Verification
Once the application is running, you can access the API at:
```
http://localhost:8081
```

## Stopping the Application
- Database: `docker compose down`
- Application: Press `CTRL + C` in the Maven terminal

## Troubleshooting
- If port 8081 is in use, you can change it in `application.properties`
- To clean up MongoDB containers and volumes:
  ```sh
  docker compose down -v
  ```