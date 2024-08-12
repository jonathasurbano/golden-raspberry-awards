# golden-raspberry-awards

## Prerequisites for running the application
- Java 22
- Maven 3.9.8

## Running the application on the command line

In the project root folder, run the command below:
```shell
mvn spring-boot:run
```
After starting the application, send a GET request to the url 'localhost:8080/movies/smallest-and-largest-interval-between-awards'
```shell
curl -w '\n' localhost:8080/movies/smallest-and-largest-interval-between-awards
```
## Running the built-in tests on the command line
In the project root folder, run the command below:
```shell
mvn verify
```
