package com.re_kid.lis.correctratelogmigrationservice.obj;

public class History {
    private int _id;
    private int category_id;
    private String learned_date;
    private String learned_time;
    private int correct_number;
    private int entire_number;
    private double correct_rate;
    public History() {

    }
    public History(int _id, int category, String learnedDate, String learnedTime, int correctNum, int entireNum,
            double correctRate) {
        this._id = _id;
        this.category_id = category;
        this.learned_date = learnedDate;
        this.learned_time = learnedTime;
        this.correct_number = correctNum;
        this.entire_number = entireNum;
        this.correct_rate = correctRate;
    }
    public int get_id() {
        return _id;
    }
    public int getCategory_id() {
        return category_id;
    }
    public String getLearned_date() {
        return learned_date;
    }
    public String getLearned_time() {
        return learned_time;
    }
    public int getCorrect_number() {
        return correct_number;
    }
    public int getEntire_number() {
        return entire_number;
    }
    public double getCorrect_rate() {
        return correct_rate;
    }
    
}
