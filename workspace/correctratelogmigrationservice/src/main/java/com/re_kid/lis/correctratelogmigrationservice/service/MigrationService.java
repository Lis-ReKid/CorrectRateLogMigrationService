package com.re_kid.lis.correctratelogmigrationservice.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.re_kid.lis.correctratelogmigrationservice.obj.Category;
import com.re_kid.lis.correctratelogmigrationservice.obj.History;
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
        migrationRepository.createCategoryTable(id, data.asCategoryList());
        migrationRepository.createHistoryTable(id, data.asHistoryList());
        return id;
    }

    public MigrationData migrate(String id){
        // 存在チェック
        if (!migrationRepository.isExist(id)) {
            throw new NoSuchElementException("データがありません。");
        }
        List<Category> categoryList = migrationRepository.selectAllCategories(id);
        List<History> historyList = migrationRepository.selectAllHistories(id);
        List<String> strCategoryList = Category.categoryList2StringList(categoryList);
        List<String> strHistoryList = History.historyList2StringList(historyList);
        var data = new MigrationData(strHistoryList, strCategoryList);
        return data;
    }

    private String generateId() {
        // 大文字なし
        // 数字「０」と小文字「l（エル）」は除外
        String allowedchars = "abcdefghijkmnopqrstuvwxyz123456789";
        // 8桁のランダム文字列を返す
        return RandomStringUtils.random(8, allowedchars);
    }

}
