package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            char left = o1.charAt(i);
            char right = o2.charAt(i);
            rsl = Character.compare(left, right);
            if (rsl != 0) {
                rsl = Character.compare(left, right);
                return rsl;
                }
            }
        return  Integer.compare(o1.length(), o2.length());
    }
}

