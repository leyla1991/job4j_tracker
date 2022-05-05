package ru.job4j.poly;

public class AllVehicle {

    public static void main(String[] args) {
        Vehicle lada = new Car();
        Vehicle mercedes = new Car();
        Vehicle subaru = new Car();
        Vehicle aeroflot = new Plane();
        Vehicle s7 = new Plane();
        Vehicle rusline = new Plane();
        Vehicle rex = new Train();
        Vehicle sapsan = new Train();
        Vehicle lastochka = new Train();

        Vehicle[] vehicles = new Vehicle[]{lada, mercedes, subaru, aeroflot, s7, rusline, rex, sapsan, lastochka};
        for (Vehicle v : vehicles) {
            v.move();
            v.fuel();
        }
    }
}
