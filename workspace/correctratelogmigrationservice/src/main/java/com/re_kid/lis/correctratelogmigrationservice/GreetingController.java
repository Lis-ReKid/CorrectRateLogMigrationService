package com.re_kid.lis.correctratelogmigrationservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.re_kid.lis.correctratelogmigrationservice.obj.Greeting;


@Controller
public class GreetingController {
    GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    @ResponseBody
    public Greeting greet() {
        var greeting = greetingService.getGreeting();
        return greeting;
    }
    
}
