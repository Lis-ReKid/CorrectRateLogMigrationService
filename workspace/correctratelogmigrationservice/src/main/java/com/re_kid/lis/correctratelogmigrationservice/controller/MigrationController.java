package com.re_kid.lis.correctratelogmigrationservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.re_kid.lis.correctratelogmigrationservice.obj.MigrationData;


@RestController
public class MigrationController {
    @PostMapping("/issue")
    public String issueMigrationId(@RequestBody MigrationData data) {
        return "Connection success.";
    }
}
