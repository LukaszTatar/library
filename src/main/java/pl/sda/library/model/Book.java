package pl.sda.library.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    int id;
    String author;
    String title;
    LocalDate dateOfReturn;

    @JsonGetter
    public int getId() {
        return id;
    }
    @JsonIgnore
    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter
    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }
    @JsonIgnore
    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Book() {
    }

    public Book(int id, String author, String title, LocalDate dateOfReturn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.dateOfReturn = dateOfReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //jezeli dwa obiekty maja ten sa hashcode to equals moze (ale nie musi) zwrocic true.
    //jeżeli dwa obiekty mają różne hashcode to equal zawsze false
}
