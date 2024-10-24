# Spring Boot MySQL
Spring Boot MySQL Integration

Step 1 : Make sure MySQL database is install and running in your machine

    https://dev.mysql.com/downloads/installer/        

Step 2 : Add Dependency to pom.xml

    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <!-- MySQL connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>

Step 3 : Modify application.properties file

    spring.datasource.url=jdbc:mysql://localhost:3306/redis_db
    spring.datasource.username=root
    spring.datasource.password=amar1234
