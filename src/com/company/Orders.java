package com.company;

import java.io.Serializable;

public class Orders implements Serializable {
    private Long id;
    private int booksId;
    private String name;
    private String surname;

    public Orders(){}

    public Orders(Long id, int booksId, String name, String surname) {
        this.id = id;
        this.booksId = booksId;
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBooksId(int booksId) {
        this.booksId = booksId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public int getBooksId() {
        return booksId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", booksId=" + booksId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
