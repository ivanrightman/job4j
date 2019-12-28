package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        int h = (p / 2) / 2;
        int l = h * k;
        int s = l * h;
        return s;
    }

    public static void main(String[] args) {
        int p = 10;
        int k = 4;
        double result1 = square(p, k);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result1);
    }
}
