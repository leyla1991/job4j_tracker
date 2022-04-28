package ru.job4j.inheritance;

public class Doctor extends Profession {

    private double analysis;
    private String inspection;

    public Doctor(String name, String surname, String education, double birthday) {
        super(name, surname, education, birthday);
    }

    public Doctor(double analysis) {
        super();
        this.analysis = analysis;
    }

    public Doctor(String inspection) {
        super();
        this.inspection = inspection;
    }

    public Diagnosis heal(Patient patient) {
        return null;
    }
}
