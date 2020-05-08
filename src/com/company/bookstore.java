package com.company;

import java.io.Serializable;

public class bookstore implements Serializable {
    private Long id;
    private String product;
    private String genre;
    private String name;
    private int price;
    private int sold;
    private int count;

    public bookstore() {

    }

    public bookstore(Long id, String product, String genre, String name, int price, int sold, int count) {
        this.id = id;
        this.product = product;
        this.genre = genre;
        this.name = name;
        this.price = price;
        this.sold = sold;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
