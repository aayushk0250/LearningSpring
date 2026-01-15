# Spring Boot Learning Notes

## Table of Contents
- [Learning](#learning)
  - [Day 1 – Basics](#day-1--basics)
  - [Day 2 – Maven](#day-2--maven)
- [Terms](#terms)

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

#### What is Maven?
Maven is a **build automation** and **dependency management** tool used in Java projects.

---

#### Build Automation (What Maven does automatically)
- Compiles source code
- Runs test cases
- Packages the application (JAR / WAR)
- Can install or deploy the project
- Follows a fixed build structure so builds are consistent

---

#### Maven Build Life Cycle
Main build phases:
- **validate** – checks if project structure is correct
- **compile** – compiles source code
- **test** – runs tests
- **package** – creates JAR/WAR
- **verify** – checks build results
- **install** – installs build into local repository
- **deploy** – deploys build to remote repository

---

#### Dependency Management
- Maven downloads required libraries automatically
- Dependency details are written inside **pom.xml**
- Dependencies are stored in local `.m2` repository
- Maven also downloads required sub-dependencies automatically

**Transitive Dependency (1 line):**  
When one dependency needs other dependencies, Maven downloads them automatically without us adding them manually.

---

#### pom.xml file
- Main configuration file of a Maven project
- Contains:
  - Project info (name, version)
  - Dependencies
  - Build configuration
- Maven reads this file to build the project

---

#### mvn vs mvnw
- `mvn` → Uses Maven installed on the system
- `./mvnw` → Uses **Maven Wrapper** (project-specific Maven version)

👉 Both do the same job, but `mvnw` ensures the correct Maven version for the project.

---

#### Common Commands
```bash
mvn validate
./mvnw validate
```


---
---
<a name="terms"></a>
# Terms (Quick Reference)

### Dependency
- Pre-written code/library used in a project to reduce development effort.

### Transitive Dependency
- When a dependency needs other dependencies, Maven downloads them automatically.

### Maven
- A build automation and dependency management tool used in Java projects.

### pom.xml
- Main configuration file of a Maven project that contains dependencies and build details.

### Build Lifecycle
- A fixed sequence of steps Maven follows to build a project (validate → compile → test → package → install → deploy).

### Packaging
- **JAR** – Can run directly
- **WAR** – Needs to be deployed on an external server

### API Endpoint
- A specific URL that handles requests and returns responses.

### Annotation
- Special instructions written using `@` that tell Spring how the code should behave.

### Spring Initializr
- A tool used to quickly create Spring Boot projects with required configurations.

### Embedded Server
- A server (like Tomcat) that comes built-in with Spring Boot, so no separate installation is needed.
