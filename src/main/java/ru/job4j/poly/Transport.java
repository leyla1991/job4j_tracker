package ru.job4j.poly;

public interface Transport {

    void drive();

    void passenger(int count);

    int refuel(int gaz, int price);
}
