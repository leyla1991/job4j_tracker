package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String operation;

    public Surgeon(String name, String surname, String education, double birthday, double analysis, String inspection, String operation) {
        super(name, surname, education, birthday, analysis, inspection);
        this.operation = operation;
    }

    public int time(int duty) {
        return 0;
    }
}
