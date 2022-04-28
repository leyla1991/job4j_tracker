package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String nameCode;

    public Programmer(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    public Programmer(String scheme, String nameCode) {
        super(scheme);
        this.nameCode = nameCode;
    }

    public int numLineCode(int num) {
        return 0;
    }
}
