package ru.job4j.task;

import java.util.List;

public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        int rsl = -1;
        if (left.contains(str) && right.contains(str)) {
            left.remove(str);
            }
        left.addAll(right);
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i).contains(str)) {
                rsl = i;
            }
        }

        return rsl;
    }
}
