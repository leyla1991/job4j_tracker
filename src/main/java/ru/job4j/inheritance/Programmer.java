package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String nameCode;

    public Programmer(String name, String surname, String education, double birthday, String scheme, String nameCode) {
        super(name, surname, education, birthday, scheme);
        this.nameCode = nameCode;
    }

    public int numLineCode(int num) {
        return 0;
    }
}
