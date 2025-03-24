package com.re_kid.lis.correctratelogmigrationservice.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.lis.correctratelogmigrationservice.obj.MigrationData;
import com.re_kid.lis.correctratelogmigrationservice.repository.MigrationRepository;

@Service
public class MigrationService {
    MigrationRepository migrationRepository;

    public MigrationService(MigrationRepository migrationRepository) {
        this.migrationRepository = migrationRepository;
    }

    @Transactional
    public String issueId(MigrationData data){
        String id;
        do {
            id = generateId();
        } while(migrationRepository.isExist(id));
        migrationRepository.insertId(id);
        migrationRepository.createCategoryTable(id, data.getCategoryList());
        migrationRepository.createHistoryTable(id, data.getHistoryList());
        return id;
    }

    private String generateId() {
        // 大文字なし
        // 数字「０」と小文字「l（エル）」は除外
        String allowedchars = "abcdefghijkmnopqrstuvwxyz123456789";
        // 8桁のランダム文字列を返す
        return RandomStringUtils.random(8, allowedchars);
    }
}
