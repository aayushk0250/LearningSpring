package com.my_spring_boot.learning.Controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health")
    public String health() {
        return "Ok";
    }
}
