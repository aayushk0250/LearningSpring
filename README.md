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
  - [Day 5 – REST API](#day-5--rest-api)
  - [Day 6 – MongoDB Basics](#day-6--mongodb-basics)
  - [Day 7 – Dive Into DBs](#day-7--dive-into-dbs)
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

#### 5. Dependency Management
- Maven downloads required libraries automatically
- Dependency details are written inside **pom.xml**
- Dependencies are stored in local `.m2` repository
- Maven also downloads required sub-dependencies automatically

**Transitive Dependency:**  
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
  - **@Configuration** – Marks the class as a configuration class where beans can be defined  
  - **@EnableAutoConfiguration** – Automatically configures the application based on dependencies  
  - **@ComponentScan** – Scans packages to detect and register Spring components as beans
`SpringBootApplication`

#### IOC & Dependency Injection
- Spring creates and manages objects (beans)
- Objects are injected automatically

```
@Autowired    // necessary for IOC, i.e, dpring creating object of a bean (class)
private UserService userService;
```


#### Common Annotations

`@Component // Generic class      @RestController // REST APIs`

#### Auto Configuration
- Spring auto-configures based on dependencies and properties

```java
@EnableAutoConfiguration
public class DemoApplication {}
```

---
### Day 5 – REST API
**(REpresentational State Transfer)**
- When we access a URL, we send an HTTP request.
- **A collection of such HTTP requests designed to exchange data between client and server is called a REST API.**
- client and server in a representation, where they can transfer states.
- Rest is basically URL + HTTP (Get/Post.Put/Delete)
- We access a url, by making http requests. Which combines and called rest api

---

#### Controller
- Controller is a special type of class/component
- Spring automatically creates its bean
- Used to handle incoming HTTP requests

Example:
```java
@RestController  
@RequestMapping("/journal")  
public class JournalController { }
```
---

#### POJO
- POJO stands for Plain Old Java Object
- Simple Java class used to represent data
- Contains fields, getters, and setters


---

#### HTTP Method Annotations

1. @GetMapping
- Used to read/fetch data
- Executes logic and returns data when the endpoint is hit

Function format:
```java
@GetMapping("/endpoint")  
public ReturnType methodName() { }
```
---

2. @PostMapping
- Used to create new data
- @RequestBody converts incoming JSON into a Java object
- In Postman: Body → raw → JSON

Function format:
```java
@PostMapping("/endpoint")  
public ReturnType methodName(@RequestBody ClassName obj) { }
```
---

3. @PutMapping
- Used to update existing data
- @PathVariable reads data from URL
- @RequestBody updates the existing object with new data

Function format:
```java
@PutMapping("/endpoint/{id}")  
public ReturnType methodName(@PathVariable Type id, @RequestBody ClassName obj) { }
```

---

4. @DeleteMapping
- Used to delete data
- Specifies the path variable to remove data from storage (currently a HashMap)

Function format:
```java
@DeleteMapping("/endpoint/{id}")  
public ReturnType methodName(@PathVariable Type id) { }
```
---

### Day 6 – MongoDB Basics

#### MySQL vs MongoDB
- MongoDB is a NoSQL, document-based database
- It stores data in a JSON-like format (BSON)

| MySQL            | MongoDB              |
|------------------|----------------------|
| Table            | Collection           |
| Rows & Columns   | Documents & Fields   |

#### Important Note
- When a document is created in MongoDB, it automatically assigns a unique **_id** to each document.

#### MongoDB Using Terminal

##### Check if MongoDB is Working
`
mongosh
`

##### Show Existing Databases
`
show dbs
`

##### Create / Switch to a Database
`
use school
`

##### Show Collections (Similar to Tables)
`
show collections
`

##### Insert Documents (Creates Collection Automatically)
`
db.students.insertOne({ "name": "Ayush", "age": 22 })
`

`
db.students.insertOne({ "name": "Rahul", "age": 20 })
`

##### Find a Document
`
db.students.find({ "name": "Ayush" })
`

##### Delete a Document
`
db.students.deleteOne({ "name": "Rahul" })
`

---

### Day 7 – Dive Into DBs

#### SQL vs NoSQL

| SQL                          | NoSQL                          |
|------------------------------|--------------------------------|
| Structured data              | Unstructured / Semi-structured |
| Rows & Columns               | Collections & Documents        |
| Predefined schema            | No predefined schema           |
| Strong transaction support   | High scalability               |
| Best for relational data     | Best for large & flexible data |
| Eg: MySQL                    | Eg: MongoDB                    |


#### ORM (Object Relational Mapping)
- A technique to map Java objects to Relational Database tables  
- Allows us to work with DB easily using OOP concepts  
- Maps Java classes to DB tables  
- ORM frameworks like Hibernate map fields in a Java class to DB table columns  
- Makes insert / update / retrieve / delete operations easier  


#### JPA (Java Persistence API)
- Provides interfaces and annotations to:
  - Save, Update, Retrieve, Delete data from Java objects  
- A set of rules/specifications to achieve ORM  
- Uses ORM tools like Hibernate  

#### Spring Data JPA
- Built on top of JPA (Java Persistence API)  
- Simplifies working with JPA using high-level abstractions  
- Still requires JPA implementations like: Hibernate, EclipseLink to handle actual database interactions  

#### Why JPA Is Not Used With MongoDB?
- JPA works only with SQL databases  
- SQL databases require predefined schemas and rows & columns  
- MongoDB is a NoSQL database with document-based storage  
- Due to different data models and storage structures, JPA is not used with MongoDB  


#### Spring Data MongoDB
- MongoDB is a NoSQL database, so it does not support traditional JPA  
- Spring Data MongoDB acts as the persistence provider for MongoDB  
- Provides abstractions and implementations to work with MongoDB in Spring applications  


#### Ways to Interact With Database


##### 1. Query Method DSL
- Simple way to create queries using method naming conventions  
- Best for simple and readable queries  

##### 2. Criteria API
- Used to build complex and dynamic queries  
- Programmatic and flexible approach  

---
<br>

---
<br>

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

### Controller:
- Special types of class/Components(since their beans will be made anyways), that are used to handle the HTTP requests.

### POJO (Plain Old Java Class):
- A POJO is a normal Java class that is not forced to extend or implement any special framework class or interface. It contains just fields, constructors, getters/setters, and methods

#### Mojo (Maven)
- Mojo is a Java class that represents a single executable task (goal) in a Maven plugin
- One Mojo = one task in Maven
- Mojo is NOT the same as POJO
