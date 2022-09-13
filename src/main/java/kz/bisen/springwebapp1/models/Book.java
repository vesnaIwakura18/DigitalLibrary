package kz.bisen.springwebapp1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Книга (поля: название, автор, год)
public class Book {
    private int id;
    @NotEmpty(message="Название книги не может быть пустым")
    @Size(min = 2, max = 150, message = "Некорректное название")
    private String name;
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 100, message = "Некорректное имя")
    private String author;
    @Min(value = 0, message = "Некорректная дата публикации")
    private String yearOfProduction;
    private int personId;

    public Book() {

    }

    public Book(int id, String name, String author, String yearOfProduction, int person_id) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
        this.personId = person_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int person_id) {
        this.personId = person_id;
    }
}
