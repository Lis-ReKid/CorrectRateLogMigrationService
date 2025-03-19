package com.re_kid.lis.correctratelogmigrationservice.obj;

import java.util.List;

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
}
