package com.my_spring_boot.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}


// controller me hoga endpoints
// services me hoga logic
// repo -> db se query chalayga, dusre class extend kr ke (mongoRepository)
//isley controller -- (calls) --> services -- (calls) --> repo (give access to use data mongodb)