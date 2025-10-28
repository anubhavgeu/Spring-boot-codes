package com.example.quiz_service.model;


public class QuizDto {
    String categoryName;
    Integer numOfQuestion;
    String title;

    QuizDto() {}

    public QuizDto(String categoryName, Integer numOfQuestion, String title) {
        this.categoryName = categoryName;
        this.numOfQuestion = numOfQuestion;
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getNumOfQuestion() {
        return numOfQuestion;
    }

    public void setNumOfQuestion(Integer numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
