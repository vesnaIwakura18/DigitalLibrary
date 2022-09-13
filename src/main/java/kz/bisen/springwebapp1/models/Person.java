package kz.bisen.springwebapp1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Person {
    private int id;

    @NotEmpty(message = "ФИО не может быть пустым")
    @Size(min = 2, max = 100, message = "Слишком короткое либо слишком длинное ФИО")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message ="Некорректное ФИО")
    private String fio;

    @Min(value = 1900, message = "Некорректная дата рождения")
    private String birthDate;


    public Person() {
    }

    public Person(int id, String fio, String birthDate) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
