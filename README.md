#  Web Scrapper - Spring Boot API

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen?logo=springboot)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Docker](https://img.shields.io/badge/containerized-Docker-blue?logo=docker)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

This is a REST API built with Spring Boot that performs web scraping on Netshoes product pages. Given a product URL as a query parameter, it returns JSON with the item's title, price, description, and image.

Technologies used

- Java 17  
- Spring Boot 3.5.3  
- Jsoup 1.18.1  
- JUnit 5  
- Maven  
- Docker  

---

## Running with Docker

###  Requirements

- Docker installed and running (e.g., Docker Desktop)

### Steps

1. **Clone the repository:**
```
git clone https://github.com/RonaldoGR/web-scrapper.git
cd web-scrapper
```


2. **Build the Docker image:**
```
docker build -t web-scrapper .
```

3. **Run the container:**
```
docker run -p 8080:8080 web-scrapper
```

4.**Call the API endpoint:**

Open in your browser:
```
http://localhost:8080/product?url=https://www.netshoes.com.br/p/bicicleta-aro-26-colli-gps-freio-vbrake-aco-carbono-21-marchas-preto-I78-0282-006
```

### Example response
```json
{
  "title": "Bicicleta Aro 26 Colli GPS Freio V-Brake Aço Carbono 21 Marchas - Preto",
  "price": "R$ 899,99",
  "imageUrl": "https://img.netshoes.com.br/...",
  "description": "A bicicleta Colli GPS aro 26 é ideal para..."
}
```

⚠️ The returned data depends on the current structure of the Netshoes product page. If it changes, the scraper logic may need to be updated.



##  Running tests
**Running tests inside Docker**

Assuming the Docker image is already built, run the tests with:
```
docker run --rm web-scrapper mvn test
```

**To run unit tests outside Docker, make sure you have the following installed locally:**

###  Requirements

- Java 17 (same as the project)
- Internet access (to download dependencies the first time)
- One of the following:
  - Maven installed globally  
  - Or use the included Maven Wrapper (./mvnw)

###  How to run

If you have Maven installed:
```
mvn test
```
Or, using the Maven Wrapper:
```
./mvnw test
```

The test suite uses JUnit 5 and is located in:
```
src/test/java/br/edu/ifsul/academico/csti/ProductServiceTest.java
```

✅ The tests validate the HTML parsing logic using mock product pages.

## Project structure

- ProductController: exposes the /product endpoint
-	ProductService: handles scraping with Jsoup
-	ProductModel: defines the response model
-	ProductServiceTest: unit tests for the service logic
-	Dockerfile: containerization configuration

## Autor
Ronaldo Gandra Rocha - Academic at IFSUL (Federal Institute of Education, Science and Technology) - undergraduate in Internet Systems Technology
