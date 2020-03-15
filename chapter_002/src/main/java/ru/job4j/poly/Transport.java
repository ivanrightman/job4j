package ru.job4j.poly;

/**
 * 1. Создайте интерфейс транспорт ru.job4j.poly.Transport;
 * Этот интерфейс будет определять любой вид транспорта.
 * 2. В интерфейсе объявите три метода: ехать (без параметров, без возвращаемого типа), пассажиры (принимает число пассажиров, без возвращаемого типа), заправить (принимает кол-во топлива, возвращает цену).
 * 3. Реализуйте этот интерфейс в классе ru.job4j.poly.Bus.
 * Внутри методов напишите минимально требуемый код.
 */
public interface Transport {
    void drive();
    void passengers(int pasQuantity);
    int fillPrice(int fuelQuantity);

}