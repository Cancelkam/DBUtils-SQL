FROM openjdk:8-slim
COPY app-deadline.jar .
CMD ["java", "-jar", "app-deadline.jar"]
EXPOSE 9999