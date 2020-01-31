package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int salary, double percent) {
        int year = 0;
        double ostatok = amount + (amount * percent);
        while (ostatok > 0) {
            if (ostatok < (amount + (amount * percent))) {
                ostatok = (ostatok + (ostatok * percent)) - salary;
            } else {
                ostatok -= salary;
            }
            year++;
        }
        return year;
    }
}
