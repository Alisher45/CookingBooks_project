package com.company;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<book> books;
    ArrayList<Orders> orders;
    UserData user;
    ArrayList<UserData> users;
    book book;
    Orders order;
    Long id;

    public PackageData() {}

    public PackageData(String operationType, ArrayList<com.company.book> books, ArrayList<Orders> orders, UserData user, ArrayList<UserData> users, com.company.book book, Orders order, Long id) {
        this.operationType = operationType;
        this.books = books;
        this.orders = orders;
        this.user = user;
        this.users = users;
        this.book = book;
        this.order = order;
        this.id = id;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setBooks(ArrayList<com.company.book> books) {
        this.books = books;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public void setUsers(ArrayList<UserData> users) {
        this.users = users;
    }

    public void setBook(com.company.book book) {
        this.book = book;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<com.company.book> getBooks() {
        return books;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public UserData getUser() {
        return user;
    }

    public ArrayList<UserData> getUsers() {
        return users;
    }

    public com.company.book getBook() {
        return book;
    }

    public Orders getOrder() {
        return order;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", books=" + books +
                ", orders=" + orders +
                ", user=" + user +
                ", users=" + users +
                ", book=" + book +
                ", order=" + order +
                ", id=" + id +
                '}';
    }
}
