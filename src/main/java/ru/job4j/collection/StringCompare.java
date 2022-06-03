package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        for (int i = 0; i < o1.length(); i++) {
            char left = o1.charAt(i);
            char right = o2.charAt(i);
            int rsl1 = Integer.compare(left, right);
            if (o1.length() < o2.length() && rsl1 == 0) {
                rsl = Integer.compare(o1.length(), o2.length());
                break;
            } else if ((o1.length() > o2.length() && rsl1 == 0)) {
                rsl = Integer.compare(o2.length(), o1.length());
                break;
            } else if (rsl1 != 0) {
                rsl = Character.compare(left, right);
                    break;
                }
            rsl = Character.compare(left, right);
            }
        return rsl;
    }
}
