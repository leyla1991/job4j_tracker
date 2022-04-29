package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String scheme;

    public Engineer(String name, String surname, String education, double birthday, String scheme) {
        super(name, surname, education, birthday);
        this.scheme = scheme;
    }

    public Plan plan(Customer customer) {
        return null;
    }
}
