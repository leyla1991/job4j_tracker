package ru.job4j.task;

import java.util.List;

public class SubList {

    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(el)) {
                count++;
            }
            if (count > 1) {
            }

        }
        return list;
    }
}
