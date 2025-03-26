package com.re_kid.lis.correctratelogmigrationservice.repository;

import java.util.List;

import com.re_kid.lis.correctratelogmigrationservice.obj.Category;
import com.re_kid.lis.correctratelogmigrationservice.obj.History;

public interface MigrationRepository {
    boolean isExist(String tempId);
    void insertId(String id);
    void createCategoryTable(String id, List<Category> categoryList);
    void createHistoryTable(String id, List<History> historyList);
    List<Category> selectAllCategories(String id);
    List<History> selectAllHistories(String id);
}
