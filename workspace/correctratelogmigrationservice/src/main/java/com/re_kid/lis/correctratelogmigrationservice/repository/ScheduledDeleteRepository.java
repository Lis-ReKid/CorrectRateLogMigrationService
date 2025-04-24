package com.re_kid.lis.correctratelogmigrationservice.repository;

import java.util.List;

public interface ScheduledDeleteRepository {
    public List<String> findOldDataList();
    public void dropHistoriesTable(String id);
    public void dropCategoriesTable(String id);
    public void deleteFromTables(String id);
}
