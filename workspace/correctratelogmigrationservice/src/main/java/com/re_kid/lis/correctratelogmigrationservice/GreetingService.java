package com.re_kid.lis.correctratelogmigrationservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.lis.correctratelogmigrationservice.obj.Greeting;

@Service
public class GreetingService {
    GreetingsRepository greetingsRepository;

    public GreetingService(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    @Transactional
    public Greeting getGreeting() {
        greetingsRepository.createGreetingsTable();
        greetingsRepository.createGreeting();
        return greetingsRepository.findGreetingByLang("en");
    }
}
