FROM maven:3.6.0-jdk-11-slim AS build
COPY com.rpm.services/src /home/app/src
COPY com.rpm.services/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/RPMServices.jar /usr/local/lib/RPMServices.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/RPMServices.jar"]