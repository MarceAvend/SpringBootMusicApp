# SpringBootMusicApp
- [Spring Boot](http://projects.spring.io/spring-boot/) Music App integration project [Ada School](https://ada-school.org/)
- As end product of bootcamp [Java Backend Developer Spring Boot](https://ada-school.org/java-backend-developer-spring-boot-es/)
- Created by *Marcela Avendaño* [Linkedin](https://www.linkedin.com/in/marcela-avenda%C3%B1o-051190124/)

<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" /> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot" />
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"/>
<img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" /> 
<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white" /> 
<img src="https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white" /> 

## Video showing the functionalities created

https://youtu.be/rAwOX44VbCQ



## Project features

- User management and authentication microservice
- Detailed design focused on low coupling and high cohesion
- Functionalities with unit test coverage testing both the web layer and the services
- Secure endpoints, protected by JWT with only public access for the login who creates the token.


## Project structure
```
SpringBootMusicApp/
└── musicApp/
    └── src/
        └── main/
            ├── java/
            │   ├── com.integrationproject.musicapp/
            │   │   ├── appuser/
            │   │   │   ├── controller/
            │   │   │   ├── dto/
            │   │   │   ├── model/
            │   │   │   ├── repository/
            │   │   │   └── service/
            │   │   ├── auth/
            │   │   │   ├── configuration/
            │   │   │   ├── controller/
            │   │   │   ├── dto/
            │   │   │   ├── security/
            │   │   │   └── service/
            │   │   ├── swagger/
            │   │   │   └── swaggerConfiguration
            │   │   └── MusicAppAplication
            │   └── resources/
            │       └── aplication.properties
            └── test/
                └── java/
                    └── com.integrationproject.music.app/
                        └── appuser/
                            ├── service/
                            │   └── AppuserServiceImplTests
                            └── controller/
                                └── MusicAppAplicationTests
                  
```


##  Workflow used: Gitflow
![03 Release branches](https://user-images.githubusercontent.com/116927440/219958934-005c701c-23dd-4280-a4ba-66f30486107f.svg)



## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)
- [PostgreSQL 14.4](https://www.postgresql.org/)

**Java**

database configuration, make sure it is the same or modify the application.properties file
with your personal configuration, just keep the musicdb database

spring.datasource.url= jdbc:postgresql://localhost:5432/musicdb?serverTimezone=America/Los_Angeles
spring.datasource.username= postgres
spring.datasource.password= postgres


**SQL**

You must run this command in a console with the postgress database so that the tables are created when you start the application
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
