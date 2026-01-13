package com.learning.myFirstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greet")
public class TestEndPoint {
    @GetMapping("spring")
    public String helloSpring() {
        return "Hellow SpringBoot";
    }

    @GetMapping("java")
    public String heyJava() {
        return "hey java";
    }
}

// @RestController allow krta hai use of REST APIs
// @RequestMapping acts as an context path, mtlb endpoint at a context path
// @GetMapping map krta hai andr ke keyword ko as an endpoint for the api