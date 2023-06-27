SpringProductManegement is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line (it should work just as well with Java 17 or newer):


```
git clone https://github.com/spring-projects/spring-petclinic.git
cd spring-petclinic
./mvnw package
java -jar target/*.jar
```

You can then access this project at http://localhost:8080/


Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this, it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## Run this project on Docker
Đảm bảo rằng bạn đã cài đặt Docker trên máy tính của mình. Bạn có thể tải Docker từ trang chủ của Docker: https://www.docker.com/

Chạy container từ image Docker:
```
docker build -t spring-docker-app .
```
Chạy container từ image Docker:
```
docker run -p 8080:8080 spring-docker-app
```
You can then access this project at http://localhost:8080/
