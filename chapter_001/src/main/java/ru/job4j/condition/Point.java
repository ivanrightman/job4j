package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        int x = x2 - x1;
        int y = y2 - y1;
        double first = Math.pow(x, 2);
        double second = Math.pow(y, 2);
        double result = first + second;
        return Math.sqrt(result);
    }

    public static void main(String[] args) {
        int x1 = 2;
        int x2 = 3;
        int y1 = 4;
        int y2 = 5;
        double result = distance(x1, y1, x2, y2);
        System.out.println("result (" + x1 + ", " + y1 + ")"
                + " to (" + x2 + ", " + y2 + ") " + result);
    }
}
