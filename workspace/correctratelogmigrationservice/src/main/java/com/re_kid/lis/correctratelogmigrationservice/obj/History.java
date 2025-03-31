package com.re_kid.lis.correctratelogmigrationservice.obj;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    
    public void set_id(int _id) {
        this._id = _id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public void setLearned_date(String learned_date) {
        this.learned_date = learned_date;
    }
    public void setLearned_time(String learned_time) {
        this.learned_time = learned_time;
    }
    public void setCorrect_number(int correct_number) {
        this.correct_number = correct_number;
    }
    public void setEntire_number(int entire_number) {
        this.entire_number = entire_number;
    }
    public void setCorrect_rate(double correct_rate) {
        this.correct_rate = correct_rate;
    }
    public static List<String> historyList2StringList(List<History> historyList) {
        ObjectMapper mapper = new ObjectMapper();
        List<String> stringList = new ArrayList<>();
        for (History history : historyList) {
            try {
                stringList.add(mapper.writeValueAsString(history));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }
}
