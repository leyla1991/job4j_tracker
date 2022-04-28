package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String operation;

    public Surgeon(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    public Surgeon(String inspection, String operation) {
        super(inspection);
        this.operation = operation;
    }

    public int time(int duty) {
        return 0;
    }
}
