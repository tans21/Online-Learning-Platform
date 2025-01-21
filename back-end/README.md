# Backend Setup
### Navigate to the backend folder:
```
cd back-end
```
### Open workbench and create a database:
```
create database StudyCourses;
```
### Configure the database in application.properties located at src/main/resources:
```
spring.datasource.url=jdbc:mysql://localhost:3306/StudyCourses
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
```
### Build and run the application:
```
mvn clean install
mvn spring-boot:run
```
## The backend server will start on http://localhost:8080.

