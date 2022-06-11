package ru.job4j.stream;

import java.util.Comparator;

public class SortByCity implements Comparator<Address> {
    @Override
    public int compare(Address city1, Address city2) {
        return city1.getCity().compareTo(city2.getCity());
    }
}
