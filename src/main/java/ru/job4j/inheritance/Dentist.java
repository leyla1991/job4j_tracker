package ru.job4j.inheritance;

public class Dentist extends Doctor {
    
    private String teeth;

    public Dentist(String name, String surname, String education, double birthday, double analysis, String inspection, String teeth) {
        super(name, surname, education, birthday, analysis, inspection);
        this.teeth = teeth;
    }

    public double price(double sum) {
        return sum;
    }
}
