package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String house;

    public Builder(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    public Builder(String scheme, String house) {
        super(scheme);
        this.house = house;
    }

    public double price(double sum) {
        return 0.0;
    }
}
