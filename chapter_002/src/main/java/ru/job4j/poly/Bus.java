package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехалии");
    }

    @Override
    public void passengers(int pasQuantity) {
        System.out.println("В автобус забились: " + pasQuantity + " пассажиров");
    }

    @Override
    public int fillPrice(int fuelQuantity) {
        return fuelQuantity * 50;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        System.out.println("Заправились на: " + bus.fillPrice(200) + " рублей");
        bus.drive();
        bus.passengers(40);
    }
}