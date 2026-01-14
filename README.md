<a name="top"></a>

[Terms](#terms)  
[Learning](#learning)
- [Day1](#day1)

---

<a name="learning"></a>
# Learning

(Spring Boot learning notes go here)

<a name="day1"></a>
## Day - 1
It's day 1 of learning Java Spring Boot, and I successfully learned:

- How to use **Spring Initializr** to manage Spring Boot and Java versions and import the project into an IDE
- Basic understanding of project execution flow:
  - PID (Process ID) assignment
  - API endpoint development using `@RestController`
  - Using `@GetMapping("abc")` for API paths
  - Setting context path using `@RequestMapping("xyz")`

---

<a name="terms"></a>
# Terms

## Dependencies
- Pre-written code that helps reduce development effort
- Example: **Spring Web** helps in creating REST APIs easily
- Spring Web provides an embedded **Apache Tomcat** server

## Maven
- Used for project build and dependency management

## Packaging
- **JAR (Java Archive)** – can be run directly
- **WAR (Web Application Archive)** – needs to be deployed on an external server

## API Endpoint
- A specific URL that accepts requests and returns responses for a defined operation

## Annotation
- `@SpringBootApplication`
- `@RestController`
- `@RequestMapping("abc")` – adds a context path
- `@GetMapping("xyz")` – maps a method to a specific endpoint
