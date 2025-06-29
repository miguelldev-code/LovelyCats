# =============================================
# Stage 1: Build the WAR using Maven
# =============================================
FROM maven:3.8.5-openjdk-17 AS build

# Define working directory
WORKDIR /app

# Copy all project files
COPY . .

# Build the WAR file (skip tests for speed)
RUN mvn clean package -DskipTests

# =============================================
# Stage 2: Deploy WAR in Tomcat
# =============================================
FROM tomcat:9.0-jdk17

# Optional: Clean default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR as ROOT.war
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port (default Tomcat port)
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
