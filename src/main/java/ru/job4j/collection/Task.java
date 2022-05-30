package ru.job4j.collection;

public class Task {

    private String number;
    private String description;

    public Task(String number, String description) {
        this.description = description;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
