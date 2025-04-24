package com.re_kid.lis.correctratelogmigrationservice.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduledDeleteRepositoryimple implements ScheduledDeleteRepository{
    private final JdbcTemplate jdbcTemplate;
    private final String TABLES_TABLE_NAME = "tables";

    public ScheduledDeleteRepositoryimple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> findOldDataList() {
        List<String> oldDataList = jdbcTemplate.queryForList(
            "SELECT id FROM " + TABLES_TABLE_NAME +
            " WHERE uplode_datetime < NOW() - INTERVAL 14 DAY;",
            String.class
        );
        
        return oldDataList;
    }

    @Override
    public void dropHistoriesTable(String id) {
        String sqlDrop = "DROP TABLE IF EXISTS " + id + "_histories;";
        jdbcTemplate.execute(sqlDrop);
    }

    @Override
    public void dropCategoriesTable(String id) {
        String sqlDrop = "DROP TABLE IF EXISTS " + id + "_categories;";
        jdbcTemplate.execute(sqlDrop);
    }

    @Override
    public void deleteFromTables(String id) {
        String sqlDelete = "DELETE FROM tables WHERE id = '" + id + "'";
        jdbcTemplate.update(sqlDelete);
    }

}
