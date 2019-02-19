FROM maven:3.5.4-jdk-8-slim

EXPOSE 8080
VOLUME /root/.m2

WORKDIR /usr/src/task-planner

COPY . /usr/src/task-planner/

CMD ["mvn", "spring-boot:run"]

# docker build -t skknox/got-spring-boot-app:v7 .
# docker run -p 8080:8080 skknox/got-spring-boot-app:v7
