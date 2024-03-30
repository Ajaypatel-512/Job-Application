#FROM openjdk:17
#EXPOSE 8080
#COPY ./build/libs/FirstJobApp-0.0.1-SNAPSHOT.jar FirstJobApp-0.0.1-SNAPSHOT.jar
#CMD ["java","-jar","FirstJobApp-0.0.1-SNAPSHOT.jar"]


FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]