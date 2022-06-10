package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int com = second[0].compareTo(first[0]);
        if (com == 0 && first.length == second.length) {
            for (int i = 1; i < first.length; i++) {
                com = first[i].compareTo(second[i]);
            }
        } else if (com == 0) {
            com = o1.compareTo(o2);
        }
        return com;
    }
}
