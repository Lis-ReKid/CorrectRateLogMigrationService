package com.re_kid.lis.correctratelogmigrationservice.obj;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MigrationData {
    final List<String> histories;
    final List<String> categories;

    public MigrationData(List<String> histories, List<String> categories) {
        this.histories = histories;
        this.categories = categories;
    }

    public List<String> getHistories() {
        return histories;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<History> toHistoryList() {
        List<History> historyList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (String historyString : this.histories) {
            History history = null;
            try {
                history = mapper.readValue(historyString, History.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            historyList.add(history);
        }
        return historyList;
    }

    public List<Category> toCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (String categoryString : this.categories) {
            Category category = null;
            try {
                category = mapper.readValue(categoryString, Category.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            categoryList.add(category);
        }
        return categoryList;
    }
}
