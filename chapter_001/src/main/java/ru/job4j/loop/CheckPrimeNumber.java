package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int num) {
        boolean prime = true;
        if (num < 2) {
            prime = false;
        }
        for (int i = 2; i <= num / i; i++) {
            if ((num % i) == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
