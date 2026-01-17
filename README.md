# Spring Boot Learning Notes
**Why do we need Spring Boot when Spring already exists?**
- Spring Boot is built on top of Spring to make Spring development easier and faster. It requires:
  1. **Less configuration** :
    - Spring requires a lot of manual configuration (XML or Java config).
    - Spring Boot automates most configurations using sensible defaults.
    - This reduces boilerplate code and setup time.
  3. **No external server needed** : 
    - Spring applications usually need an external server (like Tomcat) to run.
    - Spring Boot comes with an embedded server (Tomcat by default).
    - So, a Spring Boot app can run directly using:
    ```
    java -jar app.jar
    ```
## Table of Contents
- [Learning](#learning)
  - [Day 1 – Basics](#day-1--basics)
  - [Day 2 – Maven](#day-2--maven)
  - [Day 3 - File Structure](#day-3--file-structure)
  - [Day 4 - Classes And Annotations](#day-4--classes-and-annotations)
- [Terms](#terms)

---
---
<a name="learning"></a>
# Learning

### Day 1 – Basics
- Used **Spring Initializr** to create a Spring Boot project and manage Java & Spring Boot versions
- Understood basic project execution flow:
  - Application starts → JVM assigns a **PID (Process ID)**
  - Embedded server (Tomcat) starts
- Created APIs using `@RestController`
- Used `@GetMapping("abc")` to define API endpoints
- Used `@RequestMapping("xyz")` to set a base/context path for APIs

---

### Day 2 – Maven

#### 1. What is Maven?
Maven is a **build automation** and **dependency management** tool used in Java projects.

#### 2. Build Automation (What Maven does automatically)
- Compiles source code
- Runs test cases
- Packages the application (JAR / WAR)
- Can install or deploy the project
- Follows a fixed build structure so builds are consistent

#### 3. Maven Build Life Cycle
Main build phases:
- **validate** – checks if project structure is correct
- **compile** – compiles source code
- **test** – runs tests
- **package** – creates JAR/WAR
- **verify** – checks build results
- **install** – installs build into local repository
- **deploy** – deploys build to remote repository

#### 4. Dependency Management
- Maven downloads required libraries automatically
- Dependency details are written inside **pom.xml**
- Dependencies are stored in local `.m2` repository
- Maven also downloads required sub-dependencies automatically

** Transitive Dependency:**  
When one dependency needs other dependencies, Maven downloads them automatically without us adding them manually.


#### 6. pom.xml file
- Main configuration file of a Maven project
- Contains:
  - Project info (name, version)
  - Dependencies
  - Build configuration
- Maven reads this file to build the project

#### 7. mvn vs mvnw
- `mvn` → Uses Maven installed on the system
- `./mvnw` → Uses **Maven Wrapper** (project-specific Maven version)

👉 Both do the same job, but `mvnw` ensures the correct Maven version for the project.

#### 8. Common Commands
```bash
mvn validate
./mvnw validate
```

---

### Day 3 – File Structure

#### Spring Boot Project File Structure

1. **.idea**
   - IDE-specific files (created by IntelliJ IDEA)
   - Not important for application logic

2. **mvn / mvnw / mvnw.cmd**
   - Used to run Maven commands  
   - `mvn` → uses Maven installed on the system  
   - `./mvnw` or `mvnw.cmd` → uses project-specific Maven (Maven Wrapper)

3. **src**
   - **main**
     - **java** → contains application Java code  
     - **resources** → contains configuration files (like `application.properties`) and static files
   - **test**
     - Contains test code for the application

4. **target**
   - Created after running:
     - `mvn package` (if Maven is installed)
     - `./mvnw package` (if using Maven Wrapper)
   - Contains generated JAR files:
     - **.jar.original**
       - Contains only compiled Java code
     - **FAT JAR (.jar)**
       - Contains compiled Java code + all required dependencies
       - Used to run the application

   👉 Run the application using:
   ```bash
   java -jar ./target/project-name-version-SNAPSHOT.jar
   ```
5. **pom.xml**
  - Main Maven configuration file
  - Contains:
    - Dependencies
    - Plugins
    - Project information


---
### Day 4 – Classes And Annotations

#### @SpringBootApplication
- Main entry point of Spring Boot application
- Used only once
- Combines:
  - @Configuration
  - @EnableAutoConfiguration
  - @ComponentScan

```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
#### IOC & Dependency Injection
- Spring creates and manages objects (beans)
- Objects are injected automatically

```java
@RestController
public class UserController {

    @Autowired
    private UserService userService;
}
```


#### Common Annotations

```java
@Component        // Generic class
@Service          // Business logic
@Repository       // Database layer
@Controller       // MVC Controller
@RestController   // REST APIs
```

#### Auto Configuration
- Spring auto-configures based on dependencies and properties

```java
@EnableAutoConfiguration
public class DemoApplication {
}
```



---
---

<a name="terms"></a>
# Terms (Quick Reference)

### Spring Initializr
- A tool used to quickly create Spring Boot projects with required setup.

### Embedded Server
- A built-in server (like Tomcat) that comes with Spring Boot, so no separate server installation is needed.

### API Endpoint
- A specific URL that handles requests and returns responses.

### Annotation
- Special instructions written using `@` that tell Spring how the code should behave.

### Maven
- A build automation and dependency management tool used in Java projects.

### Build Lifecycle
- A fixed set of steps Maven follows to build a project  
  (validate → compile → test → package → install → deploy).

### pom.xml
- The main configuration file of a Maven project.
- Contains dependencies, plugins, and project details.

### Dependency
- Pre-written code or library used in a project to save development time.

### Transitive Dependency
- When one dependency needs other dependencies, Maven downloads them automatically.

### Packaging
- **JAR** – Can run directly using Java.
- **WAR** – Needs to be deployed on an external server.

### FAT JAR
- A JAR file that contains:
  - Compiled Java codeshort
  - All required dependencies.
- Used to run Spring Boot applications directly.

### Repackaging
- Process where:
  - Maven first creates `.jar.original` (only compiled code)
  - A plugin converts it into a **FAT JAR**
- Happens automatically during `mvn package`.

### IOC (Inversion of Control)
- control of objection creation is inverted from user to the spring
- Spring creates and manages objects
- Objects are called **beans**

### Dependency Injection
- Dependency Injection is a technique where Spring provides the required object to a class instead of the class creating it itself.
- Reduces dependency between classes

