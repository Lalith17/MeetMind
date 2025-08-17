# MeetMind – AI that understands your meetings.

A Spring Boot web application for meeting management, summarization, and email notifications. Integrates with Google GenAI for advanced summarization and uses Thymeleaf for dynamic web pages.

## Deployed Application
Access the live app here: [https://meetmind.onrender.com](https://meetmind.onrender.com)

## Features
- Summarize meeting content using Google GenAI
- Send meeting summaries via email
- Web interface with Thymeleaf templates
- RESTful API endpoints

## Technologies Used
- Java 21
- Spring Boot 3.5.x
- Maven
- Thymeleaf
- Spring Mail
- Google GenAI
- Docker

## Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+
- Docker (for containerized deployment)

### Local Development
1. **Clone the repository:**
   ```sh
   git clone <your-repo-url>
   cd meeting
   ```
2. **Configure application properties:**
   Edit `src/main/resources/application.properties` or `application.yml` as needed (e.g., mail server, GenAI API keys).
3. **Build and run:**
   ```sh
   mvn clean package
   java -jar target/meeting-0.0.1-SNAPSHOT.jar
   ```
4. **Access the app:**
   Open [http://localhost:8080](http://localhost:8080)

### Docker Deployment
1. **Build the JAR:**
   ```sh
   mvn clean package
   ```
2. **Build the Docker image:**
   ```sh
   docker build -t meeting-app .
   ```
3. **Run the container:**
   ```sh
   docker run -p 8080:8080 meeting-app
   ```

### Configuration
- Edit `src/main/resources/application.properties` or `application.yml` for:
  - Mail server settings
  - GenAI API keys
  - Other Spring Boot properties
- You can override properties with environment variables when running Docker.

### Testing
Run tests with:
```sh
mvn test
```

## Project Structure
- `src/main/java/com/mango/meeting/` - Main application code
- `src/main/resources/` - Configuration, templates, static assets
- `Dockerfile` - Docker build instructions
- `pom.xml` - Maven dependencies and build config

## Contribution
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Open a pull request

## License
This project is for demonstration purposes.

---
