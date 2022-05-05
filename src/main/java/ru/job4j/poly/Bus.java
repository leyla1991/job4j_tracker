package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        int numRoute = 451;
    }

    @Override
    public void passenger(int count) {
        count = 40;
    }

    @Override
    public int refuel(int gaz, int price) {
        return gaz *= price;
    }
}
