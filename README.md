# SpringBootMusicApp
- [Spring Boot](http://projects.spring.io/spring-boot/) Music App integration project [Ada School](https://ada-school.org/)
- As end product of bootcamp [Java Backend Developer Spring Boot](https://ada-school.org/java-backend-developer-spring-boot-es/)
- Created by *Marcela Avendaño* [Linkedin](https://www.linkedin.com/in/marcela-avenda%C3%B1o-051190124/)

<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" /> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot" />
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"/>
<img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" /> 


## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)
- [PostgreSQL 14.4](https://www.postgresql.org/)

java
/*
database configuration, make sure it is the same or modify the application.properties file
with your personal configuration, just keep the musicdb database
*/
spring.datasource.url= jdbc:postgresql://localhost:5432/musicdb?serverTimezone=America/Los_Angeles
spring.datasource.username= postgres
spring.datasource.password= postgres


sql
/*
You must run this command in a console with the postgress database so that the tables are created when you start the application
*/
create database musicdb;


## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
but I recommend running these two commands
shell
mvn compile
mvn spring-boot:run


## Created endpoints

Below is the link where the *updated collection* of endpoints created for this application is located,
to make use of them it is necessary to use the [postman](https://www.postman.com/) application and import [this file](https://github.com/MarceAvend/SpringBootMusicApp/blob/main/music_app_end_points.postman_collection.json)

You can also use swagger ui to see and make use of the created endpoints, after executing the application the path will be activated and you can make use of the endpoints of the application.
http://localhost:8080/MusicAppApplication/swagger-ui.html#/