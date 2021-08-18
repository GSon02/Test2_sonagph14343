package com.example.test2_sonagph14343.Model;


public class Notes {
    private String Content;
    private String Date;

    public Notes() {
    }

    public Notes(String content, String date) {
        Content = content;
        Date = date;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return Content +
                Date;
    }
}
