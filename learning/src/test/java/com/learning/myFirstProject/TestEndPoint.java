package com.learning.myFirstProject;

import org.springframework.stereotype.Component;

@Component
public class TestEndPoint {
    int questions = 800;
    public String fun () {
        return "Ayush has solved " + questions + "+ questions on leetcode";
    }
}
