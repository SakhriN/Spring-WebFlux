package org.example.exercices.exo6.entity;

public class Book {

private int id;
private String title, author;
private static int count = 0;


    public Book() {
        this.id = count++;
    }


    public Book(String title, String author) {
        this.id = count++;
  this.title = title;
  this.author = author;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
