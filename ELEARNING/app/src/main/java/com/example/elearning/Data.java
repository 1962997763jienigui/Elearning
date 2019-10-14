package com.example.elearning;

public class Data {
    private String course_title;
    private String course_content;

    public Data(){

    }

    public Data(String course_title, String course_content){
        this.course_title = course_title;
        this.course_content = course_content;
    }

    public String getCourse_title() {
        return course_title;
    }

    public String getCourse_content() {
        return course_content;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public void setCourse_content(String course_content) {
        this.course_content = course_content;
    }
}
