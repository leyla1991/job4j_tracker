package ru.job4j.task;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
    String s = list.remove(list.size() - 1);
    if (index < list.size()) {
        list.set(index, s);
    }
    return list;
}
}
