package com.yehyaayash99.hakini.Items;

public class TherapistItem {

    private int id;
    private String author_name, author_img, author_title, country;

    public TherapistItem(int id, String author_name, String author_img, String author_title, String country) {
        this.id = id;
        this.author_name = author_name;
        this.author_img = author_img;
        this.author_title = author_title;
        this.country = country;
    }

    public TherapistItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_img() {
        return author_img;
    }

    public void setAuthor_img(String author_img) {
        this.author_img = author_img;
    }

    public String getAuthor_title() {
        return author_title;
    }

    public void setAuthor_title(String author_title) {
        this.author_title = author_title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
