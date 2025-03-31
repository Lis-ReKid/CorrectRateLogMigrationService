package com.re_kid.lis.correctratelogmigrationservice.obj;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private int id;
    private String categoryName;
    public Category() {}
    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    public int getId() {
        return id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public static List<String> categoryList2StringList(List<Category> categoryList) {
        ObjectMapper mapper = new ObjectMapper();
        List<String> stringList = new ArrayList<>();
        for (Category category : categoryList) {
            try {
                stringList.add(mapper.writeValueAsString(category));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
