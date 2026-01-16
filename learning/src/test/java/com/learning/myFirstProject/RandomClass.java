package com.learning.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coding")
public class RandomClass {

    // this is what we call a DI (Dependency Injection) i.e, RandomClass is dependent upon TestEndPoint class
    // RC is dependent upon TEP.fun() here
    @Autowired
    private TestEndPoint tep;


    @GetMapping("profile")
    public String Cur() {
        return tep.fun();
    }
}


// @RestController allow krta hai use of REST APIs
// @RequestMapping acts as an context path, mtlb endpoint at a context path
// @GetMapping map krta hai andr ke keyword ko as an endpoint for the api