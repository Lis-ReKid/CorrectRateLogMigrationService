package com.re_kid.lis.correctratelogmigrationservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.re_kid.lis.correctratelogmigrationservice.obj.MigrationData;
import com.re_kid.lis.correctratelogmigrationservice.service.MigrationService;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
public class MigrationController {
    private final MigrationService migrationService;
    
    public MigrationController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @PostMapping("/correctratelog/issue")
    public String issueMigrationId(@RequestBody MigrationData data) {
        return migrationService.issueId(data);
    }

    @GetMapping("/correctratelog/migrate/{id}")
    public MigrationData migrate(@PathVariable String id) {
        return migrationService.migrate(id);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound() {}
}
