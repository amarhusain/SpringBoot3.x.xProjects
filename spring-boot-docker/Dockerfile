# Start your image with a node base image
FROM eclipse-temurin:17-jdk-focal

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Install node packages, install serve, build the app, and remove dependencies at the end
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 8080

# Start the app using serve command
CMD [ "./mvnw", "spring-boot:run" ]