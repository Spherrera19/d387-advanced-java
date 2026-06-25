<strong> **DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D387 – ADVANCED JAVA
Welcome to Advanced Java! This is an opportunity for students to write multithreaded object-oriented code using Java frameworks and determine how to deploy software applications using cloud services.

FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this assessment, you will modify a Spring application with a Java back end and an Angular front end to include multithreaded language translation, a message at different time zones, and currency exchange. Then, build a Docker image of the current multithreaded Spring application and containerize it using the supporting documents provided in this task.


## SUPPLEMENTAL RESOURCES 
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!

A. Repository Management
GitLab Repository: https://gitlab.com/wgu-gitlab-environment/student-repos/sher595/d387-advanced-java.git

Branch History: (Please see attached screenshot of the repository commit history as required for final submission).

B. Localization and Internationalization
1. Welcome Message Localization (B1)
   Implementation: Created welcome_en.properties and welcome_fr.properties resource bundles.

Technical Details: Implemented multi-threaded logic using Java Threads to fetch and display the English and French welcome messages concurrently, ensuring efficient loading during application startup.

2. Multi-Currency Display (B2)
   Implementation: Modified the Angular app.component.html to display room pricing.

Technical Details: Utilized Angular data binding to pull room pricing dynamically, and implemented CSS/HTML line-breaking to render USD, CAD, and EUR prices on distinct lines as required.

3. Time Zone Conversion (B3)
   Implementation: Created TimeZoneController.java to handle time zone translations.

Technical Details: Used java.time.ZonedDateTime and ZoneId to convert an anchored base time (15:30 ET) into Mountain Time and UTC. Applied DateTimeFormatter to enforce "HH:mm" output formatting for the final display.

C. Cloud Deployment and Dockerization
1. Docker Implementation (C1)
   Dockerfile: Included in the project root.

Process: Built a custom Docker image (landon-hotel-app) using eclipse-temurin:17 to ensure a consistent, portable runtime environment for the Spring Boot JAR.

2. Testing and Containerization (C2)
   Container Name: D387_010825670

Verification: The application was successfully built and tested as a containerized image. The container successfully binds to port 8080 and serves the REST API endpoints. (See attached screenshots for verification of container status and endpoint functionality).

3. Cloud Deployment Strategy (C3)
   Cloud Provider: Amazon Web Services (AWS)

Strategy: I would deploy this application using AWS Elastic Beanstalk, which is designed to orchestrate Docker containers.

Workflow: The application image would be pushed to Amazon ECR (Elastic Container Registry).

Automation: A GitLab CI/CD pipeline would trigger on every push to the main branch, automatically rebuilding the image and updating the Elastic Beanstalk environment.

Data: Persistent storage for reservation data would be handled by Amazon RDS, migrating away from the local H2 in-memory database to ensure high availability and data integrity.