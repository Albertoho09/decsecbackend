FROM openjdk:17
COPY target/apirest_prueba-0.0.1-SNAPSHOT.jar apirest_prueba-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "apirest_prueba-0.0.1-SNAPSHOT.jar"]