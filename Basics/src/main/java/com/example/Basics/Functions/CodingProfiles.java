package com.example.Basics.Functions;

import org.springframework.stereotype.Component;

@Component
public class CodingProfiles {
    Integer LeetNum = 800;
    public String LeetFun() {
        return "Ayush has solved " + LeetNum + "+ problems on Leetcode";
    }
}
