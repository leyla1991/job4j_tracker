package ru.job4j.collection;

import java.util.Comparator;

public class JobRiseByName implements Comparator<Job> {

    @Override
    public int compare(Job name1, Job name2) {
        return name1.getName().compareTo(name2.getName());
    }
}
