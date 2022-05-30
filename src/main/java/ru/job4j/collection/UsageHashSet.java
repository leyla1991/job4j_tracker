package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {

    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("LADA");
        autos.add("BMV");
        autos.add("VOLVO");
        autos.add("TOYOTA");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
