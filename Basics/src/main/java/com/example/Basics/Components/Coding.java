package com.example.Basics.Components;

import com.example.Basics.Functions.CodingProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class Coding {
    @Autowired
    private CodingProfiles cp;

    @GetMapping("/leetcode")
    public String function() {
        return cp.LeetFun();
    }
}
