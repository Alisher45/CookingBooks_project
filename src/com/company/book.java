package com.company;

import java.io.Serializable;

public class book extends bookstore implements Serializable {

    private String author;

    private String description;

    private int graduate;


    public book(Long id, String name, String product, int sold,  String genre, int count, int price, String author, int graduate, String description) {
        super(id, product,genre,name,price, sold,  count);
        this.author = author;
        this.graduate = graduate;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGraduate() {
        return graduate;
    }

    public void setGraduate(int graduate) {
        this.graduate = graduate;
    }

    @Override
    public String toString() {
        return "book{" +
                "author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", graduate=" + graduate +
                '}';
    }
}
