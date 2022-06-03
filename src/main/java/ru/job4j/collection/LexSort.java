package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
         String[] left1 = left.split("\\.");
        String[] right1 = right.split("\\.");
        int l1 = 0;
        int r1 = 0;
        for (int i = 0; i < left1.length; i++) {
            l1 = Integer.parseInt(left1[i]);
            r1 = Integer.parseInt(right1[i]);
            if (l1 != r1) {
                break;
            }
        }
                  return Integer.compare(l1, r1);
    }
}
