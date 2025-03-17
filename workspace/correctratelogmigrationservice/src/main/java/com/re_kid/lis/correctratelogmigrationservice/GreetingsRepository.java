package com.re_kid.lis.correctratelogmigrationservice;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.re_kid.lis.correctratelogmigrationservice.obj.Greeting;

@Repository
public class GreetingsRepository {
    JdbcTemplate jdbcTemplate;

    public GreetingsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void createGreetingsTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS greetings");
        jdbcTemplate.execute("CREATE TABLE greetings(" +
            "lang VARCHAR(8) UNIQUE, " +
            "greeting VARCHAR(128))");
    }
    
    public void createGreeting() {
        jdbcTemplate.update("INSERT INTO greetings VALUES (?, ?)",
            "en",
            "Hello World!");
    }

    public Greeting findGreetingByLang(String lang) {
        return jdbcTemplate.queryForObject("SELECT * FROM greetings WHERE lang=?",
            new DataClassRowMapper<>(Greeting.class),
            lang);
    }
}
