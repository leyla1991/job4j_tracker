package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Маршрут автобуса 451");
    }

    @Override
    public void passenger(int count) {
        System.out.println("Количество пассажиров в автобусе 40");
    }

    @Override
    public int refuel(int gaz, int price) {
        gaz *= price;
        return gaz;
    }
}
