package com.re_kid.lis.correctratelogmigrationservice.obj;

public class Category {
    private final int _id;
    private final String categoryName;
    public Category(int _id, String categoryName) {
        this._id = _id;
        this.categoryName = categoryName;
    }
    public int getId() {
        return _id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    
}
