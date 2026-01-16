package com.learning.myFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// only 1 in a project / entry point of a project
@SpringBootApplication
public class MyFirstProjectApplication {
	public static void main(String[] args)  {
		SpringApplication.run(MyFirstProjectApplication.class, args);
	}
}
