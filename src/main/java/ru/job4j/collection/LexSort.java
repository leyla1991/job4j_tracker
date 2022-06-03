package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
         String[] left1 = left.split("\\.");
        String[] right1 = right.split("\\.");
        return Integer.compare(Integer.parseInt(left1[0]), Integer.parseInt(right1[0]));
    }
}
