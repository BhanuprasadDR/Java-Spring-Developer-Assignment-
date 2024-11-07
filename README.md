# Java-Spring-Developer-Assignment-
Creating a RestAPI
Running a Spring Boot project in Visual Studio Code (VS Code) on Windows requires setting up the right environment and configuring VS Code to handle the project correctly. Here’s a step-by-step guide:

### 1. Prerequisites
Ensure you have the following installed:
   - *Java Development Kit (JDK)* (preferably JDK 17 or above)
   - *Maven* (if your project uses Maven)
   - *VS Code* with the following extensions:
      - *Java Extension Pack*: Provides support for Java projects, including Spring Boot.
      - *Spring Boot Extension Pack* (optional): Adds Spring Boot support in VS Code.

### 2. Open the Project in VS Code
   - Open VS Code.
   - Go to *File > Open Folder...* and select the folder containing your Spring Boot project.
   - VS Code should automatically detect it as a Java project.

### 3. Install Dependencies
If your project uses Maven or Gradle, open the terminal in VS Code:
   - Run mvn clean install (for Maven) or ./gradlew build (for Gradle) to download dependencies.

### 4. Configure Spring Boot Settings
   - In VS Code, open the *Run and Debug* pane (Ctrl+Shift+D).
   - Click on *"create a launch.json file"* if it prompts you. Select *Java*.
   - Add a new configuration to run the Spring Boot application:
     json
     {
         "type": "java",
         "request": "launch",
         "name": "Spring Boot App",
         "mainClass": "com.example.demo.DemoApplication",
         "projectName": "your-project-name"
     }
     
   - Replace mainClass with your Spring Boot application’s main class (the one with @SpringBootApplication).
   - Set projectName to the name of your project.

### 5. Run the Project
   - In the *Run and Debug* pane, select the Spring Boot App configuration.
   - Click *Start Debugging* (F5) to run the application.
   - Alternatively, you can run the application directly from the terminal with mvn spring-boot:run.

### 6. Access the Application
   - By default, Spring Boot applications run on http://localhost:8080. Open your browser and go to this URL to test the application.

### Additional Tips
- *Spring Boot Dashboard*: If you installed the Spring Boot Extension Pack, you can use the Spring Boot Dashboard to manage and run your Spring Boot applications easily.
- *Environment Variables*: If your project requires environment variables, add them in the launch.json configuration with "env": { "VARIABLE_NAME": "value" }.
- This setup should allow you to run and debug your Spring Boot application smoothly in VS Code on Windows!
