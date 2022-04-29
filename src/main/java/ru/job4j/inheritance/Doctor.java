package ru.job4j.inheritance;

public class Doctor extends Profession {

    private double analysis;
    private String inspection;

    public Doctor(String name, String surname, String education, double birthday, double analysis, String inspection) {
        super(name, surname, education, birthday);
        this.inspection = inspection;
        this.analysis = analysis;
    }

    public Diagnosis heal(Patient patient) {
        return null;
    }
}
