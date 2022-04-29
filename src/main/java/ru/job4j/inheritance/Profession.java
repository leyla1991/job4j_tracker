package ru.job4j.inheritance;

public class Profession {

    private String name;
    private String surname;
    private String education;
    private double birthday;

    public Profession(String name, String surname, String education, double birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public double getBirthday() {
        return birthday;
    }
}
