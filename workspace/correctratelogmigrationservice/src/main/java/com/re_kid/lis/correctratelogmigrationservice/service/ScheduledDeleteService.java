package com.re_kid.lis.correctratelogmigrationservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.lis.correctratelogmigrationservice.repository.ScheduledDeleteRepository;

@Service
public class ScheduledDeleteService {
    private final ScheduledDeleteRepository scheduledDeleteRepository;

    public ScheduledDeleteService(ScheduledDeleteRepository scheduledDeleteRepository) {
        this.scheduledDeleteRepository = scheduledDeleteRepository;
    }

    public void deleteOldData(){
        // 2週間以上前のデータをリスト化
        List<String> oldData =  scheduledDeleteRepository.findOldDataList();
        // リストのデータを削除
        for (String s : oldData) {
            deleteMigrationData(s);
        }
    }

    @Transactional
    private void deleteMigrationData(String id) {
        scheduledDeleteRepository.dropHistoriesTable(id);
        scheduledDeleteRepository.dropCategoriesTable(id);
        scheduledDeleteRepository.deleteFromTables(id);
    }
}
