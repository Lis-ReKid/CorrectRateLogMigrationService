package com.re_kid.lis.correctratelogmigrationservice.obj;

public class History {
    private final int id;
    private final int category;
    private final String learnedDate;
    private final String learnedTime;
    private final int correctNum;
    private final int entireNum;
    private final double correctRate;
    public History(int id, int category, String learnedDate, String learnedTime, int correctNum, int entireNum,
            double correctRate) {
        this.id = id;
        this.category = category;
        this.learnedDate = learnedDate;
        this.learnedTime = learnedTime;
        this.correctNum = correctNum;
        this.entireNum = entireNum;
        this.correctRate = correctRate;
    }
    public int getId() {
        return id;
    }
    public int getCategory() {
        return category;
    }
    public String getLearnedDate() {
        return learnedDate;
    }
    public String getLearnedTime() {
        return learnedTime;
    }
    public int getCorrectNum() {
        return correctNum;
    }
    public int getEntireNum() {
        return entireNum;
    }
    public double getCorrectRate() {
        return correctRate;
    }
    
}
