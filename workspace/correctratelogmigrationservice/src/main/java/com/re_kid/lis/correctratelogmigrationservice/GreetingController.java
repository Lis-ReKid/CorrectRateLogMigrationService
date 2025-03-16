package com.re_kid.lis.correctratelogmigrationservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.re_kid.lis.correctratelogmigrationservice.obj.Greeting;


@Controller
public class GreetingController {
    @GetMapping("/greet")
    @ResponseBody
    public Greeting greet() {
        var greeting = new Greeting("en", "Hello World.");
        return greeting;
    }
    
}
