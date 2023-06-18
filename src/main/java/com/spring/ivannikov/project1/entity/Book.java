package com.spring.ivannikov.project1.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Book {
    private Long id;
    @NotEmpty(message = "Обязательное поле")
    @Size(min = 2, max = 100, message = "Название книги должно быть длиной от 2 до 100 символов")
    private String author;
    @NotEmpty(message = "Обязательное поле")
    @Size(min = 2, max = 100, message = "Название книги должно быть длиной от 2 до 100 символов")
    private String name;
    @Min(value = 1500, message = "Год должен быть больше, чем 1500")
    private Integer yearOfPublishing;

    public Book() {
    }

    public Book(Long id, String author, String name, Integer yearOfPublishing) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(Integer yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
