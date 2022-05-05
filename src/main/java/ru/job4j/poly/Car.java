package ru.job4j.poly;

public class Car implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по шоссе");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляют бензином");
    }
}
