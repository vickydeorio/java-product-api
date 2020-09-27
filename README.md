# Java Product API

This is a Java SpringBoot API, with Endpoints to manipulate a entity (Product).

## Installation

With the repository cloned in your computer, point your bash on the source directory and run the following command
```bash
mvn clean install
```
After that execute the Java Jar generated
```bash
java -jar target/<your_jar_name>.jar
```
And now the application should complete the initialization.

## Usage
The Swagger documentation will be available on 

```http
http://localhost:8080/swagger-ui.html
```

## Properties
This application has a properties file, to specify your location/language (As well the language that will be useddd on the data).
```bash
application.language=en
application.country=US
```
This file is located at: 

```bash
src/main/resources/application.properties
```