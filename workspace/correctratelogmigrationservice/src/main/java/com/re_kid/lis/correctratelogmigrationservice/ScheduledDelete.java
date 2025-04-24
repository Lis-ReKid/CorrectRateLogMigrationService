package com.re_kid.lis.correctratelogmigrationservice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.re_kid.lis.correctratelogmigrationservice.service.ScheduledDeleteService;

@Component
public class ScheduledDelete {
    private final ScheduledDeleteService scheduledDeleteService;

    public ScheduledDelete(ScheduledDeleteService scheduledDeleteService) {
        this.scheduledDeleteService = scheduledDeleteService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduledDeleteOldData() {
        scheduledDeleteService.deleteOldData();
    }
}
