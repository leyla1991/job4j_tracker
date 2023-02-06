package ru.job4j.oop.tracker;

public interface UserAction {

    String name();

    boolean execute(Input input, Store tracker);
}
