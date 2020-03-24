package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int result;
        if (n == 0 || n == 1) {
            result = 1;
        } else {
            result = n * n;
        }
        return result;
    }

    public static void main(String[] args) {
        int rsl1 = calc(0);
        int rsl2 = calc(1);
        int rsl3 = calc(4);
        System.out.println(rsl1 + " " + rsl2 + " " + rsl3);
    }
}
