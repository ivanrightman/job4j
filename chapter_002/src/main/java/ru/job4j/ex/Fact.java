package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println("n is " + fact.calc(-1));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should not be 0 or higher");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
