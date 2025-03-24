package com.re_kid.lis.correctratelogmigrationservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.re_kid.lis.correctratelogmigrationservice.obj.MigrationData;
import com.re_kid.lis.correctratelogmigrationservice.service.MigrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MigrationController {
    private final MigrationService migrationService;
    
    public MigrationController(MigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @PostMapping("/issue")
    public String issueMigrationId(@RequestBody MigrationData data) {
        return migrationService.issueId(data);
    }

    @GetMapping("/migrate/{id}")
    public MigrationData migrate(@RequestParam String param) {
        
    }
    
}
