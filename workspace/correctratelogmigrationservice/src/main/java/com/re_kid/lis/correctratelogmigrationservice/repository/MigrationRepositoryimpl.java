package com.re_kid.lis.correctratelogmigrationservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.re_kid.lis.correctratelogmigrationservice.obj.Category;
import com.re_kid.lis.correctratelogmigrationservice.obj.History;

@Repository
public class MigrationRepositoryimpl implements MigrationRepository{
    private final JdbcTemplate jdbcTemplate;
    private final String tableName = "tables";

    public MigrationRepositoryimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean isExist(String tempId) {
        // IDの存在チェック
        Integer count = jdbcTemplate.queryForObject(
            "SELECT count(id) FROM " + tableName + " WHERE id = ?",
            Integer.class,
            tempId);
        return count >= 1;
    }

    @Override
    public void insertId(String id) {
        LocalDateTime datetime = LocalDateTime.now();
        jdbcTemplate.update("INSERT INTO " + tableName + " VALUES (?, ?)", id, datetime);
    }

    @Override
    public void createCategoryTable(String id, List<Category> categoryList) {
        String categoryTableName = id + "_categories";
        String sqlCreate = "CREATE TABLE " + categoryTableName + "(" +
            "id INTEGER(8) PRIMARY KEY" +
            ", category_name VARCHAR(64) NOT NULL);";
        jdbcTemplate.execute(sqlCreate);
        for (Category category : categoryList) {
            int categoryId = category.getId();
            String categoryName = category.getCategoryName();
            jdbcTemplate.update("INSERT INTO " + categoryTableName + " Values(?, ?);",
                categoryId,
                categoryName);
        }
    }

    @Override
    public void createHistoryTable(String id, List<History> historyList) {
        String historyTableName = id + "_histories";
        String sqlCreate = "CREATE TABLE " + historyTableName + "(" +
            "_id INTEGER PRIMARY KEY" +
            ", category_id INTEGER NOT NULL" +
            ", learned_date VARCHAR(10) NOT NULL" +
            ", learned_time VARCHAR(5) NOT NULL" +
            ", correct_number INTEGER NOT NULL" +
            ", entire_number INTEGER NOT NULL" +
            ", correct_rate DOUBLE NOT NULL);";
            jdbcTemplate.execute(sqlCreate);
            for (History history : historyList) {
                jdbcTemplate.update("INSERT INTO " + historyTableName + " Values(?, ?, ?, ?, ?, ?, ?);",
                    history.get_id(),
                    history.getCategory_id(),
                    history.getLearned_date(),
                    history.getLearned_time(),
                    history.getCorrect_number(),
                    history.getEntire_number(),
                    history.getCorrect_rate());
            }
    }

    @Override
    public List<Category> selectAllCategories(String id) {
        List<Category> categoryList = jdbcTemplate.query(
            "SELECT * FROM " + id + "_categories;",
            new BeanPropertyRowMapper<>(Category.class));
            return categoryList;
    }

    @Override
    public List<History> selectAllHistories(String id) {
        List<History> categoryList = jdbcTemplate.query(
            "SELECT * FROM " + id + "_histories;",
            new BeanPropertyRowMapper<>(History.class));
            return categoryList;
    }
}
