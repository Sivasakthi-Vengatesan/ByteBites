# ByteBites - Climate Food Ordering System

Java Spring Boot + Thymeleaf + MySQL food ordering project with climate-based food filtering, search, cart, reviews and Cashfree sandbox payment integration.

## Stack
- Java 21
- Spring Boot 3.5.5
- Maven
- Thymeleaf
- MySQL / JDBC
- Cashfree Sandbox

## Run
1. Create the `climatefoodordering` database.
2. Run `database/schema.sql` in MySQL Workbench.
3. Put your real MySQL password and Cashfree sandbox credentials in `src/main/resources/application.properties`.
4. Run `mvn spring-boot:run`.
5. Open `http://localhost:8080/ByteBites/`.

## GitHub security
Do NOT commit real MySQL passwords or Cashfree API keys. The supplied project uses placeholders for those values.
